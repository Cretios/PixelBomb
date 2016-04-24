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

	public PlayerController(Player player) {
		this.waittime = 1;
		this.anni = player;
	}

	/**
	 * Aktuallisierungsfunktion laeuft permanent wichtig für Bewegung und
	 * Collider
	 * 
	 * @param delta
	 */
	public void update(float delta) {
		movement(delta);
		anni.getCollider().update(anni.getPosition(), 8, 8);
	}

	public void bewegunghoch() {
		float a;
		float b;
		Vector2 position;
		Vector2 ziel;
		position = anni.getPosition();
		a = position.x + 0;
		b = position.y + 16;
		ziel = new Vector2(a, b);
		anni.setPosition(ziel);
	}
	public void bewegungrunter() {
		float a;
		float b;
		Vector2 position;
		Vector2 ziel;
		position = anni.getPosition();
		a = position.x + 0;
		b = position.y - 16;
		ziel = new Vector2(a, b);
		anni.setPosition(ziel);

	}
	public void bewegungrechts() {
		float a;
		float b;
		Vector2 position;
		Vector2 ziel;
		position = anni.getPosition();
		a = position.x + 16;
		b = position.y + 0;
		ziel = new Vector2(a, b);
		anni.setPosition(ziel);

	}
	public void bewegunglinks() {
		float a;
		float b;
		Vector2 position;
		Vector2 ziel;
		position = anni.getPosition();
		a = position.x - 16;
		b = position.y + 0;
		ziel = new Vector2(a, b);
		anni.setPosition(ziel);

	}

	public void movement(float delta) {
		// warte zeit wird runtergezählt
		waittime -= delta;
		if (waittime < 0) {
			if (anni.canmove == true){
			if (Gdx.input.isKeyPressed(Input.Keys.W)) {

				bewegunghoch();

				// Wartezeit zuruecksetzen
				waittime = 0.25f;

			}
		
			
			else if (Gdx.input.isKeyPressed(Input.Keys.A)) {

				// die Bewegung (links)
				bewegunglinks();
				// Wartezeit zuruecksetzen
				waittime = 0.25f;
			}
			
			else if (Gdx.input.isKeyPressed(Input.Keys.S)) {

				// die Bewegung (runter)
				bewegungrunter();
				// Wartezeit zuruecksetzen
				waittime = 0.25f;
			}
			
			else if (Gdx.input.isKeyPressed(Input.Keys.D)) {

				// die Bewegung (rechts)
				bewegungrechts();
				waittime = 0.25f;
			
			}}}
		}
	
	
	public boolean collision(ColliderRectangle colliwand){
		return anni.getCollider().collision(colliwand);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	