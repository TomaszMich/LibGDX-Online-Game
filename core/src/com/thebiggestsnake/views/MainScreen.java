package com.thebiggestsnake.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.thebiggestsnake.snake.food.ListOfFood;
import com.thebiggestsnake.snake.Snake;
import com.thebiggestsnake.theBiggestSnake;
import com.thebiggestsnake.snake.food.Food;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class MainScreen implements Screen {
    static final int WORLD_WIDTH = 10000;
    static final int WORLD_HEIGHT = 10000;
    static final int VIEW_SCOPE = Gdx.graphics.getWidth();
    public static final int DENSITY_OF_DIVISION = 50;

    private theBiggestSnake parent;
    private ArrayList<Snake> snakes;
    private Hashtable<Integer,ListOfFood> food;
    private ShapeRenderer renderer;
    private SpriteBatch batch;
    private OrthographicCamera cam;
    private float camW;
    private float camH;
    private Texture background;


    public MainScreen(theBiggestSnake parent) {
        this.parent = parent;
        this.snakes = new ArrayList<Snake>();
        this.snakes.add(new Snake(parent));
        this.renderer = new ShapeRenderer();
        this.batch = new SpriteBatch();
        this.background = new Texture(Gdx.files.internal("background.png"));
        background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        cam = new OrthographicCamera(VIEW_SCOPE, VIEW_SCOPE * (h / w));
        camW = cam.viewportWidth / 2f;
        camH = cam.viewportHeight / 2f;
        cam.position.set(camW, camH, 0);
        cam.update();


        //adding food
        Random ran = new Random();
        this.food = new Hashtable<Integer,ListOfFood>();
        for(int i = 0; i < 500; i++){
            float x = ran.nextFloat()*WORLD_WIDTH;
            float y = ran.nextFloat()*WORLD_HEIGHT;

            Food f = new Food(x,y,10);
            int xInt = (int)x / this.DENSITY_OF_DIVISION ;
            int yInt = (int)y / this.DENSITY_OF_DIVISION ;
            int key = yInt;
            if(this.food.containsKey(key)){
                this.food.get(key).add(f);
            }
            else{
                this.food.put(key, new ListOfFood<Food>(key));
                this.food.get(key).add(f);
            }
        }
        this.food = null;
    }

    @Override
    public void show() {

    }

    @Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0.2f, 0.8f, 0.8f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		batch.draw(background, 0, 0, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);
		batch.end();
        renderer.setProjectionMatrix(cam.combined);


        //randering food
        //for (food f : this.food)
            //f.draw(renderer);

        //rendering snakes
        for (Snake s : this.snakes){
            s.move();
            s.draw(renderer);
        }

        cam.position.set(snakes.get(0).getHead().getModule().x, snakes.get(0).getHead().getModule().y, 0);
        cam.update();
	}

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
