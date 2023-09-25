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
		
		//Reservation
		System.out.println("Do you want to reserve any seats? y/n");
		String userReservetionChioce = sc.nextLine();
		int userReservationNumber = 0;
		
		if(userReservetionChioce.toLowerCase().equals("y")) {
			System.out.println("How many  seat you want to reserve?");
			userReservationNumber = Integer.parseInt(sc.nextLine());
		}
		
		if(userReservationNumber > 0) {
			if(userReservationNumber > event.getAvailableSeats()) {
				System.out.println("Sorry, we have not all these available seats \n" +
									"Available seats: " + event.getAvailableSeats());
			} else {
			for (int i = 0; i < userReservationNumber; i++) {
				try {
					event.reserveSeat();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			}
		}
		
		
		//Cancellation
		System.out.println("Reserved Seats: " + event.getReservedSeats());
		System.out.println("Available Seats: " + (event.getTotalSeats() - event.getReservedSeats()));
		
		
		System.out.println("Do you want to cancel any reservation? y/n");
		String userCancellationChioce = sc.nextLine();
		int userCancellationNumber = 0;
		
		if(userCancellationChioce.toLowerCase().equals("y")) {
			System.out.println("How many  seat you want to reserve?");
			userCancellationNumber = Integer.parseInt(sc.nextLine());
		}
		
		if(userCancellationNumber > 0) {
			for (int i = 0; i < userCancellationNumber; i++) {
				try {
					event.cancelSeat();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		System.out.println("Reserved Seats: " + event.getReservedSeats());
		System.out.println("Available Seats: " + event.getAvailableSeats());


		
		
		
		
		
		sc.close();
		
		
	
		
		
		
		
	}
}
