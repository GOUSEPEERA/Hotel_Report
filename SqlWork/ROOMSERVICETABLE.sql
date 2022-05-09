CREATE TABLE `PGP`.`roomservice`(
  `booking_id` varchar(30) NOT NULL,
  `served_datetime` datetime NOT NULL,
  `service_type` varchar(30) NOT NULL,
  `charges` double NOT NULL,
   FOREIGN KEY (`booking_id`) REFERENCES reservation(`booking_id`)
);

INSERT INTO `PGP`.`roomservice`
(`booking_id`,`served_datetime`,`service_type`,`charges`)
VALUES
('B001','2022-02-07 18:00:00','Masala Tea', 50),
('B001','2022-02-08 09:00:00','Car Drop', 1000),
('B001','2022-02-08 19:00:00','Dinner', 1500),
('B001','2022-02-10 20:00:00','Laundry', 500),
('B002','2022-02-23 19:00:00','Lunch', 1000),
('B003','2022-02-25 20:00:00','Dinner', 1500),
('B004','2022-04-06 16:00:00','Team Dinner', 5000);

SELECT * FROM ROOMSERVICE;