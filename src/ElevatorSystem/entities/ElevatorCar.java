package ElevatorSystem.entities;

import ElevatorSystem.enums.Direction;
import ElevatorSystem.enums.ElevatorState;
import ElevatorSystem.enums.FloorNo;

public class ElevatorCar {
	private final int liftId;
	private FloorNo currentFloor;
	private InsidePanel insidePanel;
	private ElevatorState elevatorState;
	private Direction direction;

	public ElevatorCar(int liftId) {
		this.liftId = liftId;
		this.currentFloor = FloorNo.F1;
		this.elevatorState = ElevatorState.IDLE;
		this.direction = Direction.IDLE;
		this.insidePanel = new InsidePanel();
	}

	public FloorNo getCurrentFloor() {
		return currentFloor;
	}

	public void moveToFloor(FloorNo floor) {
		System.out.println("Elevator moving to " + floor.name());
		this.elevatorState = ElevatorState.MOVING;
		this.direction = (floor.getNumber() > currentFloor.getNumber()) ? Direction.UP : Direction.DOWN;
		this.currentFloor = floor;
		this.elevatorState = ElevatorState.STOPPED;
		this.direction = Direction.IDLE;
		System.out.println("Elevator reached " + floor.name());
	}

	public InsidePanel getInsidePanel() {
		return this.insidePanel;
	}

	public int getLiftId() {
		return liftId;
	}

	public ElevatorState getElevatorState() {
		return elevatorState;
	}

	public Direction getDirection() {
		return direction;
	}

}
