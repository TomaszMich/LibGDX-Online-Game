package com.thebiggestsnake.snake;

import com.badlogic.gdx.math.Circle;
import com.thebiggestsnake.theBiggestSnake;

import java.util.ArrayList;

public class Snake {
    private ArrayList<Circle> circles;
    private theBiggestSnake game;

    public Snake(theBiggestSnake g){
        this.game = g;
    }
}
