# How to PG Admin

- Run docker compose
  - Open terminal
  - Cd into this directory
  - run command: docker compose up
- Go to the [pg admin web ui](http://localhost:5431)
- Login with default credentials (see [yml](docker-compose.yml))
- Add a new server using the credential and hostname from [yml](docker-compose.yml)
  - Note: since docker and pgAdmin both run within a docker compose the hostname needed for pgadmin is not localhost
- Congratulations you have acces to your postgress db

## Adding Schema + tables

- In pgadmin got to the query tool (or alt-shift-q)
- Create a schema using sql
- Create a table using sql
- Insert data in the table
- Query the data from the table

## Using IntelliJ Ultimate

- Open the database tab
- Add a postgres database
- Open a query console
- Run the SQL queries
