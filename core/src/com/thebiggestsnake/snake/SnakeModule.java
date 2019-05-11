package com.thebiggestsnake.snake;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class SnakeModule {
    private Circle module;
    private Vector2 dirVec;

    public SnakeModule(float x, float y, float radius, Vector2 startingDir){
        module = new Circle(x, y, radius);
        dirVec = new Vector2(startingDir);
    }

    public void move(){
        module.setX(module.x + dirVec.x);
        module.setY(module.y + dirVec.y);
    }

    public void move(Vector2 newDirVec){
        this.move();
        dirVec.set(newDirVec);
    }
}
