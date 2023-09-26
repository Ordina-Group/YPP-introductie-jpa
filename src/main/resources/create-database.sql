ALTER TABLE book DROP CONSTRAINT author_uuid_fk;
ALTER TABLE book_authors DROP CONSTRAINT author_uuid_fk;
ALTER TABLE book_authors DROP CONSTRAINT book_isbn_fk;
ALTER TABLE inventory DROP CONSTRAINT book_isbn_fk;

DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS book_authors;
DROP TABLE IF EXISTS inventory;

CREATE TABLE author (
    uuid            UUID            NOT NULL,
    first_name      VARCHAR(255)    NOT NULL,
    initials        VARCHAR(10)     NOT NULL,
    last_name       VARCHAR(255)    NOT NULL,
    date_of_birth   DATE            NOT NULL,

    PRIMARY KEY(uuid)
);

CREATE TABLE book (
    isbn            VARCHAR(20)     NOT NULL,
    title           VARCHAR(255)    NOT NULL,
    author_uuid     UUID            NOT NULL,
    genre           VARCHAR(50)     NOT NULL,
    description     TEXT            NOT NULL,
    rating          INT             NOT NULL,

    PRIMARY KEY(isbn),

    CONSTRAINT author_uuid_fk
      FOREIGN KEY (author_uuid)
          REFERENCES author(uuid)
          ON DELETE CASCADE
);

CREATE TABLE book_authors (
    book_isbn       VARCHAR(20) NOT NULL,
    author_uuid     UUID        NOT NULL,

    PRIMARY KEY(book_isbn, author_uuid),

    CONSTRAINT book_isbn_fk
      FOREIGN KEY (book_isbn)
          REFERENCES book(isbn)
          ON DELETE SET NULL,

    CONSTRAINT author_uuid_fk
      FOREIGN KEY (author_uuid)
          REFERENCES author(uuid)
          ON DELETE SET NULL
);

CREATE TABLE inventory (
    barcode        VARCHAR(50)         NOT NULL,
    quantity       INT                 NOT NULL,
    price_in_euro  DOUBLE PRECISION    NOT NULL,
    book_isbn      VARCHAR(20)         NOT NULL,

    PRIMARY KEY(barcode),
    CONSTRAINT book_isbn_fk
       FOREIGN KEY (book_isbn)
           REFERENCES book(isbn)
           ON DELETE SET NULL
);

-- uuid,first_name,initials,last_name,date_of_birth
-- 123e4567-e89b-12d3-a456-426614174000,John,D,Doe,1980-01-01
-- 223e4567-e89b-12d3-a456-426614174001,Jane,E,Doe,1985-01-01
INSERT INTO author (uuid, first_name, initials, last_name, date_of_birth)
VALUES
    ('123e4567-e89b-12d3-a456-426614174000', 'Jhon', 'D', 'Doe','1980-01-01'),
    ('223e4567-e89b-12d3-a456-426614174001', 'Jane', 'E', 'Doe','1985-01-01');


-- isbn,title,author_uuid,genre,description,rating
-- 978-3-16-148410-0,Book One,123e4567-e89b-12d3-a456-426614174000,ACTION,An action-packed book.,4
-- 978-3-17-148410-1,Book Two,223e4567-e89b-12d3-a456-426614174001,ADVENTURE,An adventurous book.,5
INSERT INTO book(isbn, title, author_uuid, genre, description, rating)
VALUES
    ('978-3-16-148410-0', 'Book One', '123e4567-e89b-12d3-a456-426614174000', 'ACTION','An action-packed book.', 4),
    ('978-3-16-148410-1', 'Book Two', '123e4567-e89b-12d3-a456-426614174000', 'ADVENTURE','An adventurous book.', 5);

-- book_isbn,author_uuid
-- 978-3-16-148410-0,223e4567-e89b-12d3-a456-426614174001
-- 978-3-17-148410-1,123e4567-e89b-12d3-a456-426614174000
INSERT INTO book_authors(book_isbn, author_uuid)
VALUES
    ('978-3-16-148410-0', '223e4567-e89b-12d3-a456-426614174001'),
    ('978-3-16-148410-1', '123e4567-e89b-12d3-a456-426614174000');


-- barcode,quantity,price_in_euro,book_isbn
-- BC-001,5,9.99,978-3-16-148410-0
-- BC-002,3,12.99,978-3-17-148410-1
INSERT INTO inventory(barcode, quantity, price_in_euro, book_isbn)
VALUES
    ('BC-001', 5, 9.99, '978-3-16-148410-0'),
    ('BC-002', 3,12.99, '978-3-16-148410-1');