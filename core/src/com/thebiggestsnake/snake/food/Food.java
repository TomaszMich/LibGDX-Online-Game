package com.thebiggestsnake.snake.food;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

import java.util.Random;

public class Food {


    protected Circle circle;
    protected Color color;

    public Food(float x, float y, float r) {
        this.circle = new Circle(x,y,r);

        Random ran = new Random();
        this.color = new Color(ran.nextFloat(),ran.nextFloat(),ran.nextFloat(),ran.nextFloat());
    }

    public void draw(ShapeRenderer renderer){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(this.color);
        renderer.circle(circle.x, circle.y, circle.radius);
        renderer.end();
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

}
