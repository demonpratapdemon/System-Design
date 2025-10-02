package RideBookingSystem.entities;

import java.util.UUID;

public class Driver {
	private String driverId;
	private String driverName;
	private Location location;
	private boolean available;

	public Driver(String driverName, Location location) {
		this.driverId = UUID.randomUUID().toString();
		this.driverName = driverName;
		this.location = location;
		this.available = true;
	}

	public String getDriverId() {
		return driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public Location getLocation() {
		return location;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
