package ElevatorSystem.entities;

import ElevatorSystem.enums.DoorAction;

public class DoorButton extends Button {
	private final DoorAction action;

	public DoorButton(DoorAction action) {
		this.action = action;
	}

	public DoorAction getAction() {
		return action;
	}

	@Override
	public void onPress() {
		// TODO Auto-generated method stub
		System.out.println("Door " + action + " button pressed");
	}

}
