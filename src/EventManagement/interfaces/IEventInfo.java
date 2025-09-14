package EventManagement.interfaces;

import java.util.Date;
import java.util.List;

public interface IEventInfo {

	public String getEventName();

	public Date getEventDate();

	public int getCapacity();

	public boolean isCancelled();

	public List<IPerson> getRegistrations();

	public List<IPerson> getAttendees();

	public boolean register(IPerson person);

	public boolean attend(IPerson person);
}
