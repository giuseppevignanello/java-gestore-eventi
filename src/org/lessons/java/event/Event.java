package org.lessons.java.event;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;

import org.lessons.java.event.inter.Price;

import java.time.LocalDate;

public class Event implements Price{
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

	public void reserveSeat() throws Exception {
		if(this.date.isBefore(LocalDate.now())) {
			throw new Exception ("Sorry, the event has already ended :(");
		} else if(this.reservedSeats >= this.totalSeats) {
			throw new Exception ("Sorry, the event is sold out :(");
		} 
		else {
			this.reservedSeats ++;
		}	
	}
	
	public void cancelSeat() throws Exception {
		if(this.date.isBefore(LocalDate.now())) {
			throw new Exception ("Sorry, the event has already ended :(");
		} else if(this.reservedSeats == 0) {
			throw new Exception ("Are you sure you have booked?");
		} else {
			this.reservedSeats --;
		}
	}
	
	//getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws Exception {
		if(title.isBlank()) {
			throw new Exception("Title can't be empty");
		}
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

	public void setTotalSeats(int totalSeats) throws Exception {
		if(totalSeats <= 0) {
			throw new Exception ("Total seats can't be 0 or less");
		}
		this.totalSeats = totalSeats;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}
	
	public int getAvailableSeats() {
		return this.getTotalSeats() - this.getReservedSeats();
	}
	
	
	
	@Override 
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dateAsString = this.getDate().format(formatter);
		return dateAsString + " " + this.getTitle();
	}

	public BigDecimal getPrice() {
		return null;
	}

	
}
