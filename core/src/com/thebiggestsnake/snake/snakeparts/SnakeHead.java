package com.thebiggestsnake.snake.snakeparts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.thebiggestsnake.snake.Snake;

public class SnakeHead extends SnakeModule {

    //TODO add eyes to the head

    public SnakeHead(float x, float y, float radius, Vector2 startingDir, Snake snake){
        super(x, y, radius, startingDir, snake);
    }

    @Override
    public void move(){
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
        dirVec = dirVec.set(mouseX - module.x, mouseY - module.y).nor().scl(snake.getSpeed());
        super.move();
    }
}
