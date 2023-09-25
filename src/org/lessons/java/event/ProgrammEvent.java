package org.lessons.java.event;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
	public List<Event> getEventsInADate (LocalDate date) {
		List<Event> localDateEvents = new ArrayList<Event>(); 
		for (Event event : events) {
			if(event.getDate().equals(date)) {
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
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
