package ElevatorSystem.entities;

import ElevatorSystem.enums.FloorNo;

public class ElevatorButton extends Button {
	private final FloorNo destinationFloor;

	public ElevatorButton(FloorNo destinationFloor) {
		this.destinationFloor = destinationFloor;
	}

	public FloorNo getDestinationFloor() {
		return destinationFloor;
	}

	@Override
	public void onPress() {
		// TODO Auto-generated method stub
		System.out.println("Elevator button pressed for floor " + destinationFloor.name());
	}

}
