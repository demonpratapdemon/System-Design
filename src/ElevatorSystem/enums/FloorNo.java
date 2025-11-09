package ElevatorSystem.enums;

public enum FloorNo {
	F1(1), F2(2), F3(3), F4(4), F5(5), F6(6), F7(7), F8(8), F9(9), F10(10), F11(11), F12(12), F13(13), F14(14), F15(15);

	private final int number;

	FloorNo(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public static FloorNo fromNumber(int num) {
		for (FloorNo f : FloorNo.values()) {
			if (f.getNumber() == num)
				return f;
		}
		throw new IllegalArgumentException("Invalid floor number: " + num);
	}
}
