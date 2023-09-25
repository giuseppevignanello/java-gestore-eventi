package org.lessons.java.event;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammEvent {

	private String title;
	private List<Event> events;

	public ProgrammEvent(String title) {
		setTitle(title);
		events = new ArrayList<Event>();
	}

	public void addEvent(Event newEvent) {
		events.add(newEvent);
	}

	public List<Event> getEventsInADate(LocalDate date) {
		List<Event> localDateEvents = new ArrayList<Event>();
		for (Event event : events) {
			if (event.getDate().equals(date)) {
				localDateEvents.add(event);
			}
		}

		return localDateEvents;
	}

	public int getEventsNumber() {
		return events.size();
	}

	public void emptyEventsList() {
		events.clear();
	}

	public String getElementsOrderedByDate() {
		Collections.sort(events, (event1, event2) -> event1.getDate().compareTo(event2.getDate()));
		String orderedList = "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (Event event : events) {
			orderedList += (event.getDate().format(formatter) + "-" + event.getTitle() + "\n");
		}
		return this.getTitle() + "\n" + orderedList;

	}

	
	
	public BigDecimal avgConcertPrice() {
		BigDecimal sum = BigDecimal.ZERO;
		int concertCounter = 0;
		for (Event event : events) {
			if (event instanceof Concert) {
				sum = sum.add(event.getPrice());
				concertCounter++;
			}
		}

		return sum.divide(BigDecimal.valueOf(concertCounter), 2, RoundingMode.HALF_UP);
	}

	public BigDecimal avgShowPrice() {
		BigDecimal sum = BigDecimal.ZERO;
		int showCounter = 0;
		for (Event event : events) {
			if (event instanceof Show) {
				sum = sum.add(event.getPrice());
				showCounter++;
			}
		}

		return sum.divide(BigDecimal.valueOf(showCounter), 2, RoundingMode.HALF_UP);
	}

	public BigDecimal avgEventPrice() {
		BigDecimal sum = BigDecimal.ZERO;
		int eventCounter = 0;
		for (Event event : events) {

			sum = sum.add(event.getPrice());
			eventCounter++;

		}

		return sum.divide(BigDecimal.valueOf(eventCounter), 2, RoundingMode.HALF_UP);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
