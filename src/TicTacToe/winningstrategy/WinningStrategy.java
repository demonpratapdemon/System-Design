package TicTacToe.winningstrategy;

import TicTacToe.Board;
import TicTacToe.Symbol;

public interface WinningStrategy {
	boolean checkWinner(Board board, Symbol symbol);
}
