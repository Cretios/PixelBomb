package com.mygdx.game;

import screens.Screens;

import com.badlogic.gdx.Game;

/**
 * 
 * @author Paul
 *
 *         Start Klasse NICHT ANFASSEN
 */
public class MyGdxGame extends Game {

	@Override
	public void create() {
		setScreen(new Screens());

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
