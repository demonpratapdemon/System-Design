package ElevatorSystem.entities;

import ElevatorSystem.enums.Direction;
import ElevatorSystem.enums.FloorNo;

public class Display {
	private FloorNo floorNo;
	private Direction direction;
	private Integer weight;

	public Display(FloorNo floorNo, Direction direction, Integer weight) {
		this.floorNo = floorNo;
		this.direction = direction;
		this.weight = weight;
	}

	public FloorNo getFloorNo() {
		return floorNo;
	}

	public Direction getDirection() {
		return direction;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setFloorNo(FloorNo floorNo) {
		this.floorNo = floorNo;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
