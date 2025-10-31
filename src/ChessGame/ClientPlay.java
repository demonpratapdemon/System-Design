package ChessGame;

import ChessGame.entities.Move;
import ChessGame.entities.Player;

public class ClientPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player white = new Player("Alice", true);
		Player black = new Player("Bob", false);

		Game game = new Game(white, black, 8, 8);

		Move move1 = new Move(game.getBoard().getCell(6, 0), game.getBoard().getCell(5, 0));
		game.makeMove(move1);

		Move move2 = new Move(game.getBoard().getCell(7, 7), game.getBoard().getCell(7, 5)); // black rook
		game.makeMove(move2);

		System.out.println("Game Status: " + game.getStatus());
	}

}
