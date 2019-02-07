-- DROP TABLE users_accounts;
-- DROP TABLE user_table;
-- DROP TABLE account_table;

-- Create users table to record all users
CREATE TABLE user_table (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(30)		NOT NULL,
	last_name VARCHAR(30)		NOT NULL,
	email VARCHAR(30)	 UNIQUE NOT NULL,
	pw_hash VARCHAR(30)			NOT NULL,
	acct_ids VARCHAR(100)
);

-- Create accounts table to record all accounts
CREATE TABLE account_table (
	id SERIAL PRIMARY KEY,
	acct_type VARCHAR(30)	NOT NULL,
	currency VARCHAR(3)		NOT NULL,
	balence FLOAT			NOT NULL,
	access_code INT	UNIQUE NOT NULL
);

-- DEBUG
-- -- INSERT INTO account_table (acct_type, currency, balence, access_code)
-- -- VALUES
-- --  	('Checking','USD', 23749.74, 12345),
-- --  	('Savings', 'AUD', 2349.74, 73492),
-- --  	('Savings','CAN', 29.74, 27149),
-- --  	('Checking','GBR', 4823.98, 37840);

-- Create transactions table to record all transactions
CREATE TABLE transactions (
	id SERIAL PRIMARY KEY,
	transaction_date DATE DEFAULT CURRENT_DATE,
	transaction_time TIME DEFAULT CURRENT_TIME,
	acct_id VARCHAR(30),
	currency VARCHAR(3),
	balance FLOAT,
	deposit FLOAT,
	withdraw FLOAT,
	first_name VARCHAR(30),
	last_name VARCHAR(30)
);

-- Create Junction table for user_table and account_table using foreign keys to each tables id
CREATE TABLE users_accounts (
  users_id    INT REFERENCES user_table(id),
  accounts_id INT REFERENCES account_table(id),
  CONSTRAINT users_acct_pk PRIMARY KEY (users_id, accounts_id)  -- explicit pk
);

-- GRANT role 'bank_project_jdbc' access to all tables in 'local'
GRANT SELECT, UPDATE, INSERT, DELETE ON ALL TABLES IN SCHEMA PUBLIC TO bank_project_jdbc;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA PUBLIC TO bank_project_jdbc;

-- DEBUG
-- -- DELETE transactions (transaction_date, transaction_time, acct_type, deposit, withdraw, currency, first_name, last_name)
-- -- VALUES
-- --  (CURRENT_DATE, CURRENT_TIME, 'Checking', 345.87, NULL, 'USD', 'Courtney', 'Walker'),
-- --  (CURRENT_DATE, CURRENT_TIME, 'Savings', 5657.87, NULL, 'GBR', 'Tonda', 'Walker'),
-- --  (CURRENT_DATE, CURRENT_TIME, 'Checking', NULL, -34.04, 'AUD', 'Linda', 'Walker');

-- JOIN EXAMPLE
-- -- student = accts		classes = users
-- -- SELECT account_table.id, account_table.acct_type, account_table.currency, account_table.balance
-- --    FROM users_accounts
-- -- INNER JOIN account_table ON user_table.id = users_accounts._id
-- --    WHERE sc.users_id = X

-- DEBUG Get accounts for lester
SELECT *
FROM account_table
WHERE id = ANY (
	SELECT accounts_id
	FROM users_accounts
	WHERE users_id = ANY (
		SELECT id
		FROM user_table
		WHERE first_name = 'Lester')) 
--  		RETURNING users_accounts.account_id, acct_type, currency, balence;
		
-- Remove the unused columns from tables user_table and account_table
-- -- ALTER TABLE account_table 
-- --   DROP COLUMN access_code;
		
-- -- SELECT * FROM account_table;
		
-- -- ALTER TABLE user_table
-- -- 	DROP COLUMN acct_ids;
		
-- -- SELECT * FROM user_table;

-- DEBUG
-- -- INSERT INTO users_accounts (users_id, accounts_id)
-- -- VALUES
-- -- 	(2,1);

-- -- SELECT * FROM users_accounts;

-- DEBUG		
-- -- INSERT INTO account_table (acct_type, currency, balence)
-- -- VALUES
-- -- 	('Savings', 'AUD', 245.94);

-- DEBUG
-- INSERT INTO users_accounts (users_id, accounts_id)
-- VALUES
-- 	(2,7);
		
-- DEBUG
-- SELECT email, pw_hash FROM user_table;

-- SELECT id, email, pw_hash FROM user_table WHERE email = 'lt@vegas.com' AND pw_hash = '13';
INSERT INTO account_table (acct_type, currency, balence)
VALUES
 	('Checking', 'AUD', 35.85);
		
SELECT * FROM account_table;

UPDATE account_table
SET balence = balence + 25.0
WHERE
	id = 14;
		
-- DELETE FROM user_table WHERE id = 18;
-- INSERT INTO account_table (acct_type, currency, balence) VALUES ('CHECKING', 'USD', 340.75); 
-- 		INSERT INTO users_accounts (users_id, accounts_id) VALUES ()
		
INSERT INTO users_accounts (users_id, accounts_id) VALUES (16, 14);
		
SELECT * FROM users_accounts;
DELETE FROM users_accounts WHERE accounts_id = 
		
SELECT id FROM user_table WHERE email = 'jc@gmail.com';	
		
CREATE OR REPLACE FUNCTION add_user(INT, VARCHAR)
RETURNS boolean AS
$body$ 
BEGIN
    -- Check if new users email exists in the user_table
	INSERT INTO users_accounts (users_id, accounts_id) 
		VALUES ((SELECT id FROM user_table WHERE email = 'lt@vegas.com'), 27);
	RETURN TRUE;
END;
$body$ 
LANGUAGE 'plpgsql';

CALL add_user(INT, VARCHAR);

SELECT * FROM add_user(10, 'jc@gmail.com');
DROP FUNCTION add_user(INT, VARCHAR);

SELECT id FROM user_table WHERE email = 'jc@gmail.com'

SELECT id, first_name, last_name, email FROM user_table WHERE email = 'lt@vegas.com' AND pw_hash = '13'

-- Debug
ALTER TABLE user_table ALTER COLUMN pw_hash TYPE VARCHAR;

SELECT id, first_name, last_name, pw_hash FROM user_table WHERE email = 'bigbird@gmail.com'

-- Debug, added pw hashing so needed to truncate the tables so all my new users now have their pw hashed 
-- TRUNCATE TABLE user_table CASCADE;
-- TRUNCATE TABLE account_table CASCADE;
-- TRUNCATE TABLE users_accounts;

SELECT * 
FROM account_table 
WHERE id = ANY (
	SELECT accounts_id 
	FROM users_accounts 
	WHERE users_id = ?)


