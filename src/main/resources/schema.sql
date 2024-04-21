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
    zipcode VARCHAR(10) NOT NULL,
    townName VARCHAR(100) NOT NULL,
    stateAbbrev VARCHAR(2)  NOT NULL,
    CONSTRAINT pk_town
		PRIMARY KEY (zipcode),
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
    zipcode VARCHAR(10) NOT NULL,
    CONSTRAINT pk_street
		PRIMARY KEY (streetId),
	CONSTRAINT fk_street_town
		FOREIGN KEY (zipcode)
			REFERENCES town(zipcode)
            ON UPDATE CASCADE
			ON DELETE CASCADE
);

-- Table structure for house
DROP TABLE IF EXISTS house;
CREATE TABLE house (
	houseId INT AUTO_INCREMENT,
    houseNumber INT NOT NULL,
    aptNumber VARCHAR(20),
    streetId INT NOT NULL,
    CONSTRAINT pk_house
		PRIMARY KEY (houseId),
	CONSTRAINT fk_house_street
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

-- Table structure for customer_house bridge table
DROP TABLE IF EXISTS customer_house;
CREATE TABLE customer_house (
	phoneNumber VARCHAR(15) NOT NULL,
    houseId INT NOT NULL,
    CONSTRAINT pk_customer_house
		PRIMARY KEY (phoneNumber, houseId),
	CONSTRAINT fk_customer_house_customer
		FOREIGN KEY (phoneNumber)
			REFERENCES customer(phoneNumber)
            ON UPDATE CASCADE
			ON DELETE CASCADE,
	CONSTRAINT fk_customer_house_address
		FOREIGN KEY (houseId)
			REFERENCES house(houseId)
            ON UPDATE CASCADE
			ON DELETE CASCADE
);


    