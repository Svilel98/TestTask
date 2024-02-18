-- liquibase formatted sql

-- changeset ihlopachev:1
CREATE TABLE Books
(
    id                    BIGSERIAL PRIMARY KEY,
    isbn                  bigint,
    title                 text             NOT NULL,
    series_title          text,
    series_release_number text,
    authors               text             NOT NULL,
    publisher             text,
    language              text,
    description           text,
    num_pages             text,
    format                text,
    genres                text             NOT NULL,
    publication_date      DATE,
    rating_score          double precision NOT NULL DEFAULT 0,
    num_ratings           double precision NOT NULL DEFAULT 0,
    num_reviews           double precision NOT NULL DEFAULT 0,
    current_readers       double precision,
    want_to_read          double precision,
    price                 double precision,
    url text  NOT NULL
);


