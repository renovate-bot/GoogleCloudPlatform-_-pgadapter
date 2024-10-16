/*
Copyright 2024 Google LLC
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package samples

// [START spanner_query_data]
import (
	"context"
	"fmt"

	"github.com/jackc/pgx/v5"
)

func QueryData(host string, port int, database string) error {
	ctx := context.Background()
	connString := fmt.Sprintf(
		"postgres://uid:pwd@%s:%d/%s?sslmode=disable",
		host, port, database)
	conn, err := pgx.Connect(ctx, connString)
	if err != nil {
		return err
	}
	defer conn.Close(ctx)

	rows, err := conn.Query(ctx, "SELECT singer_id, album_id, album_title "+
		"FROM albums")
	defer rows.Close()
	if err != nil {
		return err
	}
	for rows.Next() {
		var singerId, albumId int64
		var title string
		err = rows.Scan(&singerId, &albumId, &title)
		if err != nil {
			return err
		}
		fmt.Printf("%v %v %v\n", singerId, albumId, title)
	}

	return rows.Err()
}

// [END spanner_query_data]
