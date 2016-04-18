package characters;

import Collision.ColliderRectangle;

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

	// Spieler Collider
	private ColliderRectangle collider;

	// Position des Spielers
	private Vector2 position;

	// Welcher Spieler? 1,2,3...
	private int playerNum;

	public Player(Vector2 pos, int playerNum) {

		this.setPosition(pos);
		this.setPlayerNum(playerNum);
		this.setCollider(new ColliderRectangle(pos.x + 8, pos.y + 8, 16, 16));

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

	public ColliderRectangle getCollider() {
		return collider;
	}

	public void setCollider(ColliderRectangle collider) {
		this.collider = collider;
	}

}