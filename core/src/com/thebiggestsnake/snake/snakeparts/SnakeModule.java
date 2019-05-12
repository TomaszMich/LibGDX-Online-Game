package com.thebiggestsnake.snake.snakeparts;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.thebiggestsnake.snake.Snake;

import java.awt.geom.Point2D;

public class SnakeModule {
    protected Circle module;
    protected Vector2 dirVec;
    private Snake snake;

    public SnakeModule(float x, float y, float radius, Vector2 startingDir, Snake snake){
        module = new Circle(x, y, radius);
        dirVec = new Vector2(startingDir);
        this.snake = snake;
    }

    public void move(){
        //TODO include snake's speed into calculations
        module.setX(module.x + dirVec.x);
        module.setY(module.y + dirVec.y);
    }

    public void move(Vector2 newDirVec){
        this.move();
        dirVec.set(newDirVec);
    }

    public Circle getModule(){
        return module;
    }

    public Vector2 getDirVec() {
        return dirVec;
    }

    public void draw(){
        ShapeRenderer renderer = new ShapeRenderer();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.GREEN);
        renderer.circle(module.x, module.y, module.radius);
        renderer.end();
    }
}
