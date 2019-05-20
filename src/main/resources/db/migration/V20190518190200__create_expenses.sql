CREATE TABLE expense (
  expense_id BIGINT NOT NULL,
  account_id BIGINT DEFAULT NULL,
  category_id BIGINT DEFAULT NULL,
  description CHARACTER VARYING NOT NULL,
  price NUMERIC(18, 6) NOT NULL DEFAULT 0.0,
  expense_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

-- sequence setup

CREATE SEQUENCE expense_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE expense_id_seq OWNED BY expense.expense_id;

ALTER TABLE ONLY expense
  ALTER COLUMN expense_id SET DEFAULT nextval('expense_id_seq'::regclass);

ALTER TABLE ONLY expense
    ADD CONSTRAINT expense_pkey PRIMARY KEY (expense_id);

-- indexes

CREATE INDEX index_expense_on_account_id ON expense USING btree (account_id);
CREATE INDEX index_expense_on_category_id ON expense USING btree (category_id);

-- foreign keys

ALTER TABLE ONLY expense
    ADD CONSTRAINT fk_myfin_expense_on_account
    FOREIGN KEY (account_id) REFERENCES account(account_id);

ALTER TABLE ONLY expense
    ADD CONSTRAINT fk_myfin_expense_on_category
    FOREIGN KEY (category_id) REFERENCES category(category_id);
