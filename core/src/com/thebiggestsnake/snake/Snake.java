package com.thebiggestsnake.snake;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.thebiggestsnake.snake.snakeparts.SnakeHead;
import com.thebiggestsnake.snake.snakeparts.SnakeModule;
import com.thebiggestsnake.theBiggestSnake;

import java.util.ArrayList;

public class Snake {
    private ArrayList<SnakeModule> modules;
    private theBiggestSnake game;

    public Snake(theBiggestSnake g){
        this.game = g;
        this.modules = new ArrayList<SnakeModule>();
        modules.add(new SnakeHead(100, 200, 24, new Vector2(1,1).nor().scl(2), this));
        for(int i = 1; i < 10; i++){
            modules.add(new SnakeModule(100, 200 - 10f*i, 20, new Vector2(1,1).nor().scl(2), this));
        }
    }

    public void draw(){
        for(SnakeModule module : modules)
            module.draw();
    }

    public void move(){
        modules.get(0).move();
        Circle prevCirc = modules.get(0).getModule();
        for(SnakeModule module : modules.subList(1, modules.size())){
            Circle curCirc = module.getModule();
            Vector2 vector = new Vector2(prevCirc.x - curCirc.x, prevCirc.y - curCirc.y );
            vector.nor().scl(2);
            module.move(vector);
            prevCirc = curCirc;
        }
    }
}
