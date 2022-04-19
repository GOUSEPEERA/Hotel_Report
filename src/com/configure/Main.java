
package com.configure;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException  
	{
		int response=0;
		do 
		{
			ScreenofReport.print();
			System.out.println("");
			System.out.println("enteryour choice: ");
			response = new Scanner(System.in).nextInt();
			switch(response) {
			case 1:
				ReportOfIndividual.mani(args);
				break;
			case 2:
				CheckBillsTillDateofSpecificCustomer.main(null);
				break;
			case 3:
				CheckTotalRevenueTillDateAllCustomer.main(null);
				break;
			default :
				System.out.println("choose the right option, thank you");
				System.exit(0);

			}
			
		}while(response<=3);
		
	}


	}
