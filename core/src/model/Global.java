package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

public class Global {

	public static TiledMap map;

	public static Texture texturePlayer1;
	public static Sprite player1Sprite;

	public static void load() {
		map = new TmxMapLoader().load("Map/PixelBombTestMap.tmx");

		texturePlayer1 = new Texture("Sprites/male.png");
		player1Sprite = new Sprite(texturePlayer1);
	}

	public Vector2 transformTilesToPixel(float tileX, float tileY) {
		// if (tileY < 14) {
		// tileY = 14;
		// }
		// if (tileX < 20) {
		// tileX = 20;
		// }
		return new Vector2(tileX * 16, (44 - tileY) * 16);
	}

}