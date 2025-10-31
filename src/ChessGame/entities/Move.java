package ChessGame.entities;

public class Move {
	private Cell from;
	private Cell to;
	private Piece movedPiece;
	private Piece capturedPiece;

	public Move(Cell from, Cell to) {
		this.from = from;
		this.to = to;
		this.movedPiece = from.getPiece();
	}

	public boolean execute() {
		if (movedPiece == null || movedPiece.isKilled())
			return false;
		if (!movedPiece.canMove(from, to))
			return false;

		capturedPiece = to.getPiece();
		if (capturedPiece != null) {
			capturedPiece.setKilled(true);
		}

		to.setPiece(movedPiece);
		from.setPiece(null);
		return true;
	}
}
