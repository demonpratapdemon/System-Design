package SnakeAndLadderGame.models;

public class Snake extends BoardEntity {

	public Snake(int start, int end) {
		super(start, end);
		if (start <= end)
			throw new IllegalArgumentException("Snake's head must be at a higher position than it's tail.");
	}

}
