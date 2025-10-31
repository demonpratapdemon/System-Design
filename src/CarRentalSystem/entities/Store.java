package CarRentalSystem.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import CarRentalSystem.enums.ReservationStatus;
import CarRentalSystem.enums.VehicleStatus;

public class Store {

	private String storeId;
	private Location location;
	private List<Vehicle> vehicles = new ArrayList<>();
	private Map<String, Reservation> reservations = new HashMap<>();

	public Store(Location location) {
		this.storeId = UUID.randomUUID().toString();
		this.location = location;
	}

	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}

	public List<Vehicle> searchVehicles(Location pickup) {
		List<Vehicle> sv = new ArrayList<>();
		for (Vehicle v : this.vehicles) {
			if (v.getStatus() == VehicleStatus.AVAILABLE
					&& v.getParkedAt().getCity().equalsIgnoreCase(pickup.getCity())) {
				sv.add(v);
			}
		}
		return sv;
	}

	public String getStoreId() {
		return storeId;
	}

	public Location getLocation() {
		return location;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public Map<String, Reservation> getReservations() {
		return reservations;
	}

	public Reservation reserveVehicle(User user, Vehicle vehicle, Date startTime, Date endTime, Location drop) {
		Reservation r = new Reservation(user, vehicle, startTime, endTime, this.location, drop);
		reservations.put(r.getReservationId(), r);
		vehicle.setStatus(VehicleStatus.BOOKED);
		return r;
	}

	public void startTrip(String reservationId) {
		Reservation r = reservations.get(reservationId);
		r.setStatus(ReservationStatus.IN_PROGRESS);
		r.getVehicle().setStatus(VehicleStatus.IN_USE);
	}

	public void endTrip(String reservationId) {
		Reservation r = reservations.get(reservationId);
		r.setStatus(ReservationStatus.COMPLETED);
		r.getVehicle().setStatus(VehicleStatus.AVAILABLE);
		r.getVehicle().setParkedAt(r.getDrop());
	}

	public void cancelReservation(String reservationId) {
		Reservation r = reservations.get(reservationId);
		r.setStatus(ReservationStatus.CANCELLED);
		r.getVehicle().setStatus(VehicleStatus.AVAILABLE);
	}
}
