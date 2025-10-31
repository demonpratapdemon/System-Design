package ChessGame.entities;

import ChessGame.movement_startegy.MoveStrategy;

public abstract class Piece {
	private boolean white;
	private boolean killed;
	private MoveStrategy moveStrategy;

	public Piece(boolean white, MoveStrategy moveStrategy) {
		this.white = white;
		this.killed = false;
		this.moveStrategy = moveStrategy;
	}

	public boolean isWhite() {
		return white;
	}

	public boolean canMove(Cell from, Cell to) {
		return !killed && moveStrategy.canMove(from, to);
	}

	public boolean isKilled() {
		return killed;
	}

	public void setKilled(boolean killed) {
		this.killed = killed;
	}

}
