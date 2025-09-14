package CarRentalSystem;

import java.util.Date;
import java.util.List;

import CarRentalSystem.entities.Bike;
import CarRentalSystem.entities.Car;
import CarRentalSystem.entities.Location;
import CarRentalSystem.entities.Payment;
import CarRentalSystem.entities.Reservation;
import CarRentalSystem.entities.Store;
import CarRentalSystem.entities.User;
import CarRentalSystem.entities.Vehicle;
import CarRentalSystem.enums.PaymentMode;
import CarRentalSystem.enums.VehicleStatus;
import CarRentalSystem.enums.VehicleType;

public class RentalManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RentalSystem rentalSystem = new RentalSystem();

		Location bangaloreAirport = new Location("Karnataka", "Bangalore", "Airport Road", "560001", "India");
		Location bangaloreCity = new Location("Karnataka", "Bangalore", "MG Road", "560002", "India");

		Store store1 = new Store(bangaloreAirport);
		Store store2 = new Store(bangaloreCity);

		rentalSystem.addStore(store1);
		rentalSystem.addStore(store2);

		Vehicle car1 = new Car("KA01AB1234", VehicleType.CAR, "Innova", "Toyota", "KA01AB1234", VehicleStatus.AVAILABLE,
				bangaloreAirport, 6);
		Vehicle car2 = new Car("KA05XY5678", VehicleType.CAR, "Creta", "Hyundai", "KA05XY5678", VehicleStatus.AVAILABLE,
				bangaloreCity, 4);
		Vehicle bike1 = new Bike("KA09ZZ9999", VehicleType.BIKE, "Classic 350", "Royal Enfield", "KA09ZZ9999",
				VehicleStatus.AVAILABLE, bangaloreAirport, 2);

		store1.addVehicle(car1);
		store1.addVehicle(bike1);
		store2.addVehicle(car2);

		List<Store> bangaloreStores = rentalSystem.getStoresByCity("Bangalore");

		System.out.println("Stores in Bangalore:");
		for (Store s : bangaloreStores) {
			System.out.println(" - " + s.getStoreId() + " at " + s.getLocation().getAddress());
		}

		Store selectedStore = bangaloreStores.get(0);
		List<Vehicle> availableVehicles = selectedStore.searchVehicles(bangaloreCity);
		System.out.println("\nAvailable vehicles at " + selectedStore.getStoreId() + ":");
		for (Vehicle v : availableVehicles) {
			System.out.println(" - " + v);
		}

		User user = new User("Pratap", "WBXXXXXXXX", "9999999999", bangaloreCity);
		Vehicle selectedVehicle = availableVehicles.get(0);
		Reservation reservation = selectedStore.reserveVehicle(user, selectedVehicle, new Date(), new Date(),
				bangaloreCity);

		System.out.println("\nReservation created successfully:");
		System.out.println(reservation);

		// Step 8: Payment
		Payment payment = new Payment(reservation, 2000.0, PaymentMode.CARD);
		payment.completePayment();
		System.out.println("\nPayment successful:");
		System.out.println(payment);
	}

}
