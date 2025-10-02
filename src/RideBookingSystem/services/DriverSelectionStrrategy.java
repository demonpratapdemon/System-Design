package RideBookingSystem.services;

import java.util.List;

import RideBookingSystem.entities.Driver;
import RideBookingSystem.entities.Location;

public interface DriverSelectionStrrategy {
	public List<Driver> findDrivers(Location riderLoc);
}
