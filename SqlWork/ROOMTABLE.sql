DROP DATABASE PGP;
CREATE DATABASE PGP;
USE PGP;

CREATE TABLE `PGP`.`room` (
  `room_number` int NOT NULL PRIMARY KEY,
  `room_type` varchar(30) NOT NULL,
  `room_amenities` varchar(200) NOT NULL,
  `room_perday_rent` double NOT NULL
);

INSERT INTO `PGP`.`room` VALUES
(1001,'Deluxe','Smart TV, Fridge',1200),
(1002,'NON Deluxe','Smart TV',1000),
(2001,'Ultra Deluxe','Smart TV, Fridge, Washing Machine',1500),
(2002,'Super Deluxe','Smart TV, Fridge',1300),
(3001,'Executive Suite','Smart TV, Fridge, Washing Machine, Modular Kitchen',2000),
(3002,'Executive Suite','Smart TV, Fridge, Washing Machine, Modular Kitchen',2000);

SELECT * FROM ROOM;







