package CarRentalSystem.entities;

import java.util.Date;
import java.util.UUID;

import CarRentalSystem.enums.ReservationStatus;

public class Reservation {
	private String reservationId;
	private User user;
	private Vehicle vehicle;
	private Date startTime;
	private Date endTime;
	private Location pickup;
	private Location drop;
	private ReservationStatus reservationStatus;

	public Reservation(User user, Vehicle vehicle, Date startTime, Date endTime, Location pickup, Location drop) {
		this.reservationId = UUID.randomUUID().toString();
		this.user = user;
		this.vehicle = vehicle;
		this.startTime = startTime;
		this.endTime = endTime;
		this.pickup = pickup;
		this.drop = drop;
		this.reservationStatus = ReservationStatus.BOOKED;
	}

	public void setStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public ReservationStatus getStatus() {
		return reservationStatus;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Location getDrop() {
		return drop;
	}

	public User getUser() {
		return user;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Location getPickup() {
		return pickup;
	}

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public String getReservationId() {
		return reservationId;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", user=" + user + ", vehicle=" + vehicle
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", pickup=" + pickup + ", drop=" + drop
				+ ", reservationStatus=" + reservationStatus + "]";
	}
	
	

}
