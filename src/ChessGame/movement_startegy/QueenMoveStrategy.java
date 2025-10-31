package ChessGame.movement_startegy;

import ChessGame.entities.Cell;

public class QueenMoveStrategy implements MoveStrategy {
	private final RookMoveStrategy rookStrategy = new RookMoveStrategy();
	private final BishopMoveStrategy bishopStrategy = new BishopMoveStrategy();

	@Override
	public boolean canMove(Cell from, Cell to) {
		// TODO Auto-generated method stub
		return rookStrategy.canMove(from, to) || bishopStrategy.canMove(from, to);
	}

}
