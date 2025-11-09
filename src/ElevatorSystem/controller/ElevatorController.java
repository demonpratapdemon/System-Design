package ElevatorSystem.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ElevatorSystem.entities.ElevatorCar;
import ElevatorSystem.entities.OutsidePanel;
import ElevatorSystem.enums.Direction;
import ElevatorSystem.enums.ElevatorState;
import ElevatorSystem.enums.FloorNo;

public class ElevatorController {
	private List<ElevatorCar> elevators;
	private final List<OutsidePanel> outsidePanels;

	public ElevatorController(int numElevators) {
		this.elevators = new ArrayList<ElevatorCar>();
		for (int i = 0; i < numElevators; i++)
			this.elevators.add(new ElevatorCar(i + 1));

		this.outsidePanels = new ArrayList<OutsidePanel>();
		for (FloorNo floor : FloorNo.values()) {
			this.outsidePanels.add(new OutsidePanel(floor, this));
		}
	}

	public void requestElevator(FloorNo floor, Direction direction) {
		// TODO Auto-generated method stub
		System.out.println("Request received at " + floor.name() + " for direction " + direction);
		ElevatorCar bestElevator = findBestElevator(floor, direction);
		bestElevator.moveToFloor(floor);
	}

	private ElevatorCar findBestElevator(FloorNo requestFloor, Direction requestDir) {
		// TODO Auto-generated method stub
		ElevatorCar best = null;
		int minDistance = Integer.MAX_VALUE;

		for (ElevatorCar elevator : elevators) {
			int distance = Math.abs(elevator.getCurrentFloor().getNumber() - requestFloor.getNumber());

			// Prefer elevators that are idle or moving toward the request
			boolean directionMatch = elevator.getElevatorState() == ElevatorState.IDLE
					|| (elevator.getDirection() == requestDir && ((requestDir == Direction.UP
							&& elevator.getCurrentFloor().getNumber() <= requestFloor.getNumber())
							|| (requestDir == Direction.DOWN
									&& elevator.getCurrentFloor().getNumber() >= requestFloor.getNumber())));

			if (directionMatch && distance < minDistance) {
				minDistance = distance;
				best = elevator;
			}
		}

		// fallback: if all moving opposite, pick the closest anyway
		if (best == null)
			best = elevators.stream()
					.min(Comparator
							.comparingInt(e -> Math.abs(e.getCurrentFloor().getNumber() - requestFloor.getNumber())))
					.orElse(elevators.get(0));

		System.out.println(
				"Assigned Elevator " + best.getLiftId() + " (currently at " + best.getCurrentFloor().name() + ")");
		return best;
	}

	public List<ElevatorCar> getElevators() {
		return elevators;
	}

	public List<OutsidePanel> getOutsidePanels() {
		return this.outsidePanels;
	}

}
