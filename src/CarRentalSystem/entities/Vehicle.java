package CarRentalSystem.entities;

import CarRentalSystem.enums.VehicleStatus;
import CarRentalSystem.enums.VehicleType;

abstract public class Vehicle {

	private String vehicleId;
	private VehicleType vehicleType;
	private VehicleStatus vehicleStatus;
	private Location vehicleLocation;
	private String model;
	private String make;
	private String registrationNumber;

	public Vehicle(String vehicleId, VehicleType vehicleType, String model, String make, String registrationNumber,
			VehicleStatus vehicleStatus, Location vehicleLocation) {
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.model = model;
		this.make = make;
		this.registrationNumber = registrationNumber;
		this.vehicleStatus = vehicleStatus;
		this.vehicleLocation = vehicleLocation;
	}

	public VehicleStatus getStatus() {
		return vehicleStatus;
	}

	public void setStatus(VehicleStatus vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public Location getParkedAt() {
		return vehicleLocation;
	}

	public void setParkedAt(Location vehicleLocation) {
		this.vehicleLocation = vehicleLocation;
	}

	public VehicleType getType() {
		return vehicleType;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public VehicleStatus getVehicleStatus() {
		return vehicleStatus;
	}

	public Location getVehicleLocation() {
		return vehicleLocation;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", model=" + model + ", make="
				+ make + ", registrationNumber=" + registrationNumber + ", vehicleStatus=" + vehicleStatus
				+ ", vehicleLocation=" + vehicleLocation + "]";
	}

}
