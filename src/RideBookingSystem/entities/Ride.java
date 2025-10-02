package RideBookingSystem.entities;

import java.time.LocalDate;
import java.util.UUID;

import RideBookingSystem.enums.RideStatus;

public class Ride {
	private String rideId;
	private Rider rider;
	private Driver driver;
	private RideStatus status;
	private LocalDate createdAt;

	public Ride(Rider rider, Driver driver) {
		this.rideId = UUID.randomUUID().toString();
		this.rider = rider;
		this.driver = driver;
		this.status = RideStatus.REQUESTED;
		this.createdAt = LocalDate.now();
	}

	public String getRideId() {
		return rideId;
	}

	public Rider getRider() {
		return rider;
	}

	public Driver getDriver() {
		return driver;
	}

	public RideStatus getStatus() {
		return status;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setStatus(RideStatus status) {
		this.status = status;
	}

}
