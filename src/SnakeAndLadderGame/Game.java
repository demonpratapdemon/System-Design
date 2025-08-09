package SnakeAndLadderGame;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import SnakeAndLadderGame.enums.GameStatus;
import SnakeAndLadderGame.models.Board;
import SnakeAndLadderGame.models.BoardEntity;
import SnakeAndLadderGame.models.Dice;
import SnakeAndLadderGame.models.Player;

public class Game {

	private final Board board;
	private final Queue<Player> players;
	private final Dice dice;
	private GameStatus status;
	private Player winner;

	public Game(Builder builder) {
		this.board = builder.board;
		this.players = new LinkedList<>(builder.players);
		this.dice = builder.dice;
		this.status = GameStatus.NOT_STARTED;
	}

	public void play() {
		if (players.size() < 2) {
			System.out.println("Cannot start the game. Atleast 2 Plyaers are required.");
			return;
		}
		this.status = GameStatus.RUNNING;
		System.out.println("Game Started!");

		while (status == GameStatus.RUNNING) {
			Player currentPlayer = players.poll();
			takeTurn(currentPlayer);

			if (status == GameStatus.RUNNING) {
				players.add(currentPlayer);
			}

		}

		System.out.println("Game finished!");
		if (winner != null) {
			System.out.printf("The Winner is: %s!\n", winner.getName());
		}
	}

	private void takeTurn(Player player) {
		int roll = dice.roll();
		System.out.printf("\n%s's turn. Rolled a %d.\n", player.getName(), roll);
		
		int currentPos = player.getPosition();
		int nextPos = currentPos + roll;
		
		if (nextPos > board.getSize()) {
			System.out.printf("Oops, %s needs to land exactly on %d. Turn skipped.\n", player.getName(), board.getSize());
			return;
		}
		
		if (nextPos == board.getSize()) {
			player.setPosition(nextPos);
			this.winner = player;
			this.status = GameStatus.FINISHED;
			 System.out.printf("Hooray! %s reached the final square %d and won!\n", player.getName(), board.getSize());
			return;
		}
		
		int finalPos = board.getFinalPosition(nextPos);
		if (finalPos > nextPos) {
			System.out.printf("Wow! %s found a ladder at %d and climbed to %d.\n", player.getName(), nextPos, finalPos);
		} else if (finalPos < nextPos) {
			 System.out.printf("Oh no! %s was bitten by a snake at %d and slid down to %d.\n", player.getName(), nextPos, finalPos);
		} else {
			System.out.printf("%s moved from %d to %d.\n", player.getName(), currentPos, finalPos);
		}
		
		player.setPosition(finalPos);
		
		if (roll == 6) {
			System.out.printf("%s rolled a 6 and gets another turn!\n", player.getName());
			takeTurn(player);
		}
	}

	public static class Builder {
		private Board board;
		private Queue<Player> players;
		private Dice dice;

		public Builder setBoard(int boardSize, List<BoardEntity> boardEntities) {
			this.board = new Board(boardSize, boardEntities);
			return this;
		}

		public Builder setPlayers(List<String> playerNames) {
			this.players = new LinkedList<Player>();
			for (String name : playerNames) {
				players.add(new Player(name));
			}
			return this;
		}

		public Builder setDice(Dice dice) {
			this.dice = dice;
			return this;
		}

		public Game build() {
			if (board == null || players == null || dice == null) {
				throw new IllegalStateException("Board, Players, and Dice must be set.");
			}
			return new Game(this);
		}
	}
}
