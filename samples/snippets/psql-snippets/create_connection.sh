#!/bin/bash

# Set the connection variables for psql.
# The following statements use the existing value of the variable if it has
# already been set, and otherwise assigns a default value.
export PGHOST="${PGHOST:-localhost}"
export PGPORT="${PGPORT:-5432}"
export PGDATABASE="${PGDATABASE:-example-db}"

# Connect to Cloud Spanner using psql through PGAdapter
# and execute a simple query.
psql -c "select 'Hello world!' as hello"
