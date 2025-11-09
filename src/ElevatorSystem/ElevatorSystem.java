package ElevatorSystem;

import ElevatorSystem.controller.ElevatorController;

public class ElevatorSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElevatorController controller = new ElevatorController(2);

        // Outside request from floor 3 (Up)
        controller.getOutsidePanels().get(2).pressButton(1);

        // Inside elevator request for floor 10
        controller.getElevators().get(0).getInsidePanel().pressButton(10);

        // Outside request from floor 5 (Down)
        controller.getOutsidePanels().get(4).pressButton(-1);
	}

}
