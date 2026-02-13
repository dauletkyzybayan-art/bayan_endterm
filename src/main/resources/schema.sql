DROP TABLE IF EXISTS books;

CREATE TABLE books (
                       id BIGSERIAL PRIMARY KEY,
                       type VARCHAR(20) NOT NULL,
                       title VARCHAR(200) NOT NULL,
                       author VARCHAR(200) NOT NULL,
                       year_published INT,
                       isbn VARCHAR(50),
                       price NUMERIC(10,2),
                       file_format VARCHAR(30),
                       file_size_mb NUMERIC(10,2),
                       pages INT,
                       cover_type VARCHAR(30)
);

INSERT INTO books(type, title, author, year_published, isbn, price, file_format, file_size_mb, pages, cover_type)
VALUES
    ('EBOOK', 'Clean Code', 'Robert C. Martin', 2008, '978-0132350884', 12.99, 'PDF', 5.20, NULL, NULL),
    ('PRINTED', 'Introduction to Algorithms', 'Cormen et al.', 2009, '978-0262033848', 79.99, NULL, NULL, 1312, 'HARD');

