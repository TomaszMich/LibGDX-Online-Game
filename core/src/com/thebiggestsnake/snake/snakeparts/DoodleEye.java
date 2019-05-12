package com.thebiggestsnake.snake.snakeparts;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class DoodleEye {

    private static final float scleraToHeadRatio = 0.3f;    //var for definig how big the sclera is compared to the head
    private static final float irisToScleraRatio = 0.4f;    //var for definig how big the iris is compared to the sclera


    private Circle sclera;
    private Circle iris;
    private SnakeHead head;

    public DoodleEye(SnakeHead head, boolean side){     //side = 0 for left eye, side = 1 for right eye
        this.head = head;
        Circle headCircle = head.getModule();
        //TODO make eye on the choosen side of the head
        Vector2 dir = head.getDirVec();
        sclera = new Circle(headCircle.x + dir.x*6, headCircle.y + dir.y*6, headCircle.radius*scleraToHeadRatio);
        iris = new Circle(sclera.x, sclera.y, sclera.radius*irisToScleraRatio);
    }

    public void draw(ShapeRenderer renderer){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        renderer.circle(sclera.x, sclera.y, sclera.radius);

        renderer.setColor(Color.BLACK);
        renderer.circle(iris.x, iris.y, iris.radius);
        renderer.end();
    }

    public void move(){
        Vector2 dir = head.getDirVec();
        sclera.x += dir.x;
        sclera.y += dir.y;
        iris.x += dir.x;
        iris.y += dir.y;
        moveIris();
    }

    private void moveIris(){
        //TODO whole math for iris moving inside the sclera
    }
}
