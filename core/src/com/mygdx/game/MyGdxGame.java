package com.mygdx.game;

import model.GameModel;
import model.Global;
import screens.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

/**
 * 
 * @author Paul
 *
 *         Start Klasse NICHT ANFASSEN
 */
public class MyGdxGame extends Game {
	GameModel gameModel;
	InputMultiplexer inputMultiplexer;

	@Override
	public void create() {
		Global.load();
		gameModel = new GameModel();
		inputMultiplexer = new InputMultiplexer();
		InputProcessor screen = new Screens(gameModel);
		setScreen((Screen) screen);
		addInputProcessor(screen);

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

	public void addInputProcessor(InputProcessor inputProcessor) {
		inputMultiplexer.addProcessor(inputProcessor);
		Gdx.input.setInputProcessor(inputMultiplexer);
	}
}
