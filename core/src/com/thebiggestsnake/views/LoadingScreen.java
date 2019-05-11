package com.thebiggestsnake.views;

import com.badlogic.gdx.Screen;
import com.thebiggestsnake.theBiggestSnake;

public class LoadingScreen implements Screen {
    private theBiggestSnake parent;

    public LoadingScreen(theBiggestSnake parent) {
        this.parent = parent;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        parent.changeScreen(theBiggestSnake.MENU);
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
