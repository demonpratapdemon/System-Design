package ChessGame.entities;

import ChessGame.enums.PieceType;

public class Board {

	private static Board instance;
	private Cell[][] cells;

	private Board(int rows, int cols) {
		this.cells = new Cell[rows][cols];
		initializeBoard();
	}

	public static Board getInstance(int rows, int cols) {
		if (instance == null) {
			synchronized (Board.class) {
				if (instance == null)
					instance = new Board(rows, cols);
			}
		}
		return instance;
	}

	private void initializeBoard() {
		// TODO Auto-generated method stub
		int rows = cells.length, cols = cells[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}

//		White Setup
		cells[rows - 1][0].setPiece(PieceFactory.createPiece(PieceType.ROOK, true));
		cells[rows - 1][1].setPiece(PieceFactory.createPiece(PieceType.KNIGHT, true));
		cells[rows - 1][2].setPiece(PieceFactory.createPiece(PieceType.BISHOP, true));
		cells[rows - 1][3].setPiece(PieceFactory.createPiece(PieceType.QUEEN, true));
		cells[rows - 1][4].setPiece(PieceFactory.createPiece(PieceType.KING, true));
		cells[rows - 1][5].setPiece(PieceFactory.createPiece(PieceType.BISHOP, true));
		cells[rows - 1][6].setPiece(PieceFactory.createPiece(PieceType.KNIGHT, true));
		cells[rows - 1][7].setPiece(PieceFactory.createPiece(PieceType.ROOK, true));

		for (int j = 0; j < 8; j++)
			cells[rows - 2][j].setPiece(PieceFactory.createPiece(PieceType.PAWN, true));

//		Black Setup
		cells[0][0].setPiece(PieceFactory.createPiece(PieceType.ROOK, false));
		cells[0][1].setPiece(PieceFactory.createPiece(PieceType.KNIGHT, false));
		cells[0][2].setPiece(PieceFactory.createPiece(PieceType.BISHOP, false));
		cells[0][3].setPiece(PieceFactory.createPiece(PieceType.QUEEN, false));
		cells[0][4].setPiece(PieceFactory.createPiece(PieceType.KING, false));
		cells[0][5].setPiece(PieceFactory.createPiece(PieceType.BISHOP, false));
		cells[0][6].setPiece(PieceFactory.createPiece(PieceType.KNIGHT, false));
		cells[0][7].setPiece(PieceFactory.createPiece(PieceType.ROOK, false));

		// Black Pawns
		for (int j = 0; j < 8; j++)
			cells[1][j].setPiece(PieceFactory.createPiece(PieceType.PAWN, false));
	}

	public Cell getCell(int x, int y) {
		return cells[x][y];
	}

	public boolean isCheckmate(Player player) {
		// placeholder
		return false;
	}

	public boolean isStalemate() {
		// placeholder
		return false;
	}

}
