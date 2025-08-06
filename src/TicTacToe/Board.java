/**
 * 
 */
package TicTacToe;

import java.util.List;

import TicTacToe.winningstrategy.WinningStrategy;

/**
 * @author LENOVO
 *
 */
public class Board {
	private final int size;
	private final Cell[][] grid;
	private final int movesCount;
	List<WinningStrategy> winningStartegies;

	Board(int size, List<WinningStrategy> strategies) {
		this.size = size;
		this.movesCount = 0;
		this.grid = new Cell[size][size];
		this.winningStartegies = strategies;
		initializeBoard();
	}

	private void initializeBoard() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.grid[i][j] = new Cell();
			}
		}
	}

	public boolean isValidMove(int row, int col) {
		return row >= 0 && row < size && col >= 0 && col < size;
	}

	public void placeMove(int row, int col, Symbol symbol) {
		grid[row][col].setSymbol(symbol);
	}

	public boolean checkWin(Symbol symbol) {
		for (WinningStrategy strategy : winningStartegies) {
			if (strategy.checkWinner(this, symbol))
				return true;
		}
		return false;
	}

	public void reset() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.grid[i][j].setSymbol(Symbol.EMPTY);
			}
		}
	}

	public Symbol getSymbol(int row, int col) {
		return grid[row][col].getSymbol();
	}

	public boolean isFull() {
		return this.movesCount == size * size;
	}

	public int getSize() {
		return size;
	}

	public void print() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				System.out.print(grid[i][j].getSymbol() + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
