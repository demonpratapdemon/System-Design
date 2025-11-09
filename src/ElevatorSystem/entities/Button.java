package ElevatorSystem.entities;

public abstract class Button {
	protected boolean isPressed = false;

	public void press() {
		isPressed = true;
	}

	public void reset() {
		isPressed = false;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public abstract void onPress();
}
