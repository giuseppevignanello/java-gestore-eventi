package org.lessons.java.event;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int eventsNumber = 0;
		Scanner sc = new Scanner(System.in); 
		
		while(eventsNumber == 0) {
			try {
				System.out.println("How many events do you want to add?");
				eventsNumber = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				eventsNumber = 0;
				System.out.println("Insert a number");
			}
		}
		
		ProgrammEvent programm = new ProgrammEvent("Programma");	
		
		for (int i = 0; i < eventsNumber; i++) {
			Concert concert = null;
			//Event event = null;
			boolean validData = false;
			
			while(!validData) {
			try {
				System.out.println("Insert the title: ");
				String title = sc.nextLine();
				System.out.println("Insert the date (yyyy-MM-dd)");
				LocalDate date = LocalDate.parse(sc.nextLine()) ; 
				System.out.println("Insert the time (hh:mm:ss)");
				LocalTime hour = LocalTime.parse(sc.nextLine());
				System.out.println("Insert price: (##.##)");
				BigDecimal price = new BigDecimal(sc.nextLine());
				System.out.println("Insert the number of total seats");
				int totalSeats = Integer.parseInt(sc.nextLine());
				concert = new Concert (title, date, totalSeats, hour, price);
				validData = true;
				System.out.println(concert.toString());
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
				if(userReservationNumber > concert.getAvailableSeats()) {
					System.out.println("Sorry, we have not all these available seats \n" +
										"Available seats: " + concert.getAvailableSeats());
				} else {
				for (int j = 0; j < userReservationNumber; j++) {
					try {
						concert.reserveSeat();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				}
			}
			
			
			//Cancellation
			System.out.println("Reserved Seats: " + concert.getReservedSeats());
			System.out.println("Available Seats: " + (concert.getTotalSeats() - concert.getReservedSeats()));
			
			
			System.out.println("Do you want to cancel any reservation? y/n");
			String userCancellationChioce = sc.nextLine();
			int userCancellationNumber = 0;
			
			if(userCancellationChioce.toLowerCase().equals("y")) {
				System.out.println("How many  seat you want to reserve?");
				userCancellationNumber = Integer.parseInt(sc.nextLine());
			}
			
			if(userCancellationNumber > 0) {
				for (int x = 0; x < userCancellationNumber; x++) {
					try {
						concert.cancelSeat();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
			
			System.out.println("Reserved Seats: " + concert.getReservedSeats());
			System.out.println("Available Seats: " + concert.getAvailableSeats());
			
			programm.addEvent(concert);
		}
		
		LocalDate exampleDate = LocalDate.of(2025, 10, 5);
		
		System.out.println(programm.getEventsInADate(exampleDate));

		sc.close();
		
		
		
		
		
	}
}
