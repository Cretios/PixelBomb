package controller;

import Collision.ColliderRectangle;
import characters.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

/**
 * 
 * @author Paul
 *
 *         Klasse für ALLE Spieler Aktionen: Bewegung z.B.
 */
public class PlayerController {

	private float waittime;
	public Player anni;

	private Vector2 newPos;
	private Vector2 oldPos;

	public PlayerController(Player player) {
		this.waittime = 1;
		this.anni = player;
		anni.canmove = true;
	}

	/**
	 * Aktuallisierungsfunktion laeuft permanent wichtig für Bewegung und
	 * Collider
	 * 
	 * @param delta
	 */
	public void update(float delta) {

		movement(newPos);

	}

	public Vector2 bewegunghoch() {
		float a;
		float b;
		Vector2 position;
		position = anni.getPosition();
		a = position.x + 0;
		b = position.y + 16;
		return new Vector2(a, b);
	}

	public Vector2 bewegungrunter() {
		float a;
		float b;
		Vector2 position;
		position = anni.getPosition();
		a = position.x + 0;
		b = position.y - 16;
		return new Vector2(a, b);

	}

	public Vector2 bewegungrechts() {
		float a;
		float b;
		Vector2 position;
		position = anni.getPosition();
		a = position.x + 16;
		b = position.y + 0;
		return new Vector2(a, b);
	}

	public Vector2 bewegunglinks() {
		float a;
		float b;
		Vector2 position;
		position = anni.getPosition();
		a = position.x - 16;
		b = position.y + 0;
		return new Vector2(a, b);

	}

	public void movement(Vector2 target) {

		if (anni.canmove == true) {
			anni.setPosition(target);
		}
	}

	public Vector2 nextPos(float delta) {
		// ziel vector für collision
		Vector2 target = anni.getPosition();
		// warte zeit wird runtergezählt
		waittime -= delta;

		if (waittime < 0) {

			if (Gdx.input.isKeyPressed(Input.Keys.W)) {

				target = bewegunghoch();

				// Wartezeit zuruecksetzen
				waittime = 0.25f;

			}

			else if (Gdx.input.isKeyPressed(Input.Keys.A)) {

				// die Bewegung (links)
				target = bewegunglinks();
				// Wartezeit zuruecksetzen
				waittime = 0.25f;
			}

			else if (Gdx.input.isKeyPressed(Input.Keys.S)) {

				// die Bewegung (runter)
				target = bewegungrunter();
				// Wartezeit zuruecksetzen
				waittime = 0.25f;
			}

			else if (Gdx.input.isKeyPressed(Input.Keys.D)) {

				// die Bewegung (rechts)
				target = bewegungrechts();
				waittime = 0.25f;

			}
		}
		anni.getCollider().update(target, 8, 8);
		newPos = target;
		return target;
	}

	public boolean collision(ColliderRectangle colliwand) {
		return anni.getCollider().collision(colliwand);
	}
}
