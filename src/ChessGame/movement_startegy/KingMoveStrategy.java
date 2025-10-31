package ChessGame.movement_startegy;

import ChessGame.entities.Cell;

public class KingMoveStrategy implements MoveStrategy {

	@Override
	public boolean canMove(Cell from, Cell to) {
		// TODO Auto-generated method stub
		int dx = Math.abs(to.getX() - from.getX());
		int dy = Math.abs(to.getY() - from.getY());
		return dx <= 1 && dy <= 1;
	}

}
