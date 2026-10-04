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
	CONSTRAINT FK_account_id
		FOREIGN KEY (account_id)
		REFERENCES Accounts(id)
)