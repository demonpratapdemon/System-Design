package ParkingLot.strategy.fee;

import ParkingLot.entities.ParkingTicket;

public class FlatRateFeeStrategy implements FeeStrategy {

	private static final double RATE_PER_HOUR = 10.0;

	@Override
	public double calculateFee(ParkingTicket parkingTicket) {
		// TODO Auto-generated method stub
		long duration = parkingTicket.getExitTimestamp() - parkingTicket.getEntryTimestamp();
		long hours = (duration / (1000 * 60 * 60)) + 1;
		return hours * RATE_PER_HOUR;
	}

}
