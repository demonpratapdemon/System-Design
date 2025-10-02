package RideBookingSystem.services;

import java.util.ArrayList;
import java.util.List;

import RideBookingSystem.entities.Driver;
import RideBookingSystem.entities.Location;

public class NearestDriverSelectionStrategy implements DriverSelectionStrrategy {
	private final List<Driver> drivers;
	private double threshold;

	public NearestDriverSelectionStrategy(List<Driver> drivers, double threshold) {
		this.drivers = drivers;
		this.threshold = threshold;
	}

	@Override
	public List<Driver> findDrivers(Location riderLoc) {
		// TODO Auto-generated method stub
		List<Driver> nearby = new ArrayList<Driver>();
		for (Driver d : drivers) {
			if (!d.isAvailable())
				continue;
			double dist = calculateDistance(riderLoc, d.getLocation());
			if (dist <= threshold)
				nearby.add(d);
		}
		return nearby;
	}

	private double calculateDistance(Location riderLoc, Location driverLoc) {
		// TODO Auto-generated method stub
		double dx = riderLoc.getLat() - driverLoc.getLat();
		double dy = riderLoc.getLon() - driverLoc.getLon();
		return Math.sqrt(dx * dx + dy * dy);
	}

}
