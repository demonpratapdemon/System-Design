package EventManagement.interfaces;

import java.util.List;

public interface IEventManager {
	public void addEvent(IEventInfo event);

	public void register(String eventName, IPerson person);

	public void attend(String eventName, IPerson person);

	List<String> getEventCountByYears();

	List<String> getEventRegistrationCountByYears();

	List<String> getEventAttendeesCountByYears();
}
