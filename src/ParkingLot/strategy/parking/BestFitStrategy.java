package ParkingLot.strategy.parking;

import java.util.List;
import java.util.Optional;

import ParkingLot.entities.ParkingFloor;
import ParkingLot.entities.ParkingSpot;
import ParkingLot.vehicle.Vehicle;

public class BestFitStrategy implements ParkingStrategy {

	@Override
	public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
		// TODO Auto-generated method stub
		Optional<ParkingSpot> bestSpot = Optional.empty();

		for (ParkingFloor floor : floors) {
			Optional<ParkingSpot> spotOnThisFloor = floor.findAvailableSpot(vehicle);
			if (spotOnThisFloor.isPresent()) {
				if (bestSpot.isEmpty()) {
					bestSpot = spotOnThisFloor;
				} else {
					if (spotOnThisFloor.get().getSpotSize().ordinal() < bestSpot.get().getSpotSize().ordinal()) {
						bestSpot = spotOnThisFloor;
					}
				}
			}
		}
		return bestSpot;
	}

}
