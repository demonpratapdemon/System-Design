package RideBookingSystem.services;

import java.util.List;

import RideBookingSystem.entities.Driver;
import RideBookingSystem.entities.Ride;
import RideBookingSystem.entities.Rider;

public class NotificationService {
	public void notifyAvailableDrivers(List<Driver> drivers, Rider rider) {
		System.out.println("Available drivers for " + rider.getRiderName() + ":");
		for (Driver d : drivers) {
			System.out.println("- " + d.getDriverName());
		}
	}

	public void notifyRideAssigned(Ride ride) {
		System.out.println(" Ride " + ride.getRideId() + " assigned to Driver " + ride.getDriver().getDriverName());
	}

	public void notifyRideCompleted(Ride ride) {
		System.out.println("Ride " + ride.getRideId() + " completed");
	}
}
