package ChessGame.movement_startegy;

import ChessGame.entities.Cell;
import ChessGame.entities.Piece;

public class PawnMoveStrategy implements MoveStrategy {

	@Override
	public boolean canMove(Cell from, Cell to) {
		// TODO Auto-generated method stub
		Piece pawn = from.getPiece();
		if (pawn == null)
			return false;

		int dir = pawn.isWhite() ? -1 : 1; // white moves up, black moves down
		int startRow = from.getX();
		int startCol = from.getY();
		int endRow = to.getX();
		int endCol = to.getY();

		// One step forward (empty cell)
		if (startCol == endCol && endRow == startRow + dir && to.getPiece() == null)
			return true;

		if ((pawn.isWhite() && startRow == 6) || (!pawn.isWhite() && startRow == 1))
			if (startCol == endCol && endRow == startRow + 2 * dir)
				return true;

		// Diagonal capture move
		if (Math.abs(startCol - endCol) == 1 && endRow == startRow + dir)
			return true;

		return false;
	}

}
