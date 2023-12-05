INSERT INTO users (id, user_type, name, document, email, password_hash, balance)
VALUES
    (1, 'COMMON', 'John Doe', '123456789', 'john@example.com', '$2a$12$v.yE/ZC8lunp4VVxbw0A5u59l0YcG1jCDWFWrrlih5ddYt2mFiNtC', 1000.00),
    (2, 'MERCHANT', 'Jane Smith', '987654321', 'jane@example.com', '$2a$12$pq7VT0KTp8gXz2lIEdSWTOJfhNTNIAA0XeBxRSOQWBajYlXjHBCvq', 1500.00);

INSERT INTO transfers (id, amount, sender_id, receiver_id, timestamp)
VALUES
    (1, 100.00, 1, 2, '2023-08-15 10:00:00'),
    (2, 50.00, 1, 2, '2023-08-15 11:30:00');
