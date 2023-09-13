 CREATE TABLE users (
    id BIGINT PRIMARY KEY,
    user_type VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    document VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    password_hash VARCHAR(255),
    balance NUMERIC(19, 2)
);

CREATE TABLE transfers (
    id BIGINT PRIMARY KEY,
    amount NUMERIC(19, 2),
    sender_id BIGINT,
    receiver_id BIGINT,
    timestamp TIMESTAMP,
    FOREIGN KEY (sender_id) REFERENCES users(id),
    FOREIGN KEY (receiver_id) REFERENCES users(id)
);

