-- Liquibase formatted SQL
-- changeset you:5
-- Insert test data into author table
INSERT INTO author (uuid, first_name, initials, last_name, date_of_birth)
VALUES ('123e4567-e89b-12d3-a456-426614174000', 'John', 'D', 'Doe', '1980-01-01'),
       ('223e4567-e89b-12d3-a456-426614174001', 'Jane', 'E', 'Doe', '1985-01-01');

-- changeset you:6
-- Insert test data into book table
INSERT INTO book (isbn, title, author_uuid, genre, description, rating)
VALUES ('978-3-16-148410-0', 'Book One', '123e4567-e89b-12d3-a456-426614174000', 'ACTION', 'An action-packed book.', 4),
       ('978-3-17-148410-1', 'Book Two', '223e4567-e89b-12d3-a456-426614174001', 'ADVENTURE', 'An adventurous book.',
        5);

-- changeset you:7
-- Insert test data into inventory table
INSERT INTO inventory (barcode, quantity, price_in_euro, book_isbn)
VALUES ('BC-001', 5, 9.99, '978-3-16-148410-0'),
       ('BC-002', 5, 19.99, '978-3-16-148410-0'),
       ('BC-003', 3, 12.99, '978-3-17-148410-1');

-- changeset you:8
-- Insert test data into book_coauthors table
INSERT INTO book_coauthors (book_isbn, author_uuid)
VALUES ('978-3-16-148410-0', '223e4567-e89b-12d3-a456-426614174001'),
       ('978-3-17-148410-1', '123e4567-e89b-12d3-a456-426614174000');
