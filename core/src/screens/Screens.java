package screens;

import model.GameModel;
import model.Global;
import Collision.ColliderRectangle;
import characters.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

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

public class Screens implements Screen, InputProcessor {

	SpriteBatch batch;

	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;

	ShapeRenderer shapeRenderer;

	private GameModel gameModel;

	private Array<Sprite> sprites;
	private Array<ColliderRectangle> collider;
	private boolean colliderRender;

	public Screens(GameModel gameModel) {
		this.gameModel = gameModel;
		this.sprites = new Array<Sprite>();
		this.collider = new Array<ColliderRectangle>();
		this.colliderRender = false;
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

	@Override
	public void show() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		renderer = new OrthogonalTiledMapRenderer(Global.map);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
		camera.position.set(transformTilesToPixel(19, 13), 0);
		// camera.position.set(20, 24, 3);

		camera.update();

		shapeRenderer = new ShapeRenderer();

		batch = new SpriteBatch();

	}

	public void playerRender() {

		for (int i = 0; i < gameModel.players.size; i++) {
			if (gameModel.players.get(i).player != null) {
				if (gameModel.players.get(i).player.getPlayerNum() == 1) {

					Player player = gameModel.players.get(i).player;
					Sprite s = new Sprite(Global.player1Sprite);

					s.setPosition(player.getPosition().x,
							player.getPosition().y);

					System.out.println(player.getPosition());
					ColliderRectangle playercoll = player.getCollider();

					collider.add(playercoll);
					sprites.add(s);

				}
			}
		}

	}

	public void walls() {
		Vector2 wall = transformTilesToPixel(gameModel.wand.pos.x,
				gameModel.wand.pos.y);
		Sprite a = new Sprite(Global.player1Sprite);
		a.setPosition(wall.x, wall.y);
		// a.setPosition(20, 20);
		sprites.add(a);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderer.setView(camera);
		renderer.render();
		playerRender();
		walls();
		gameModel.update(delta);
		// ---

		// ---
		for (Sprite s : sprites) {
			renderer.getBatch().begin();
			s.draw(renderer.getBatch());
			renderer.getBatch().end();
		}
		if (colliderRender) {
			for (ColliderRectangle c : collider) {
				shapeRenderer.setProjectionMatrix(camera.combined);
				shapeRenderer.begin(ShapeType.Line);

				shapeRenderer.line(c.getBL(), c.getBR());
				shapeRenderer.line(c.getBL(), c.getUL());
				shapeRenderer.line(c.getBR(), c.getUR());
				shapeRenderer.line(c.getUL(), c.getUR());
				shapeRenderer.setColor(Color.RED);

				shapeRenderer.end();

			}
		}
		sprites.clear();
		collider.clear();
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.zoom = 0.5f;
		camera.update();

	}

	private void toggleRenderCollider() {
		this.colliderRender = !colliderRender;

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
		renderer.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		if (character == 'h') {
			toggleRenderCollider();
		}
		return false;
	}

}
