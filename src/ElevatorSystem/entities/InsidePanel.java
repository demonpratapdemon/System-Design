package ElevatorSystem.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ElevatorSystem.entities.interfaces.Panel;
import ElevatorSystem.enums.DoorAction;
import ElevatorSystem.enums.FloorNo;

public class InsidePanel implements Panel {
	private final List<ElevatorButton> floorButtons;
	private final Map<DoorAction, DoorButton> doorButtons;

	public InsidePanel() {
		this.floorButtons = new ArrayList<ElevatorButton>();
		for (FloorNo f : FloorNo.values()) {
			floorButtons.add(new ElevatorButton(f));
		}

		this.doorButtons = new HashMap<DoorAction, DoorButton>();
		this.doorButtons.put(DoorAction.OPEN, new DoorButton(DoorAction.OPEN));
		this.doorButtons.put(DoorAction.CLOSE, new DoorButton(DoorAction.CLOSE));
	}

	@Override
	public void pressButton(int buttonNumber) {
		// TODO Auto-generated method stub
		if (buttonNumber >= 0 && buttonNumber <= FloorNo.values().length) {
			pressFloorButton(FloorNo.fromNumber(buttonNumber));
		} else if (buttonNumber == 0) {
			pressDoorButton(DoorAction.OPEN);
		} else if (buttonNumber == 1) {
			pressDoorButton(DoorAction.CLOSE);
		} else {
			System.out.println("Invalid button pressed on inside panel.");
		}
	}

	private boolean pressDoorButton(DoorAction action) {
		// TODO Auto-generated method stub
		DoorButton db = this.doorButtons.get(action);
		db.press();
		db.onPress();
		return true;
	}

	private boolean pressFloorButton(FloorNo floor) {
		// TODO Auto-generated method stub
		ElevatorButton eb = this.floorButtons.get(floor.getNumber() - 1);
		eb.press();
		eb.onPress();
		return true;
	}

}
