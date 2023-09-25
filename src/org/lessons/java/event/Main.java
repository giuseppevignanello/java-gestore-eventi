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
			Event event = null;
			//Event event = null;
			boolean validData = false;
			
			while(!validData) {
			try {
				System.out.println("Insert the event type (Concert/Show): ");
	            String eventType = sc.nextLine().toLowerCase();
	            
	            if(!eventType.equals("concert") && !eventType.equals("show")) {
	            	System.out.println("Please insert CONCERT or SHOW");
	            	continue;
	            }
	            
				System.out.println("Insert the title: ");
				String title = sc.nextLine();
				System.out.println("Insert the date (yyyy-MM-dd)");
				LocalDate date = LocalDate.parse(sc.nextLine()) ; 
				LocalTime hour = null;
				if(eventType.equals("concert") ) {
					System.out.println("Insert the time (hh:mm:ss)");
					hour = LocalTime.parse(sc.nextLine());
				}
				System.out.println("Insert price: (##.##)");
				BigDecimal price = new BigDecimal(sc.nextLine());
				System.out.println("Insert the number of total seats");
				int totalSeats = Integer.parseInt(sc.nextLine());
				if(eventType.equals("concert")) {
					event = new Concert (title, date, totalSeats, hour, price);
				} else if (eventType.equals("show")) {
					event = new Show (title, date, totalSeats, price);
				}
				validData = true;
				System.out.println(event.toString());
			} catch (Exception e) {
				System.out.println("Invalid Data: " + e.getMessage());
			}
			}
			
			//Reservation
			System.out.println("Do you want to reserve any seats? y/n");
			String userReservetionChioce = sc.nextLine();
			int userReservationNumber = 0;
			
			if(userReservetionChioce.toLowerCase().equals("y")) {
				System.out.println("How many seat you want to reserve?");
				userReservationNumber = Integer.parseInt(sc.nextLine());
			}
			
			if(userReservationNumber > 0) {
				for (int j = 0; j < userReservationNumber; j++) {
					try {
						event.reserveSeat();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
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
				System.out.println("How many  seat you want to cancel?");
				userCancellationNumber = Integer.parseInt(sc.nextLine());
			}
			
			if(userCancellationNumber > 0) {
					for (int x = 0; x < userCancellationNumber; x++) {
						try {
							event.cancelSeat();
						} catch (Exception e) {
							System.out.println(e.getMessage());
							break;
						}
					}
				
				
			}
			
			System.out.println("Reserved Seats: " + event.getReservedSeats());
			System.out.println("Available Seats: " + event.getAvailableSeats());
			
			programm.addEvent(event);
		}
		
		//LocalDate exampleDate = LocalDate.of(2025, 10, 5);
		
		//System.out.println(programm.getEventsInADate(exampleDate));
		System.out.println("There are " + programm.getEventsNumber() + " events");
		System.out.println(programm.getElementsOrderedByDate());
		System.out.println("Average Concerts price: $" + programm.avgPriceByType(Concert.class));
		System.out.println("Average Shows price: $" + programm.avgPriceByType(Show.class));
		System.out.println("Average Events price: $" + programm.avgPriceByType(Event.class));;
		sc.close();
		
		
		
		
		
	}
}
