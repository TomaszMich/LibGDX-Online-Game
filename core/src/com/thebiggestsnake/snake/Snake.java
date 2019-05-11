package com.thebiggestsnake.snake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.thebiggestsnake.theBiggestSnake;

import java.util.ArrayList;

public class Snake {
    private ArrayList<SnakeModule> snakeModules;
    private theBiggestSnake game;
    ShapeRenderer renderer;

    public Snake(theBiggestSnake g){
        this.game = g;
        this.snakeModules = new ArrayList<SnakeModule>();
        this.renderer = new ShapeRenderer();
    }

    public void draw(){
        for(SnakeModule sM : this.snakeModules) {
            Circle circle = sM.getModule();
            renderer.circle(circle.x,circle.y,circle.radius);
        }
    }
}
