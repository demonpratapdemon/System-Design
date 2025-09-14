package EventManagement.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import EventManagement.interfaces.IEventInfo;
import EventManagement.interfaces.IPerson;

public class EventInfo implements IEventInfo {
	private String eventName;
	private Date date;
	private int capacity;
	private boolean cancelled;
	private List<IPerson> registrations;
	private List<IPerson> attendees;

	public EventInfo(String eventName, Date date, int capacity, boolean cancelled) {
		this.eventName = eventName;
		this.date = date;
		this.capacity = capacity;
		this.cancelled = cancelled;
		this.registrations = new ArrayList<IPerson>();
		this.attendees = new ArrayList<IPerson>();
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public List<IPerson> getRegistrations() {
		return registrations;
	}

	public List<IPerson> getAttendees() {
		return attendees;
	}

	@Override
	public boolean register(IPerson person) {
		// TODO Auto-generated method stub
		if (isCancelled() || registrations.size() >= capacity || registrations.contains(person))
			return false;
		registrations.add(person);
		return true;
	}

	@Override
	public boolean attend(IPerson person) {
		// TODO Auto-generated method stub
		if (isCancelled() || !registrations.contains(person) || attendees.contains(person))
			return false;
		attendees.add(person);
		return true;
	}

	@Override
	public Date getEventDate() {
		// TODO Auto-generated method stub
		return date;
	}

}
