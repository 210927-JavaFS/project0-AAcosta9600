
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customer_info;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
	username VARCHAR(15) PRIMARY KEY,
	passcode VARCHAR(20) NOT NULL,
	admin_level VARCHAR(10) DEFAULT 'customer'
);


CREATE TABLE accounts(
	account_number SERIAL PRIMARY KEY,
	username VARCHAR(15) REFERENCES users(username),
	cash NUMERIC (10,2) DEFAULT 0.00,
	approval BOOLEAN DEFAULT FALSE
);

CREATE TABLE customer_info(
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(15) REFERENCES users(username),
	first_name VARCHAR(15),
	last_name VARCHAR(15),
	phone_number INTEGER,
	birth_date INTEGER 
);

INSERT INTO users(username, passcode, admin_level) VALUES 
('manager', 'sdvvfrgh', 'Manager'),
('teller', 'sdvvfrgh', 'Teller'),
('customer', 'sdvvfrgh', 'Customer');


INSERT INTO accounts(username, cash, approval) VALUES 
('customer', 1000000.00, FALSE);

INSERT INTO customer_info(username, first_name, last_name, phone_number, birth_date) VALUES 
('customer', 'first', 'last', 1234567890, 10152021 );


