package ChessGame.movement_startegy;

import ChessGame.entities.Cell;

public class BishopMoveStrategy implements MoveStrategy {

	@Override
	public boolean canMove(Cell from, Cell to) {
		// TODO Auto-generated method stub
		int rowDiff = Math.abs(from.getX() - to.getX());
		int colDiff = Math.abs(from.getY() - to.getY());
		return rowDiff == colDiff;
	}

}
