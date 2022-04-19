package com.configure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportOfIndividual {
	public static Connection connection=null;
	public static PreparedStatement  preparedstatement=null;
	public static ResultSet resultset=null;
	
	public static final String  VIEW_REPORT_OF_INDIVIDUAL_CUSTOMER ="SELECT "
			+ "booking_id, "
			+ "guest_id,"
			+ " guest_name, "
			+ "check_in, "
			+ "check_out, "
			+ "days, "
			+ "`days`*`room_perday_rent` as 'TotalRoomRent' "
			+ "FROM  `pgp`.`reservation`, `pgp`.`room`\r\n"+ 
			"WHERE `reservation`.`room_number`=`room`.`room_number`\r\n"+"AND `reservation`.`booking_id`='b001';  ";

	public static void mani(String[] args) throws SQLException {
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/PGP","root","Gouse@2001");
			preparedstatement = connection.prepareStatement(VIEW_REPORT_OF_INDIVIDUAL_CUSTOMER);
			resultset = preparedstatement.executeQuery();
			System.out.println("BookingId\tGuestId\t\tGuestName\t\tCheckInDate\t\t\tCheckOutDate\t\tStayedDays\t\tTotalRoomRent");

			while(resultset.next()) 
			{

				String booking_id = resultset.getString(1);
				String guest_id = resultset.getString(2);
				String guest_name = resultset.getString(3);
				String check_in = resultset.getString(4);
				String check_out = resultset.getString(5);
				String Stayed_days = resultset.getString(6);
				String TotalRoomRent = resultset.getString(7);
				System.out.println(booking_id+"\t\t"+guest_id+"\t\t"+guest_name+"\t\t"+check_in+"\t\t"+check_out+"\t"+Stayed_days+"\t\t\t"+TotalRoomRent);
			}
		}

		finally {
			resultset.close();
			preparedstatement.close();
			connection.close();

		}


	}

}

