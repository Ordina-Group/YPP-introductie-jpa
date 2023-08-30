-- 1_create_tables.sql

--liquibase formatted sql

--changeset you:create-book-table
CREATE TABLE author
(
    uuid       UUID PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    initials   VARCHAR(10),
    last_name  VARCHAR(255) NOT NULL
);
--changeset you:create-genre-table
CREATE TABLE genre
(
    name VARCHAR(50) PRIMARY KEY
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
    isbn             VARCHAR(50) PRIMARY KEY,
    title            VARCHAR(255) NOT NULL,
    main_author_uuid UUID,
    category_name    VARCHAR(50),
    details_id       BIGINT,
    --todo voorbeeld van one to many
    FOREIGN KEY (main_author_uuid) REFERENCES author (uuid),
    --todo voorbeeld van one to many, of embeddable
    FOREIGN KEY (category_name) REFERENCES genre (name),
    -- todo voorbeeld van one to one -> beter voorbeeld bedenken
    FOREIGN KEY (details_id) REFERENCES book_details (id)
);
