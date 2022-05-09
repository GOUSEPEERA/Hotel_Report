CREATE TABLE `PGP`.`reservation` (
  `booking_id` varchar(30) NOT NULL PRIMARY KEY,
  `guest_id` varchar(30),
  `guest_name` varchar(100) NOT NULL,
  `guest_mobile_no` varchar(100) NOT NULL,
  `guest_identity_proof` varchar(100) NOT NULL,
  `room_number` int,
  `check_in` datetime NOT NULL,
  `check_out` datetime,
  `days` int GENERATED ALWAYS AS (DATEDIFF(DATE(`check_out`),DATE(`check_in`)) + 1),
  FOREIGN KEY (`guest_id`) REFERENCES user(`user_id`),
  FOREIGN KEY (`room_number`) REFERENCES room(`room_number`),
  CONSTRAINT chk_guest_id_start_with_g CHECK(`guest_id` LIKE 'G___'),
  CONSTRAINT chk_booking_id_start_with_b CHECK(`booking_id` LIKE 'B___')
);


INSERT INTO `PGP`.`reservation`
(`booking_id`,`guest_id`,`guest_name`,`guest_mobile_no`,`guest_identity_proof`,`room_number`,`check_in`,`check_out`)
VALUES
('B001','G001','Mr.GD from Pune','+919999999999','Pancard:ARKFF9834F',3001,'2022-02-07 12:00:00','2022-04-07 12:00:00'),
('B002','G002','Mr.GOUSE from ADONI','+918888888888','Pancard:BRKFF9834F',3002,'2022-02-23 12:00:00','2022-02-23 12:00:00'),
('B003','G003','Mr.SREE from USA','+917777777777','Pancard:CRKFF9834F',1001,'2022-02-24 12:00:00','2022-02-28 12:00:00'),
('B004','G004','Mr.NABI from Kerla','+916666666666','Pancard:DRKFF9834F',1002,'2022-04-05 12:00:00','2022-04-07 12:00:00'),
('B005','G004','Mr.ALLABAKASH from Kerla','+916666666666','Pancard:DRKFF9834F',2001,'2022-02-24 12:00:00','2022-02-24 23:00:00');

SELECT * FROM RESERVATION;