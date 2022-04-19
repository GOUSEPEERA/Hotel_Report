package com.configure;

public class ScreenofReport {
	
	public static void print() {
//		char dimond = '\u2666';
//		char heart = '\u2665';
//		char club = '\u2663';
//		char spade = '\u2660';
		char degree = '\u00B0';
		System.out.println("");
		for (int i = 0; i < 50; i++) {
			System.out.print("*");
		}
//		System.out.println("");
		System.out.println("");
		for (int i = 0; i < 19; i++) {
			System.out.print("-");
		}
		System.out.print(" Hotel 19" + degree + " ");
		for (int i = 0; i < 20; i++) {
			System.out.print("-");
		}
		System.out.println("");
//		System.out.println("");
		for (int i = 0; i < 50; i++) {
			System.out.print("*");
		}
		System.out.println("");
		System.out.println("                  Welcome Dear!");
		System.out.println("");
		System.out.println("      Please Choose from below options-");
		System.out.println("");
		System.out.println("      1. View Report by individual Customer");
		System.out.println("      2. Check Bills (Till Date) of specific Customer");
		System.out.println("      3. Check Total Revenue (Till Date) All Customer");
//		System.out.println("      4. Search Guest");
		System.out.println("");
		System.out.println("      Press any other number to exit...");
		System.out.println("");
		for (int i = 0; i < 50; i++) {
			System.out.print("#");
		}
		System.out.println("");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
