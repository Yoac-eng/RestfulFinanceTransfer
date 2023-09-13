CREATE SEQUENCE users_id_seq START 3 OWNED BY users.id;

ALTER TABLE users ALTER COLUMN id SET DEFAULT nextval('users_id_seq');

CREATE SEQUENCE transfers_id_seq START 3 OWNED BY transfers.id;

ALTER TABLE transfers ALTER COLUMN id SET DEFAULT nextval('transfers_id_seq');
