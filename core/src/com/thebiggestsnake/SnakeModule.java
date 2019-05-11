package com.thebiggestsnake;

import com.badlogic.gdx.math.Circle;
import com.sun.javafx.geom.Vec2d;

public class SnakeModule {
    private Circle module;
    private Vec2d dirVec;

    public SnakeModule(float x, float y, float radius, Vec2d startingDir){
        module = new Circle(x, y, radius);
        dirVec = new Vec2d(startingDir);
    }

    public void move(){
        module.setX((float)(module.x + dirVec.x));
        module.setY((float)(module.y + dirVec.y));
    }

    public void move(Vec2d newDirVec){
        this.move();
        dirVec.set(newDirVec);
    }
}
