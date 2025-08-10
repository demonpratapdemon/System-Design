package ParkingLot.strategy.fee;

import java.util.Map;

import ParkingLot.entities.ParkingTicket;
import ParkingLot.vehicle.VehicleSize;

public class VehicleBasedFeeStrategy implements FeeStrategy {

	private static final Map<VehicleSize, Double> HOURLY_RATES = Map.of(VehicleSize.SMALL, 10.0, VehicleSize.MEDIUM,
			20.0, VehicleSize.LARGE, 30.0);

	@Override
	public double calculateFee(ParkingTicket parkingTicket) {
		// TODO Auto-generated method stub
		long duration = parkingTicket.getExitTimestamp() - parkingTicket.getEntryTimestamp();
		long hours = (duration / (1000 * 60 * 60)) + 1;
		return hours * HOURLY_RATES.get(parkingTicket.getVehicle().getSize());
	}

}
