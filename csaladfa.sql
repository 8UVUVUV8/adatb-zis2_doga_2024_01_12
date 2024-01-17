CREATE DATABASE csaladfa
CHARACTER SET utf8
COLLATE utf8_general_ci;

USE csaladfa;

CREATE TABLE gender(
	genderID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    gender text NOT NULL
);

CREATE TABLE birthplaces(
	placeID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    placename text NOT NULL,
    zipcode VARCHAR(4) NOT NULL
);

CREATE TABLE csalad(
    csaladID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    csaladnev text NOT NULL
);


CREATE TABLE status(
    statusID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    status text NOT NULL
);

CREATE TABLE person(
    personID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name text NOT NULL,
    csaladID int,
    genderID int DEFAULT 3,
    statusID int DEFAULT 1, 
    birthdate date NOT NULL,
    birth_placeID int NOT NULL DEFAULT 1,
    mothersname text,
    fathersname text,
	possibleplaceofdeath_placeID int DEFAULT NULL,
    possibletimeofdeath date DEFAULT NULL,
    constraint gendertablecon foreign key(genderID) REFERENCES gender(genderID) ON delete restrict,
    constraint birthplacestablecon foreign key(birth_placeID) REFERENCES birthplaces(placeID) ON delete restrict,
    constraint csaladtablecon foreign key(csaladID) REFERENCES csalad(csaladID) ON delete restrict,
    constraint statustablecon foreign key(statusID) REFERENCES status(statusID) ON delete restrict
);

INSERT INTO status(status)
VALUES ("Gyerek");

INSERT INTO status(status)
VALUES ("Apa");

INSERT INTO status(status)
VALUES ("Anya");

INSERT INTO status(status)
VALUES ("Mama");

INSERT INTO status(status)
VALUES ("Papa");

INSERT INTO gender(gender)
VALUES ("Férfi");

INSERT INTO gender(gender)
VALUES ("Nö");

INSERT INTO gender(gender)
VALUES ("Egyéb");

INSERT INTO birthplaces(placename, zipcode)
VALUES ("Ismeretlen", 0000);

INSERT INTO birthplaces(placename, zipcode)
VALUES ("Budapest08", 1086);

INSERT INTO birthplaces(placename, zipcode)
VALUES ("Budapest06", 1064);

INSERT INTO birthplaces(placename, zipcode)
VALUES ("Hatvan", 3000);

INSERT INTO csalad(csaladnev)
VALUES ("Kiss");

INSERT INTO csalad(csaladnev)
VALUES ("Nagy");

INSERT INTO person(name, csaladID, genderID, birthdate, birth_placeID, mothersname, fathersname) VALUES ("Nagy János", 2, 3, 2001-09-28, 2, "Nagy Jánosné", "Nagy János");


CREATE USER 'javaApp'@'%' IDENTIFIED BY 'java123';
GRANT EXECUTE ON csaladfa.* TO javaApp@'%';
FLUSH PRIVILEGES; 


DElIMITER $$
create procedure add_person_procedure(
    IN name_p text,
    IN csaladID_p int,
    IN genderID_p int, 
    IN birthdate_p DATE, 
    IN birth_placeID_p int, 
    IN mothersname_p text, 
    IN fathersname_p text, 
    IN possibleplaceofdeath_placeID_p int, 
    IN possibletimeofdeath_p DATE
    )
BEGIN
	INSERT INTO person(name, csaladID, genderID, birthdate, birth_placeID, mothersname, fathersname, possibleplaceofdeath_placeID, possibletimeofdeath)
	VALUES (name_p, csaladID_p, genderID_p, birthdate_p, birth_placeID_p, mothersname_p, fathersname_p, possibleplaceofdeath_placeID_p, possibletimeofdeath_p);
END $$
DELIMITER ;


DElIMITER $$
create procedure get_person_procedure()
BEGIN
	SELECT * FROM person;
END $$
DELIMITER ;