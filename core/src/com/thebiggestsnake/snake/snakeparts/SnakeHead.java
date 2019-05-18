package com.thebiggestsnake.snake.snakeparts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.thebiggestsnake.snake.Snake;

public class SnakeHead extends SnakeModule {

    private DoodleEye leftEye;

    public SnakeHead(float x, float y, float radius, Vector2 startingDir, Snake snake){
        super(x, y, radius, startingDir, snake);
        leftEye = new DoodleEye(this, false);
    }

    @Override
    public void move(){
        int mouseX = Gdx.input.getX() - Gdx.graphics.getWidth()/2;
        int mouseY = Gdx.graphics.getHeight()/2 - Gdx.input.getY();
        dirVec = dirVec.set(mouseX, mouseY).nor().scl(snake.getSpeed());
        super.move();
        leftEye.move();
    }

    @Override
    public void draw(ShapeRenderer renderer){
        super.draw(renderer);
        leftEye.draw(renderer);
    }

}
