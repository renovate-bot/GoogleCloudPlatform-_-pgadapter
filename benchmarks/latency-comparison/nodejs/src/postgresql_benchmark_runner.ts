// Copyright 2024 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import {Client} from "pg";
import {Config, generate_random_string} from "./index";
import {randomInt} from "crypto";

let totalOperations: number;
let progress: number;
let numNull: number;
let numNotNull: number;

export async function runBenchmark(config: Config, host: string, port: number): Promise<number[][]> {
  progress = 0;
  numNull = 0;
  numNotNull = 0;
  totalOperations = config.numClients * config.numOperations;
  const progressPrinter = setInterval(printProgress, 1000);
  
  const clients: Client[] = [];
  for (let i=0; i<config.numClients; i++) {
    const client = new Client({
      host: host,
      port: port,
      database: config.database,
    });
    await client.connect();
    clients.push(client);
  }
  
  const promises: Promise<number[]>[] = [];
  for (let client of clients) {
    promises.push(run(client, config));
  }
  const results = await Promise.all(promises);

  // Close the connections.
  for (let client of clients) {
    await client.end();
  }
  clearInterval(progressPrinter);
  printProgress();
  return results;
}

async function run(client: Client, config: Config): Promise<number[]> {
  const results: number[] = [];
  for (let i= 0; i < config.numOperations; i++) {
    const start = performance.now();
    const id: number = getRandomInt(100000);
    if (config.readWrite) {
      await executeUpdate(client, config, id);
    } else {
      await executeQuery(client, config, id);
    }
    progress++;
    const elapsed = performance.now() - start;
    results.push(elapsed);
    if (config.wait > 0) {
      const t = randomInt(0, 2 * config.wait);
      await new Promise(f => setTimeout(f, t));
    }
  }
  return results;
}

async function executeQuery(client: Client, config: Config, id: number) {
  const result = await client.query(config.sql, [id]);
  for (const row of result.rows) {
    if (row['col_varchar']) {
      numNotNull++;
    } else {
      numNull++;
    }
  }
}

async function executeUpdate(client: Client, config: Config, id: number) {
  try {
    await client.query('begin');
    await client.query(config.sql, [generate_random_string(64), id]);
    await client.query('commit');
  } catch (e) {
    await client.query('rollback');
    throw e;
  }
}

function printProgress() {
  if (process.stdout.clearLine) {
    process.stdout.clearLine(0);
    process.stdout.cursorTo(0);
  }
  process.stdout.write(`${progress}/${totalOperations}`);
}

function getRandomInt(max: number) {
  return Math.floor(Math.random() * max);
}
