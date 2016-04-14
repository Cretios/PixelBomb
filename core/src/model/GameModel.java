package model;

import characters.Player;

import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

/**
 * 
 * @author Paul
 *
 *         Speicher Klasse für alles im Spiel: Spieler, Gegner, items etz.
 *
 *         Hier wird auch alles andere getan: so zusagen ein
 *         Controllercontroller
 *
 */
public class GameModel {
	public Player[] players;
	private int playerCounter;
	TiledMap map;

	public GameModel() {

		// 4 Spieler
		players = new Player[4];
		// Spieler Nummer
		playerCounter = 1;

		// Alle Spieler auf einmal erstellen

		MapObjects objlayer = Global.map.getLayers().get("Spawns").getObjects();
		for (int i = 0; i < objlayer.getCount(); i++) {
			RectangleMapObject obj = (RectangleMapObject) objlayer.get(i);
			players[i] = createPlayer(new Vector2(obj.getRectangle().x,
					obj.getRectangle().y));
		}
	}

	// Spieler erstellen Methode
	public Player createPlayer(Vector2 pos) {
		Player player = new Player(pos, playerCounter);
		playerCounter++;

		return player;
	}
}