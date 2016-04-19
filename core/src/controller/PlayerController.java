package controller;

import characters.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

/**
 * 
 * @author Paul
 *
 *         Klasse f�r ALLE Spieler Aktionen: Bewegung z.B.
 */
public class PlayerController {

	private float waittime;

	public Player player;

	public PlayerController(Player player) {
		this.waittime = 1;
		this.player = player;
	}

	/**
	 * Aktuallisierungsfunktion laeuft permanent wichtig f�r Bewegung und
	 * Collider
	 * 
	 * @param delta
	 */
	public void update(float delta) {
		movement(delta);
		player.getCollider().update(player.getPosition(), 8, 8);
	}

	public void bewegunghoch() {
		float a;
		float b;
		Vector2 position;
		Vector2 ziel;
		position = player.getPosition();
		a = position.x + 0;
		b = position.y + 16;
		ziel = new Vector2(a, b);
		player.setPosition(ziel);

	}

	public void movement(float delta) {
		// warte zeit wird runtergez�hlt
		waittime -= delta;

		// eine sekunde warten damit der spieler sich nicht "beamt"
		// wird sp�ter angepasst damit der spieler fl�ssig l�uft
		if (waittime < 0) {

			// Tastenanschlag W
			if (Gdx.input.isKeyPressed(Input.Keys.W)) {

				// die Bewegung (hoch)
				bewegunghoch();

				// Wartezeit zuruecksetzen
				waittime = 1;

			}
			// Tastenanschlag A
			else if (Gdx.input.isKeyPressed(Input.Keys.A)) {

				// die Bewegung (links)

				// Wartezeit zuruecksetzen
				waittime = 1;
			}
			// Tastenanschlag S
			else if (Gdx.input.isKeyPressed(Input.Keys.S)) {

				// die Bewegung (runter)

				// Wartezeit zuruecksetzen
				waittime = 1;
			}
			// Tastenanschlag D
			else if (Gdx.input.isKeyPressed(Input.Keys.D)) {

				// die Bewegung (rechts)

				waittime = 1;
			}
		}
	}
}