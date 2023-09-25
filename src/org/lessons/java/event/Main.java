package org.lessons.java.event;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		Event event = null;
		boolean validData = false;
		
		while(!validData) {
		try {
			System.out.println("Do you wanna add a new event? Insert the title: ");
			String title = sc.nextLine();
			System.out.println("Insert the date (yyyy-MM-dd)");
			LocalDate date = LocalDate.parse(sc.nextLine()) ; 
			System.out.println("Insert the number of total seats");
			int totalSeats = Integer.parseInt(sc.nextLine());
			event = new Event (title, date, totalSeats);
			validData = true;
		} catch (Exception e) {
			System.out.println("Invalid Data: " + e.getMessage());
		}
		}
		
		System.out.println(event.toString());
		
		
		
		sc.close();
		
		
	
		
		
		
		
	}
}
