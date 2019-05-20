CREATE TABLE account (
  account_id BIGINT NOT NULL,
  name CHARACTER VARYING NOT NULL,
  balance NUMERIC(18, 6) NOT NULL DEFAULT 0.0,
  color VARCHAR(16) NULL DEFAULT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

-- sequence setup

CREATE SEQUENCE account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE account_id_seq OWNED BY account.account_id;

ALTER TABLE ONLY account
  ALTER COLUMN account_id SET DEFAULT nextval('account_id_seq'::regclass);

ALTER TABLE ONLY account
    ADD CONSTRAINT account_pkey PRIMARY KEY (account_id);
