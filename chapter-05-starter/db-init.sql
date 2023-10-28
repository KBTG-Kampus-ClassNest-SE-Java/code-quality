-- Drop tables if they exist
DROP TABLE IF EXISTS wallet CASCADE;

CREATE TABLE wallet
(
    id          SERIAL PRIMARY KEY,
    wallet_name VARCHAR(255) UNIQUE NOT NULL,
    active      BOOLEAN             NOT NULL
);

-- Initial data
INSERT INTO wallet(wallet_name, active)
VALUES ('Java Wallet', true);
INSERT INTO wallet(wallet_name, active)
VALUES ('Kotlin Wallet', true);
