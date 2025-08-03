# demo-crud-java

A simple CRUD webapp that manipulates the contents of a PostgreSQL database.

## Features

- Basic CRUD operations on a single table.

## Installation

/

## Build

### Dependencies

- Java 17
- Maven
- Docker Compose

### Setup

Clone the repository on your system and `cd` into it.

Start the DB (and its [Adminer](https://www.adminer.org/en/) interface) with `sudo docker-compose up -d`.

Start the webapp with `./run.sh`

The webapp is available at `http://localhost:8093`.

The DB interface is available at `http://localhost:8079`.

The username is `admin`.
The password is `admin`.
The DB name is `demo-crud-java`.

Fill the DB with the SQL query in `table_gen.sql`.

Realign the IDs sequence with `SELECT setval(pg_get_serial_sequence('clients', 'id'), (SELECT MAX(id) FROM clients));`.

### To wipe the DB

```sh
sudo docker-compose stop
sudo docker system prune
sudo rm -vrf .db
```

Then re-fill it with the SQL query in `table_gen.sql`.

## Credits

/
