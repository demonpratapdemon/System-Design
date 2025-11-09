package ElevatorSystem.entities;

import ElevatorSystem.controller.ElevatorController;
import ElevatorSystem.entities.interfaces.Panel;
import ElevatorSystem.enums.Direction;
import ElevatorSystem.enums.FloorNo;

public class OutsidePanel implements Panel {

	private final FloorNo floor;
	private final ElevatorController controller;

	public OutsidePanel(FloorNo floor, ElevatorController controller) {
		this.floor = floor;
		this.controller = controller;
	}

	@Override
	public void pressButton(int buttonNumber) {
		// TODO Auto-generated method stub
		if (buttonNumber == 1) {
			moveUp();
		} else if (buttonNumber == -1) {
			moveDown();
		} else {
			System.out.println("Invalid button pressed on outside panel.");
		}
	}

	private boolean moveDown() {
		// TODO Auto-generated method stub
		System.out.println("Outside panel: Down button pressed at " + floor.name());
		this.controller.requestElevator(floor, Direction.DOWN);
		return true;
	}

	private boolean moveUp() {
		// TODO Auto-generated method stub
		System.out.println("Outside panel: Up button pressed at " + floor.name());
		this.controller.requestElevator(floor, Direction.UP);
		return true;
	}

}
