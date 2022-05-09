
-- Get Total Room Service Amount For Specific Booking Id
SELECT booking_id, SUM(`charges`) as TotalRoomServiceCharge
FROM `PGP`.`roomservice`
WHERE `booking_id`='B001'
GROUP BY `booking_id`;


-- Get Total Room Rent Amount For All Booking Ids Sorted By Check In Date Descending Order
SELECT `reservation`.`booking_id` as 'BookingNo',
	   `reservation`.`guest_name` as 'GuestName',
	   `reservation`.`room_number` as 'RoomNumber',
	   `reservation`.`check_in` as 'CheckinDate',
	   `reservation`.`check_out` as 'CheckoutDate',
	   `reservation`.`days` as 'TotalDaysStay', 
	   `room`.`room_perday_rent` as 'PerDayRoomCharge', 
	   `days`*`room_perday_rent` as 'TotalRoomRent'
FROM  `pgp`.`reservation`, `pgp`.`room`
WHERE `reservation`.`room_number`=`room`.`room_number`
ORDER BY CheckinDate DESC;




-- Get Room Rent Details For Specific Booking Id
SELECT `reservation`.`booking_id` as 'BookingNo',
	   `reservation`.`guest_name` as 'GuestName',
	   `reservation`.`room_number` as 'RoomNumber',
	   `reservation`.`check_in` as 'CheckinDate',
	   `reservation`.`check_out` as 'CheckoutDate',
	   `reservation`.`days` as 'TotalDaysStay', 
	   `room`.`room_perday_rent` as 'PerDayRoomCharge', 
	   `days`*`room_perday_rent` as 'TotalRoomRent'
FROM `pgp`.`reservation`, `pgp`.`room`
WHERE `reservation`.`room_number`=`room`.`room_number`
AND `reservation`.`booking_id`='B002'; 

SELECT booking_id, guest_id, guest_name, check_in, check_out, days, `days`*`room_perday_rent` as 'TotalRoomRent' FROM  `pgp`.`reservation`, `pgp`.`room`
WHERE `reservation`.`room_number`=`room`.`room_number`
AND `reservation`.`booking_id`='B002';  


-- Get Room Rent Details For All Booking Id As Of Today (THOSE WHO ARE NOT CHECKED OUT)
SELECT `reservation`.`booking_id` as 'BookingNo',
	   `reservation`.`guest_name` as 'GuestName',
	   `reservation`.`room_number` as 'RoomNumber',
	   `reservation`.`check_in` as 'CheckinDate',
       `reservation`.`check_out` as 'PlannedCheckOutDate',
	    NOW() as 'CurrentDateTime',
       (DATEDIFF(DATE(CURDATE()),DATE(`check_in`)) + 1) as TotalDaysAsOfToday,
	   `room`.`room_perday_rent` as 'PerDayRoomCharge', 
	   (DATEDIFF(DATE(CURDATE()),DATE(`check_in`)) + 1) *`room`.`room_perday_rent` as 'TotalRoomRentAsOfToday'
FROM `hms`.`reservation`, `hms`.`room`
WHERE `reservation`.`room_number`=`room`.`room_number`
AND CURDATE() BETWEEN DATE(`reservation`.`check_in`) AND DATE(`reservation`.`check_out`);





-- Get Room Rent Details For Specific Booking Id As Of Today (THOSE WHO ARE NOT CHECKED OUT)
SELECT `reservation`.`booking_id` as 'BookingNo',
	   `reservation`.`guest_name` as 'GuestName',
	   `reservation`.`room_number` as 'RoomNumber',
	   `reservation`.`check_in` as 'CheckinDate',
       `reservation`.`check_out` as 'PlannedCheckOutDate',
	    NOW() as 'CurrentDateTime',
       (DATEDIFF(DATE(CURDATE()),DATE(`check_in`)) + 1) as TotalDaysAsOfToday,
	   `room`.`room_perday_rent` as 'PerDayRoomCharge', 
	   (DATEDIFF(DATE(CURDATE()),DATE(`check_in`)) + 1) *`room`.`room_perday_rent` as 'TotalRoomRentAsOfToday'
FROM `pgp`.`reservation`, `pgp`.`room`
WHERE `reservation`.`room_number`=`room`.`room_number`
AND `reservation`.`booking_id`='B001'
AND CURDATE() BETWEEN DATE(`reservation`.`check_in`) AND DATE(`reservation`.`check_out`);
-- Above one is better then below one
-- AND `reservation`.`check_in`<= NOW() AND `reservation`.`check_out`>= NOW();





-- Get Total Room Rent Amount For Specific Booking Id As Per Planned Checkout date
SELECT TotalRoomRent
FROM(
	SELECT `reservation`.`booking_id` as 'BookingNo',
		   `reservation`.`guest_name` as 'GuestName',
		   `reservation`.`room_number` as 'RoomNumber',
		   `reservation`.`check_in` as 'CheckinDate',
		   `reservation`.`check_out` as 'CheckoutDate',
		   `reservation`.`days` as 'TotalDaysStay', 
		   `room`.`room_perday_rent` as 'PerDayRoomCharge', 
		   `days`*`room_perday_rent` as 'TotalRoomRent'
	FROM `hms`.`reservation`, `hms`.`room`
	WHERE `reservation`.`room_number`=`room`.`room_number`
    ) as TotalRentTable
WHERE `TotalRentTable`.`BookingNo`='B001'; 

