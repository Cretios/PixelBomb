package com.mygdx.game;

import model.GameModel;
import model.Global;
import screens.Screens;

import com.badlogic.gdx.Game;

/**
 * 
 * @author Paul
 *
 *         Start Klasse NICHT ANFASSEN
 */
public class MyGdxGame extends Game {
	GameModel gameModel;

	@Override
	public void create() {
		Global.load();
		gameModel = new GameModel();

		setScreen(new Screens(gameModel));

	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
