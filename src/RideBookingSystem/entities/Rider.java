package RideBookingSystem.entities;

import java.util.UUID;

public class Rider {
	private String riderId;
	private String riderName;
	private Location location;

	public Rider(String riderName, Location location) {
		this.riderId = UUID.randomUUID().toString();
		this.riderName = riderName;
		this.location = location;
	}

	public String getRiderId() {
		return riderId;
	}

	public String getRiderName() {
		return riderName;
	}

	public Location getLocation() {
		return location;
	}

}
