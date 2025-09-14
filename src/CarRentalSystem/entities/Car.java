package CarRentalSystem.entities;

import CarRentalSystem.enums.VehicleStatus;
import CarRentalSystem.enums.VehicleType;

public class Car extends Vehicle {
	private int seats;

	public Car(String vehicleId, VehicleType vehicleType, String model, String make, String registrationNumber,
			VehicleStatus vehicleStatus, Location vehicleLocation, int seats) {
		super(vehicleId, vehicleType, model, make, registrationNumber, vehicleStatus, vehicleLocation);
		// TODO Auto-generated constructor stub
		this.seats = seats;
	}

	public int getSeats() {
		return seats;
	}

}
