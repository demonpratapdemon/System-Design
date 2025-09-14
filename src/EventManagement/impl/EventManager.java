package EventManagement.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import EventManagement.interfaces.IEventInfo;
import EventManagement.interfaces.IEventManager;
import EventManagement.interfaces.IPerson;

public class EventManager implements IEventManager {

	List<IEventInfo> events;

	public EventManager() {
		this.events = new ArrayList<>();
	}

	@Override
	public void addEvent(IEventInfo event) {
		// TODO Auto-generated method stub
		for (IEventInfo e : events) {
			if (e.getEventName().equalsIgnoreCase(event.getEventName()))
				return;
		}
		this.events.add(event);
	}

	@Override
	public void register(String eventName, IPerson person) {
		// TODO Auto-generated method stub
		for (IEventInfo e : events) {
			if (e.getEventName().equalsIgnoreCase(eventName)) {
				e.register(person);
				return;
			}
		}
	}

	@Override
	public void attend(String eventName, IPerson person) {
		// TODO Auto-generated method stub
		for (IEventInfo e : events) {
			if (e.getEventName().equalsIgnoreCase(eventName)) {
				e.attend(person);
				return;
			}
		}
	}

	@Override
	public List<String> getEventCountByYears() {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = getCountByYears("event");
		List<String> res = new ArrayList<String>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			res.add(entry.getKey() + " - " + entry.getValue());
		}
		return res;
	}

	@Override
	public List<String> getEventRegistrationCountByYears() {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = getCountByYears("register");
		List<String> res = new ArrayList<String>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			res.add(entry.getKey() + " - " + entry.getValue());
		}
		return res;
	}

	@Override
	public List<String> getEventAttendeesCountByYears() {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = getCountByYears("attend");
		List<String> res = new ArrayList<String>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			res.add(entry.getKey() + " - " + entry.getValue());
		}
		return res;
	}

	private Map<Integer, Integer> getCountByYears(String type) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (IEventInfo e : events) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(e.getEventDate());
			int year = cal.get(Calendar.YEAR);
			if (type.equals("register"))
				map.put(year, map.getOrDefault(year, 0) + e.getRegistrations().size());
			else if (type.equals("attend"))
				map.put(year, map.getOrDefault(year, 0) + e.getAttendees().size());
			else if (type.equals("event"))
				map.put(year, map.getOrDefault(year, 0) + 1);
		}
		return map;
	}

}
