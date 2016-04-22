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
	
	private ColliderRectangle collider;
	private Vector2 position;
	private int playerNum;
	public boolean cantmove;
	
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