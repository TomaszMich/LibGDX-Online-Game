package com.thebiggestsnake.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.thebiggestsnake.snake.snakeparts.SnakeHead;
import com.thebiggestsnake.snake.snakeparts.SnakeModule;
import com.thebiggestsnake.theBiggestSnake;
import com.thebiggestsnake.views.MainScreen;

import java.util.ArrayList;

public class Snake {
    private ArrayList<SnakeModule> modules;
    private theBiggestSnake game;
    private float speed;

    public Snake(theBiggestSnake g){
        this.game = g;
        this.modules = new ArrayList<SnakeModule>();
        modules.add(new SnakeHead(1000, 500, 22, new Vector2(1,1).nor().scl(2), this));
        for(int i = 1; i < 30; i++){
            modules.add(new SnakeModule(1000, 500 - 10f*i, 20, new Vector2(0,0), this));
        }
        this.speed = 3;
    }

    public void draw(ShapeRenderer renderer){
        for(SnakeModule module : modules.subList(1, modules.size()))
            module.draw(renderer);
        modules.get(0).draw(renderer);
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

    public boolean canEat(float x, float y){
        if(this.getHead().getModule().contains(x,y))
            return true;
        else return false;
    }

    public int getKey(){
        int yInt = (int)modules.get(0).getModule().y / MainScreen.DENSITY_OF_DIVISION ;
        return yInt;
    }
    public float getSpeed(){
        return this.speed;
    }

    public SnakeModule getHead()
    {
        return modules.get(0);
    }
}
