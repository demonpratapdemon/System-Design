package ElevatorSystem.entities;

import ElevatorSystem.enums.DoorAction;

public class Door {
	@SuppressWarnings("unused")
	private DoorAction doorAction;

	public Door(DoorAction doorAction) {
		this.doorAction = doorAction;
	}

	public Door() {
	}

	public void openDoor() {
		this.doorAction = DoorAction.OPEN;
	}

	public void closeDoor() {
		this.doorAction = DoorAction.CLOSE;
	}

	
}
