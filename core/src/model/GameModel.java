package model;

import characters.Player;

import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.IntMap.Entry;

import controller.PlayerController;

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
	public IntMap<PlayerController> players;
	private int playerCounter;
	TiledMap map;
	public Wand wand;

	public GameModel() {

		// 4 Spieler
		players = new IntMap<PlayerController>();
		// Spieler Nummer
		playerCounter = 1;

		// Alle Spieler auf einmal erstellen

		MapObjects objlayer = Global.map.getLayers().get("Spawns").getObjects();
		for (int i = 0; i < objlayer.getCount(); i++) {
			RectangleMapObject obj = (RectangleMapObject) objlayer.get(i);
			players.put(
					i,
					createPlayer(new Vector2(obj.getRectangle().x, obj
							.getRectangle().y)));
			wand = new Wand(Global.transformTilesToPixel(26, 10));
		}
	}

	public void update(float delta) {
		for (Entry<PlayerController> player : players) {
			if (!player.value.anni.equals(null)) {
				player.value.nextPos(delta);

				if (player.value.collision(wand.collider) == true) {
					player.value.anni.canmove = false;
				} else {
					player.value.anni.canmove = true;
				}

				player.value.update(delta);
			}
		}
	}

	// Spieler erstellen Methode
	public PlayerController createPlayer(Vector2 pos) {
		Player player = new Player(pos, playerCounter);
		playerCounter++;

		PlayerController playerController = new PlayerController(player);

		return playerController;
	}

}
