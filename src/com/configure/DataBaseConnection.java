package com.configure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	public static Connection conn=null;
	public static Statement statement=null;
	public static PreparedStatement preparedStatement=null;
	
	public static void main(String [] args) 
	{
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PGP","root","Gouse@2001");
		} catch (SQLException e) {}
		if(conn==null) 
		{
			System.out.println("GOUSE NOT CONNECTED FOR DB \"PGP\""); 
			
		}
		else {
			System.out.println("GOUSE YOUR CONNECTED SUCCESSFULLY FOR DB \"PGP\"");
		}
		
	}

}
