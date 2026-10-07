DROP DATABASE IF EXISTS FraudDB;
CREATE DATABASE FraudDB;

USE FraudDB;

CREATE TABLE Accounts(
	id varchar(40) PRIMARY KEY,
    account_name varchar(50),
    available DECIMAL(19, 2) NULL,
    current DECIMAL(19, 2) NULL,
    iso_currency_code varchar(5),
    mask varchar(4),
    account_type varchar(50),
    account_subtype varchar(50));

CREATE TABLE Transactions(
	id varchar(40) PRIMARY KEY,
    account_id varchar(50),
    amount DECIMAL(19, 2),
    iso_currency_code varchar(5),
    description varchar(50),
    primary_category varchar(50),
    detailed_category varchar(50),
    payment_channel varchar(50),
    date_transaction DATE,
    date_authorised DATE,
    city varchar(50),
    country varchar(50),
    pending BOOLEAN,
    merchant_name varchar(100),
    merchant_entity_id varchar(50),
    merchant_category_code varchar(4),

Constraint FK_account
	FOREIGN KEY (account_id)
	REFERENCES Accounts(id)
);

CREATE TABLE Cases(
	id INT AUTO_INCREMENT PRIMARY KEY,
    account_id varChar(40),
    status varchar(30),
    score INT,
    description VARCHAR(100),
    open_date DATETIME,
    close_date DATETIME NULL,

Constraint FK_account1
	FOREIGN KEY (account_id)
	REFERENCES Accounts(id)
);



CREATE TABLE case_transaction(
	case_id INT,
    transaction_id varchar(40),

	Constraint FK_case
	FOREIGN KEY (case_id)
	REFERENCES Cases(id),

	constraint FK_transaction
		FOREIGN KEY (transaction_id)
		REFERENCES Transactions(id)
);