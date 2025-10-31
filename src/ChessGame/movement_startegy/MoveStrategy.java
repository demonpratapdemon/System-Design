package ChessGame.movement_startegy;

import ChessGame.entities.Cell;

public interface MoveStrategy {
	boolean canMove(Cell from, Cell to);
}
