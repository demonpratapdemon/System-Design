package ChessGame.entities;

import java.util.UUID;

public class Player {
	private String playerId;
	private String name;
	private boolean whiteSide;

	public Player(String name, boolean whiteSide) {
		this.playerId = UUID.randomUUID().toString();
		this.name = name;
		this.whiteSide = whiteSide;
	}

	public String getName() {
		return name;
	}

	public boolean isWhite() {
		return whiteSide;
	}

	public String getPlayerId() {
		return playerId;
	}

	public boolean isWhiteSide() {
		return whiteSide;
	}

}
