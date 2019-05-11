package com.thebiggestsnake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class theBiggestSnake extends ApplicationAdapter {
	private SpriteBatch batch;
	private ArrayList<Snake> snakes;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.snakes = new ArrayList<Snake>();
		this.snakes.add(new Snake(this));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (Snake s : this.snakes)
			s.draw();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
