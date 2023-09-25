package org.lessons.java.event;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		
		LocalDate event1Date = LocalDate.of(2024, 9, 30);
		Event event1 = null;
		try {
			event1 = new Event("Concertone", event1Date, 300);
		} catch (Exception e) {
			System.out.println("Invalid Data: " + e.getMessage());
		}
		
		
		System.out.println(event1.toString());
		
		System.out.println("Reserved seats: " +  event1.getReservedSeats());
		
		try {
			event1.reserveSeat();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Reserved seats: " +  event1.getReservedSeats());
		
		try {
			event1.cancelSeat();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Reserved seats: " +  event1.getReservedSeats());
		
		
	}
}
