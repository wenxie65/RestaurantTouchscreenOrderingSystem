-- DROP DATABASE IF EXISTS customerInfoDB;

-- CREATE DATABASE customerInfoDB;
-- USE customerInfoDB;

-- Table structure for state
DROP TABLE IF EXISTS state;
CREATE TABLE state (
	stateAbbrev VARCHAR(2) NOT NULL,
    stateName VARCHAR(30) NOT NULL,
    CONSTRAINT pk_state
		PRIMARY KEY (stateAbbrev)
);

-- Table structure for town
DROP TABLE IF EXISTS town;
CREATE TABLE town (
	townId INT AUTO_INCREMENT,
    townName VARCHAR(100) NOT NULL,
    stateAbbrev VARCHAR(2)  NOT NULL,
    zipcode VARCHAR(10) NOT NULL,
    CONSTRAINT pk_town
		PRIMARY KEY (townId),
	CONSTRAINT fk_town_state
		FOREIGN KEY (stateAbbrev)
			REFERENCES state(stateAbbrev)
            ON UPDATE CASCADE
			ON DELETE CASCADE
);

-- Table structure for street
DROP TABLE IF EXISTS street;
CREATE TABLE street (
	streetId INT AUTO_INCREMENT,
    streetName VARCHAR(100) NOT NULL,
    townId INT NOT NULL,
    CONSTRAINT pk_street
		PRIMARY KEY (streetId),
	CONSTRAINT fk_street_town
		FOREIGN KEY (townId)
			REFERENCES town(townId)
            ON UPDATE CASCADE
			ON DELETE CASCADE
);

-- Table structure for address
DROP TABLE IF EXISTS address;
CREATE TABLE address (
	addressId INT AUTO_INCREMENT,
    houseNumber INT NOT NULL,
    aptNumber VARCHAR(20),
    streetId INT NOT NULL,
    CONSTRAINT pk_address
		PRIMARY KEY (addressId),
	CONSTRAINT fk_address_street
		FOREIGN KEY (streetId)
			REFERENCES street(streetId)
			ON UPDATE CASCADE
			ON DELETE CASCADE
);

-- Table structure for customer
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
    phoneNumber VARCHAR(15) NOT NULL,
    customerName VARCHAR(20),
    customerNotes TEXT,
    CONSTRAINT pk_customer 
		PRIMARY KEY (phoneNumber)
);

-- Table structure for customer_address bridge table
DROP TABLE IF EXISTS customer_address;
CREATE TABLE customer_address (
	phoneNumber VARCHAR(15) NOT NULL,
    addressId INT NOT NULL,
    CONSTRAINT pk_customer_address
		PRIMARY KEY (phoneNumber, addressId),
	CONSTRAINT fk_customer_address_customer
		FOREIGN KEY (phoneNumber)
			REFERENCES customer(phoneNumber)
            ON UPDATE CASCADE
			ON DELETE CASCADE,
	CONSTRAINT fk_customer_address_address
		FOREIGN KEY (addressId)
			REFERENCES address(addressId)
            ON UPDATE CASCADE
			ON DELETE CASCADE
);


    