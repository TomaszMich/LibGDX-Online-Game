package com.thebiggestsnake.snake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.thebiggestsnake.snake.snakeparts.SnakeHead;
import com.thebiggestsnake.theBiggestSnake;
import com.thebiggestsnake.snake.snakeparts.SnakeModule;

import java.util.ArrayList;
import java.util.Random;

public class Snake {
    private ArrayList<SnakeModule> snakeModules;
    private theBiggestSnake game;
    ShapeRenderer renderer;
    Color color;

    public Snake(theBiggestSnake g){
        this.game = g;
        this.snakeModules = new ArrayList<SnakeModule>();
        this.renderer = new ShapeRenderer();
        Random rd = new Random();
        this.color = new Color(rd.nextFloat(),rd.nextFloat(),rd.nextFloat(),rd.nextFloat());
        float x = rd.nextFloat();
        float y = rd.nextFloat();
        float r = rd.nextFloat();
        snakeModules.add(new SnakeHead(x, y,r,new Vector2(0,1),this));
        for (int i = 1; i < 10; i++){
            snakeModules.add(new SnakeModule(x,y - i,r,new Vector2(0,1),this));
        }
    }

    public void draw(){
        for(SnakeModule sM : this.snakeModules) {
            Circle circle = sM.getModule();
            renderer.begin(ShapeRenderer.ShapeType.Filled);
            renderer.setColor(this.color);
            renderer.circle(circle.x,circle.y,circle.radius);
            renderer.end();
        }
    }

    public void move(Vector2 newDirVec){
        Vector2 newVec;
        for(int i = 0; i < this.snakeModules.size(); i++){
            if(i == 0) {
                newVec = this.snakeModules.get(i).getDirVec();
                this.snakeModules.get(i).move(newDirVec);
            }
            else{
                newVec = this.snakeModules.get(i).getDirVec();
                this.snakeModules.get(i).move(newVec);
            }
        }
    }

    public void draw(){
        //TODO
    }
}
