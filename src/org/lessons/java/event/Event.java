package org.lessons.java.event;

import java.time.LocalDate;

public class Event {
	private String title; 
	private LocalDate date; 
	private int totalSeats; 
	private int reservedSeats; 
	
	public Event(String title, LocalDate date, int totalSeats) throws Exception {
		setTitle(title);
		setDate(date); 
		setTotalSeats(totalSeats); 
		this.reservedSeats = 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) throws Exception {
		if(date.isBefore(LocalDate.now())) {
			throw new Exception("Date must be in the future!");
		}
		this.date = date;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	
}
