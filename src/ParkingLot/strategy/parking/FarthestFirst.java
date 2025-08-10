package ParkingLot.strategy.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ParkingLot.entities.ParkingFloor;
import ParkingLot.entities.ParkingSpot;
import ParkingLot.vehicle.Vehicle;

public class FarthestFirst implements ParkingStrategy {

	@Override
	public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
		// TODO Auto-generated method stub
		List<ParkingFloor> reversedFloors = new ArrayList<>(floors);
		Collections.reverse(reversedFloors);
		for (ParkingFloor floor : floors) {
			Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);
			if (spot.isPresent())
				return spot;
		}
		return Optional.empty();
	}

}
