package com.configure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckBillsTillDateofSpecificCustomer {
	public static Connection connection=null;
	public static PreparedStatement  preparedstatement=null;
	public static ResultSet resultset=null;
	
	public static final String  CHECK_BILLS_TILL_DATE_OF_SPECIFIC_CUSTOMER = "SELECT "
			+ "`reservation`.`booking_id` as 'BookingNo',\r\n"
			+ "	   `reservation`.`guest_name` as 'GuestName',\r\n"
			+ "	   `reservation`.`room_number` as 'RoomNumber',\r\n"
			+ "	   `reservation`.`check_in` as 'CheckinDate',\r\n"
			+ "       `reservation`.`check_out` as 'PlannedCheckOutDate',\r\n"
			+ "	    NOW() as 'CurrentDateTime',\r\n"
			+ "       (DATEDIFF(DATE(CURDATE()),DATE(`check_in`)) + 1) as TotalDaysAsOfToday,\r\n"
			+ "	   `room`.`room_perday_rent` as 'PerDayRoomCharge', \r\n"
			+ "	   (DATEDIFF(DATE(CURDATE()),DATE(`check_in`)) + 1) *`room`.`room_perday_rent` as 'TotalRoomRentAsOfToday'\r\n"
			+ "FROM `pgp`.`reservation`, `pgp`.`room`\r\n"
			+ "WHERE `reservation`.`room_number`=`room`.`room_number`\r\n"
			+ "AND `reservation`.`booking_id`='B001'\r\n"
			+ "AND CURDATE() BETWEEN DATE(`reservation`.`check_in`) AND DATE(`reservation`.`check_out`);";
	
//	@SuppressWarnings("null")
	public static void main(String[] args) throws SQLException
	{
		
		try {
		
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/PGP","root","Gouse@2001");
			preparedstatement = connection.prepareStatement(CHECK_BILLS_TILL_DATE_OF_SPECIFIC_CUSTOMER);
			resultset = preparedstatement.executeQuery();
		System.out.println("BookingNo\tGuestName\t RoomNumber\tCheckinDate\t\tPlannedCheckOutDate\tCurrentDateTime \tStayed\tPerDayRoomCharge\tTotalRoomRentAsOfToday");
		while(resultset.next())
		{

			String  BookingNo=resultset.getString(1);
				String	GuestName = resultset.getString(2);
				String	RoomNumber = resultset.getString(3);
				String	CheckinDate = resultset.getString(4);
				String	PlannedCheckOutDate = resultset.getString(5); 
				String	CurrentDateTime = resultset.getString(6);
				String	Stayed = resultset.getString(7);
				String	PerDayRoomCharge = resultset.getString(8);
				String	TotalRoomRentAsOfToday  = resultset.getString(9);
			System.out.println(BookingNo+"\t\t"+GuestName+"\t "+RoomNumber+"\t\t"+CheckinDate+"\t"+PlannedCheckOutDate+"\t"+CurrentDateTime+"\t"+Stayed+"\t"+PerDayRoomCharge+"\t\t\t"+TotalRoomRentAsOfToday);
			
		}

		}
		finally {
			resultset.close();
			preparedstatement.close();
			connection.close();
			
		}
	}	
	
	
	

}
