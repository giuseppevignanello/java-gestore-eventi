package org.lessons.java.event;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Concert extends Event {

	private LocalTime hour; 
	private BigDecimal price; 
	
	
	public Concert(String title, LocalDate date, int totalSeats, LocalTime hour, BigDecimal price) throws Exception {
		super(title, date, totalSeats);
		setHour(hour); 
		setPrice(price);
		
	}
	
	public LocalDateTime getDatetime() {
		return this.getDate().atTime(this.getHour());
		
	}
	
	//getters and setters
	public LocalTime getHour() {
		return hour;
	}


	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	
	@Override
	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	@Override 
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dateTimeAsString = this.getDatetime().format(formatter);
		
		DecimalFormat decimalFormat = new DecimalFormat("##.##€");
		String formattedPrice = decimalFormat.format(getPrice());
		return dateTimeAsString + " " + this.getTitle() + " " + formattedPrice;
	}

	
	
}
