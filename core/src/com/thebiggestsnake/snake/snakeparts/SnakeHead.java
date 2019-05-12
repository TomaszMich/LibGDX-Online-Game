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
        dirVec = dirVec.set(Gdx.input.getX() - module.x, Gdx.input.getY() - module.y).nor().scl(2);
        super.move();
    }
}
