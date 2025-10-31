package ChessGame.entities;

import ChessGame.enums.PieceType;
import ChessGame.movement_startegy.BishopMoveStrategy;
import ChessGame.movement_startegy.KingMoveStrategy;
import ChessGame.movement_startegy.KnightMoveStrategy;
import ChessGame.movement_startegy.PawnMoveStrategy;
import ChessGame.movement_startegy.QueenMoveStrategy;
import ChessGame.movement_startegy.RookMoveStrategy;

public class PieceFactory {

	public static Piece createPiece(PieceType type, boolean white) {
		switch (type) {
		case KING: {
			return new King(white, new KingMoveStrategy());
		}
		case QUEEN: {
			return new King(white, new QueenMoveStrategy());
		}
		case ROOK: {
			return new King(white, new RookMoveStrategy());
		}
		case BISHOP: {
			return new King(white, new BishopMoveStrategy());
		}
		case KNIGHT: {
			return new King(white, new KnightMoveStrategy());
		}
		case PAWN: {
			return new King(white, new PawnMoveStrategy());
		}
		default: {
			return null;
		}
		}
	}
}
