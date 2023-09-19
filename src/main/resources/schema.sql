DROP TABLE IF EXISTS books, authors;

CREATE TABLE books
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    author_id BIGINT       NOT NULL,
    title     VARCHAR(250) NOT NULL,
    price_old INTEGER DEFAULT NULL,
    price     INTEGER DEFAULT NULL
--     CONSTRAINT fk_author_id,
--         foreign key (author_id)
--             REFERENCES authors(id)
);

CREATE TABLE authors
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_author VARCHAR(320) NOT NULL UNIQUE,
    biography   TEXT,
    book_id     BIGINT       NOT NULL
--     CONSTRAINT fk_book_id,
--         FOREIGN KEY (book_id)
--             REFERENCES books (id)
);