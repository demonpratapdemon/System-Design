package RideBookingSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import RideBookingSystem.entities.Driver;
import RideBookingSystem.entities.Location;
import RideBookingSystem.entities.Ride;
import RideBookingSystem.entities.Rider;
import RideBookingSystem.services.DriverSelectionStrrategy;
import RideBookingSystem.services.NearestDriverSelectionStrategy;
import RideBookingSystem.services.NotificationService;
import RideBookingSystem.services.RideService;

public class DriverCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver d1 = new Driver("Alice", new Location(12.9, 77.6));
		Driver d2 = new Driver("Bob", new Location(12.91, 77.61));
		Driver d3 = new Driver("Carol", new Location(12.95, 77.7));

		List<Driver> drivers = new ArrayList<>(Arrays.asList(d1, d2, d3));
		double thresholdKm = 5.0;
		DriverSelectionStrrategy selectionStrategy = new NearestDriverSelectionStrategy(drivers, thresholdKm);
		RideService rideService = new RideService();
		NotificationService notifier = new NotificationService();

		Rider rider = new Rider("Charlie", new Location(12.905, 77.605));

		List<Driver> nearby = selectionStrategy.findDrivers(rider.getLocation());
		notifier.notifyAvailableDrivers(nearby, rider);

		Driver chosenDriver = nearby.get(1);
		String rideId = rideService.requestRide(rider, chosenDriver);
		Ride ride = rideService.getRide(rideId);
		notifier.notifyRideAssigned(ride);

		rideService.completeRide(rideId);
		notifier.notifyRideCompleted(ride);

	}

}
