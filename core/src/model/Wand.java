package model;

import Collision.ColliderRectangle;

import com.badlogic.gdx.math.Vector2;

public class Wand {

	public ColliderRectangle collider;
	public Vector2 pos;

	public Wand(Vector2 standort) {
		pos = standort;
		this.collider = new ColliderRectangle(pos.x + 8, pos.y + 8, 16, 16);
	}

}