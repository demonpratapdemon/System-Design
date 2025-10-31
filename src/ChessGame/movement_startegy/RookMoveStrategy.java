package ChessGame.movement_startegy;

import ChessGame.entities.Cell;

public class RookMoveStrategy implements MoveStrategy {

	@Override
	public boolean canMove(Cell from, Cell to) {
		// TODO Auto-generated method stub
		return to.getX() == from.getX() || to.getY() == from.getY();
	}

}
