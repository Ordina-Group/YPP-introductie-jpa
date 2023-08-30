-- 2_insert_initial_book.sql

--liquibase formatted sql

--changeset you:insert-initial-author
INSERT INTO author (uuid, first_name, initials, last_name)
VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'John', 'D.', 'Doe');

--changeset you:insert-initial-genre
INSERT INTO genre (name)
VALUES ('Fiction');

--changeset you:insert-initial-book-details
INSERT INTO book_details (description, rating, price_in_euro)
VALUES ('This is a sample book tekst lenght is long 123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890',
        5, 19.99);

-- Obtain the last inserted id for book_details, assuming it is 1 for this example

--changeset you:insert-initial-book
INSERT INTO book (isbn, title, main_author_uuid, category_name, details_id)
VALUES ('978-3-16-148410-0', 'Sample Book', 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Fiction', 1);


