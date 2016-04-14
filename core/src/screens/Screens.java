package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * 
 * @author Paul
 *
 *         Ausgabe Klasse:
 *
 *         Hier wird alles gerendert, also die ganze Anzeige von der Karte,
 *         Spieler...
 *
 */

public class Screens implements Screen {

	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;

	ShapeRenderer shapeRenderer;

	public Screens() {

	}

	public Vector2 transformTilesToPixel(int tileX, int tileY) {
		if (tileY < 14) {
			tileY = 14;
		}
		if (tileX < 20) {
			tileX = 20;
		}
		return new Vector2(tileX * 16, (44 - tileY) * 16);
	}

	@Override
	public void show() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		System.out.println(h);

		map = new TmxMapLoader().load("map/PixelBombTestMap.tmx");

		renderer = new OrthogonalTiledMapRenderer(map);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
		camera.position.set(transformTilesToPixel(19, 13), 0);
		// camera.position.set(20, 24, 3);
		camera.update();

		shapeRenderer = new ShapeRenderer();

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderer.setView(camera);
		renderer.render();

	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.zoom = 0.5f;
		camera.update();

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
		map.dispose();
		renderer.dispose();
		disposeRats();
	}

	public void disposeRats() {

	}

}
