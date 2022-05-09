CREATE TABLE `PGP`.`user` (
  `user_id` varchar(30) NOT NULL PRIMARY KEY,
  `password` varchar(30) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `role` varchar(30) NOT NULL,
  CONSTRAINT chk_user_id_start_with_g_a_r CHECK(`user_id` LIKE 'G___' OR  `user_id` LIKE 'R___' OR  `user_id` LIKE 'A___')
);

INSERT INTO `PGP`.`user` VALUES
('A001','admin1','2022-02-23 12:00:00','Admin'),
('A002','admin2','2022-02-23 12:00:00','Admin'),
('R001','recep1','2022-02-23 12:00:00','Receptionist'),
('R002','recep2','2022-02-23 12:00:00','Receptionist'),
('G001','guest1','2022-02-23 12:00:00','Guest'),
('G002','guest2','2022-02-23 12:00:00','Guest'),
('G003','guest3','2022-02-23 12:00:00','Guest'),
('G004','guest4','2022-02-23 12:00:00','Guest');

SELECT * FROM USER;

