package com.thebiggestsnake.snake.snakeparts;


import com.badlogic.gdx.math.Circle;

public class DoodleEye {

    private static final float scleraToHeadRatio = 0.2f;    //var for definig how big the sclera is compared to the head
    private static final float irisToScleraRatio = 0.4f;    //var for definig how big the iris is compared to the sclera


    private Circle sclera;
    private Circle iris;;
    private SnakeHead head;

    public DoodleEye(SnakeHead head, boolean side){     //side = 0 for left eye, side = 1 for right eye
        this.head = head;
        Circle headCircle = head.getModule();
        //TODO make eye on the choosen side of the head
        sclera = new Circle(headCircle.x, headCircle.y, headCircle.radius*scleraToHeadRatio);
        iris = new Circle(sclera.x, sclera.y, sclera.radius*irisToScleraRatio);
    }

    private void moveIris(){
        //TODO whole math for iris moving inside the sclera
    }
}
