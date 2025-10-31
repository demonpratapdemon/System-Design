package ChessGame.movement_startegy;

import ChessGame.entities.Cell;

public class KnightMoveStrategy implements MoveStrategy {

	@Override
	public boolean canMove(Cell from, Cell to) {
		// TODO Auto-generated method stub
		int dx = Math.abs(from.getX() - to.getX());
		int dy = Math.abs(from.getY() - to.getY());
		return dx * dy == 2;
	}

}
