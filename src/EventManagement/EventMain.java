package EventManagement;

import java.util.Calendar;

import EventManagement.impl.EventInfo;
import EventManagement.impl.EventManager;
import EventManagement.impl.Person;
import EventManagement.interfaces.IEventInfo;
import EventManagement.interfaces.IPerson;

public class EventMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPerson john = new Person("John", "Doe");
		IPerson jane = new Person("Jane", "Smith");
		IPerson richard = new Person("Richard", "Roe");

		Calendar cal = Calendar.getInstance();
		cal.set(2021, Calendar.JANUARY, 1);
		IEventInfo event1 = new EventInfo("Event1", cal.getTime(), 10, false);
		cal.set(2020, Calendar.JANUARY, 1);
		IEventInfo event2 = new EventInfo("Event2", cal.getTime(), 10, false);

		EventManager manager = new EventManager();
		manager.addEvent(event1);
		manager.addEvent(event2);

		// Actions
		manager.register("Event1", john);
		manager.register("Event2", john);
		manager.register("Event1", richard);
		manager.register("Event1", jane);
		manager.register("Event2", jane);

		manager.attend("Event1", john);
		manager.attend("Event1", richard);

		System.out.println("Event Count:");
		manager.getEventCountByYears().forEach(System.out::println);

		System.out.println("Registrations:");
		manager.getEventRegistrationCountByYears().forEach(System.out::println);

		System.out.println("Attendees:");
		manager.getEventAttendeesCountByYears().forEach(System.out::println);

	}

}
