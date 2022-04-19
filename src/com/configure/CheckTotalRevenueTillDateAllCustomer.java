package com.configure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckTotalRevenueTillDateAllCustomer {
	
	public static Connection connection=null;
	public static PreparedStatement  preparedstatement=null;
	public static ResultSet resultset=null;
	
	public static final String CHECK_TOTAL_REVENUE_TILLDATEOF_ALL_CUSTOMER= "SELECT `reservation`.`booking_id` as 'BookingNo',\r\n"
			+ "	   `reservation`.`guest_name` as 'GuestName',\r\n"
			+ "	   `reservation`.`room_number` as 'RoomNumber',\r\n"
			+ "	   `reservation`.`check_in` as 'CheckinDate',\r\n"
			+ "	   `reservation`.`check_out` as 'CheckoutDate',\r\n"
			+ "	   `reservation`.`days` as 'TotalDaysStay', \r\n"
			+ "	   `room`.`room_perday_rent` as 'PerDayRoomCharge', \r\n"
			+ "	   `days`*`room_perday_rent` as 'TotalRoomRent'\r\n"
			+ "FROM  `PGP`.`reservation`, `PGP`.`room`\r\n"
			+ "WHERE `reservation`.`room_number`=`room`.`room_number`\r\n"
			+ "ORDER BY CheckinDate DESC;\r\n"
			+ "";

	public static void main(String[] args) throws SQLException {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/PGP","root","Gouse@2001");
			preparedstatement = connection.prepareStatement(CHECK_TOTAL_REVENUE_TILLDATEOF_ALL_CUSTOMER);
			resultset = preparedstatement.executeQuery();
			System.out.println("BookingNo\tGuestName\t\t\tRoomNumber\t\tCheckinDate\t\t\t\tCheckoutDate\t\tTotalDaysStay\t\tPerDayRoomCharge\t\tTotalRoomRent");
			while(resultset.next()) 
			{

				String BookingNo = resultset.getString(1);
				String GuestName = resultset.getString(2);
				String RoomNumber = resultset.getString(3);
				String CheckinDate = resultset.getString(4);
				String CheckoutDate = resultset.getString(5);
				String TotalDaysStay = resultset.getString(6);
				String PerDayRoomCharge = resultset.getString(7);
				String TotalRoomRent = resultset.getString(8);

				System.out.println(BookingNo+"\t\t"+GuestName+"\t\t"+RoomNumber+"\t\t\t"+CheckinDate+"\t\t\t"+CheckoutDate+"\t\t"+TotalDaysStay+"\t\t"+PerDayRoomCharge+"\t\t\t\t"+TotalRoomRent);
			}
		}

		finally {
			resultset.close();
			preparedstatement.close();
			connection.close();

		}
	}

}
