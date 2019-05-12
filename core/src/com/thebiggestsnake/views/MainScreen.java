package com.thebiggestsnake.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.thebiggestsnake.snake.Snake;
import com.thebiggestsnake.theBiggestSnake;

import java.util.ArrayList;

public class MainScreen implements Screen {
    private theBiggestSnake parent;
    private SpriteBatch batch;
    private ArrayList<Snake> snakes;
    private ShapeRenderer renderer = new ShapeRenderer();


    public MainScreen(theBiggestSnake parent) {
        this.parent = parent;
        this.snakes = new ArrayList<Snake>();
        this.snakes.add(new Snake(parent));
        batch = new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
	public void render (float delta) {
		Gdx.gl.glClearColor(1, 0.5f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		for (Snake s : this.snakes){
            s.move();
            s.draw(renderer);
        }
		batch.end();
	}

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
