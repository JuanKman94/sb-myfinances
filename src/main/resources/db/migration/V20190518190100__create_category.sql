CREATE TABLE category (
  category_id BIGINT NOT NULL,
  parent_category_id BIGINT DEFAULT NULL,
  name VARCHAR(32) NOT NULL,
  icon VARCHAR(32),
  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NULL
);

-- sequence setup

CREATE SEQUENCE category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE category_id_seq OWNED BY category.category_id;

ALTER TABLE ONLY category
  ALTER COLUMN category_id SET DEFAULT nextval('category_id_seq'::regclass);

ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey PRIMARY KEY (category_id);

-- foreign keys

ALTER TABLE ONLY category
    ADD CONSTRAINT fk_myfin_parent_category_on_category
    FOREIGN KEY (parent_category_id) REFERENCES category(category_id);
