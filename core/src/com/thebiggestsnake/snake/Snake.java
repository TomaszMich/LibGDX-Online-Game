package com.thebiggestsnake.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.thebiggestsnake.snake.snakeparts.SnakeHead;
import com.thebiggestsnake.snake.snakeparts.SnakeModule;
import com.thebiggestsnake.theBiggestSnake;

import java.util.ArrayList;

public class Snake {
    private ArrayList<SnakeModule> modules;
    private theBiggestSnake game;
    private float speed;
    private ShapeRenderer renderer;

    public Snake(theBiggestSnake g, ShapeRenderer renderer){
        this.game = g;
        this.modules = new ArrayList<SnakeModule>();
        modules.add(new SnakeHead(100, 200, 24, new Vector2(1,1).nor().scl(2), this));
        for(int i = 1; i < 50; i++){
            modules.add(new SnakeModule(100, 200 - 10f*i, 20, new Vector2(0,0), this));
        }
        this.speed = 3;
        this.renderer = renderer;
    }

    public void draw(){
        for(SnakeModule module : modules)
            module.draw(this.renderer);
    }

    public void move(){
        modules.get(0).move();
        Circle prevCirc = modules.get(0).getModule();
        Vector2 vector = new Vector2();
        for(SnakeModule module : modules.subList(1, modules.size())){
            Circle curCirc = module.getModule();
            vector.set(prevCirc.x - curCirc.x, prevCirc.y - curCirc.y);
            vector.nor().scl(this.speed);
            module.move(vector);
            prevCirc = curCirc;
        }
    }

    public float getSpeed(){
        return this.speed;
    }
}
