package org.lessons.java.event;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Show extends Event{

	private BigDecimal price;
	
	public Show(String title, LocalDate date, int totalSeats, BigDecimal price) throws Exception {
		super(title, date, totalSeats);
		setPrice(price);
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
}
