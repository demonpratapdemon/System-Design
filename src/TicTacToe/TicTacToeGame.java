package TicTacToe;

import java.util.List;

import TicTacToe.winningstrategy.ColumnWinningStrategy;
import TicTacToe.winningstrategy.DiagonalWinningStrategy;
import TicTacToe.winningstrategy.RowWinningStrategy;
import TicTacToe.winningstrategy.WinningStrategy;

public class TicTacToeGame {
	private final Board board;
	private final Player[] players;
	private int currentPlayerIdx;
	private GameStatus status;

	public TicTacToeGame(Player player1, Player player2, int size) {
		// TODO Auto-generated constructor stub
		this.players = new Player[] { player1, player2 };
		List<WinningStrategy> strategies = List.of(new RowWinningStrategy(), new ColumnWinningStrategy(),
				new DiagonalWinningStrategy());
		this.status = GameStatus.IN_PROGRESS;
		this.board = new Board(size, strategies);
	}

	public synchronized boolean playMove(int row, int col) {
		if (status != GameStatus.IN_PROGRESS)
			throw new IllegalStateException("Game is already finished");
		if (!board.isValidMove(row, col))
			throw new IllegalStateException("Invalid move");
		Player curr = players[currentPlayerIdx];
		board.placeMove(row, col, curr.getSymbol());
		if (board.checkWin(curr.getSymbol())) {
			status = GameStatus.WIN;
			System.out.println(curr.getName() + "  " + "WINS!");
		} else if (board.isFull()) {
			status = GameStatus.DRAW;
			System.out.println("Game is DRAW!");
		} else {
			currentPlayerIdx ^= 1;
		}
		return true;
	}

	public synchronized void reset() {
		board.reset();
		currentPlayerIdx = 0;
		status = GameStatus.IN_PROGRESS;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void printBoard() {
		board.print();
	}

}
