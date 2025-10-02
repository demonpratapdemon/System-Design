package RideBookingSystem.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import RideBookingSystem.entities.Driver;
import RideBookingSystem.entities.Ride;
import RideBookingSystem.entities.Rider;
import RideBookingSystem.enums.RideStatus;

public class RideService {
	private final Map<String, Ride> rides;

	public RideService() {
		this.rides = new ConcurrentHashMap<String, Ride>();
	}

	public String requestRide(Rider rider, Driver chosenDriver) {
		if (!chosenDriver.isAvailable())
			throw new RuntimeException("Driver Not Available");
		chosenDriver.setAvailable(false);
		Ride ride = new Ride(rider, chosenDriver);
		rides.put(ride.getRideId(), ride);
		return ride.getRideId();
	}

	public void completeRide(String riderId) {
		Ride ride = rides.getOrDefault(riderId, null);
		if (ride == null)
			return;
		ride.setStatus(RideStatus.COMPLETED);
		ride.getDriver().setAvailable(true);
	}

	public Ride getRide(String rideId) {
		return rides.getOrDefault(rideId, null);
	}
}
