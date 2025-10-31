package ChessGame;

import ChessGame.entities.Board;
import ChessGame.entities.Move;
import ChessGame.entities.Player;
import ChessGame.enums.GameStatus;

public class Game {
	private Player whitePlayer;
	private Player blackPlayer;
	private Board board;
	private GameStatus gameStatus;
	private Player currentTurn;

	public Game(Player whitePlayer, Player blackPlayer, int rows, int cols) {
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.board = Board.getInstance(rows, cols);
		this.gameStatus = GameStatus.ACTIVE;
		this.currentTurn = whitePlayer;
	}

	public void makeMove(Move move) {
		if (gameStatus != GameStatus.ACTIVE) {
			System.out.println("Game has ended: " + gameStatus);
			return;
		}

		if (move.execute()) {
			System.out.println("Move executed successfully");
			switchTurn();
		} else {
			System.out.println("Invalid Move");
		}

		if (board.isCheckmate(currentTurn)) {
			gameStatus = currentTurn.isWhite() ? GameStatus.BLACK_WIN : GameStatus.WHITE_WIN;
		} else if (board.isStalemate()) {
			gameStatus = GameStatus.DRAW;
		}
	}

	private void switchTurn() {
		// TODO Auto-generated method stub
		currentTurn = currentTurn == whitePlayer ? blackPlayer : whitePlayer;
	}

	public GameStatus getStatus() {
		return gameStatus;
	}

	public Board getBoard() {
		return board;
	}
	
	
}
