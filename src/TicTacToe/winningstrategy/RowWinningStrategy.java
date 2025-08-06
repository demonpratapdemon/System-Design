package TicTacToe.winningstrategy;

import TicTacToe.Board;
import TicTacToe.Symbol;

public class RowWinningStrategy implements WinningStrategy {

	@Override
	public boolean checkWinner(Board board, Symbol symbol) {
		// TODO Auto-generated method stub
		int n = board.getSize();
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (board.getSymbol(i, j) == symbol)
					count++;
			}
			if (count == n)
				return true;
		}
		return false;
	}

}
