package SnakeAndLadderGame.models;

public abstract class BoardEntity {
	private final int start, end;

	public BoardEntity(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

}
