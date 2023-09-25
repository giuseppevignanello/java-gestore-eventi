package org.lessons.java.event;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		
		LocalDate event1Date = LocalDate.of(2024, 9, 30);
		try {
			Event event1 = new Event("Concertone", event1Date, 300);
		} catch (Exception e) {
			System.out.println("Invalid Data: " + e.getMessage());
		}
	}
}
