SET client_encoding = 'UTF8';
SET default_with_oids = false;

CREATE TABLE quote (
    id integer NOT NULL,
    quote text NOT NULL
);

CREATE SEQUENCE "Quotes_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "Quotes_id_seq" OWNED BY quote.id;

ALTER TABLE ONLY quote ALTER COLUMN id SET DEFAULT nextval('"Quotes_id_seq"'::regclass);

ALTER TABLE ONLY quote
    ADD CONSTRAINT quote_pk PRIMARY KEY (id);

ALTER TABLE ONLY quote
    ADD CONSTRAINT quote_unique UNIQUE (quote);
