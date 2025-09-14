package CarRentalSystem.entities;

import CarRentalSystem.enums.VehicleStatus;
import CarRentalSystem.enums.VehicleType;

public class Bike extends Vehicle {
	private int engineCC;

	public Bike(String vehicleId, VehicleType vehicleType, String model, String make, String registrationNumber,
			VehicleStatus vehicleStatus, Location vehicleLocation, int engineCC) {
		super(vehicleId, vehicleType, model, make, registrationNumber, vehicleStatus, vehicleLocation);
		// TODO Auto-generated constructor stub
		this.engineCC = engineCC;
	}

	public int getEngineCC() {
		return engineCC;
	}

}
