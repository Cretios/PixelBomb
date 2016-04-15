package controller;
import characters.Player;

import com.badlogic.gdx.math.Vector2;

/**
 * 
 * @author Paul
 *
 *         Klasse für ALLE Spieler Aktionen: Bewegung z.B.
 */
public class PlayerController {
	
	public Player player; 
	
	public PlayerController(Player player) {
	
		this.player = player;
	}
	
	public void bewegunghoch () {
		float a;
		float b;
		Vector2 position;
		Vector2 ziel;
		position = player.getPosition();
		a = position.x+0;
		b = position.y+16;
		ziel = new Vector2 (a, b);
		player.setPosition(ziel);
		
	}


}