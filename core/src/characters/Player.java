package characters;

import com.badlogic.gdx.math.Vector2;

/**
 * 
 * @author Paul
 * 
 *         Klasse zum speichern von spielerspezifischen Daten
 * 
 *
 */
public class Player {

	// Position des Spielers
	private Vector2 position;

	// Welcher Spieler? 1,2,3...
	private int playerNum;

	public Player(Vector2 pos, int playerNum) {
		this.setPosition(pos);
		this.setPlayerNum(playerNum);
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

}