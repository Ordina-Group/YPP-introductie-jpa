-- 1_create_tables.sql

--liquibase formatted sql

--changeset you:create-book-table
CREATE TABLE author
(
    uuid          UUID PRIMARY KEY NOT NULL,
    first_name    VARCHAR(255)     NOT NULL,
    initials      VARCHAR(10),
    last_name     VARCHAR(255)     NOT NULL,
    date_of_birth DATE             NOT NULL
);

--changeset you:create-book-details-table
CREATE TABLE book_details
(
    id            BIGSERIAL PRIMARY KEY,
    description   TEXT,
    rating        INTEGER,
    price_in_euro FLOAT
);
--changeset you:create-book-table
CREATE TABLE book
(
    isbn        VARCHAR(50) PRIMARY KEY NOT NULL,
    title       VARCHAR(255)            NOT NULL,
    author_uuid UUID,
    genre       VARCHAR(50),
    description TEXT,
    rating      INT,
    details_id  BIGINT,
    FOREIGN KEY (author_uuid) REFERENCES author (uuid),
    FOREIGN KEY (details_id) REFERENCES book_details (id)
);

--changeset you:create-inventory-table
CREATE TABLE inventory
(
    barcode       VARCHAR(50) PRIMARY KEY NOT NULL,
    quantity      INT,
    price_in_euro DOUBLE PRECISION,
    book_isbn     VARCHAR(20),
    FOREIGN KEY (book_isbn) REFERENCES BOOK (isbn)
);

CREATE TABLE book_authors
(
    book_isbn   VARCHAR(20),
    author_uuid UUID,
    FOREIGN KEY (book_isbn) REFERENCES BOOK (isbn),
    FOREIGN KEY (author_uuid) REFERENCES AUTHOR (uuid)
);




