package com.thebiggestsnake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thebiggestsnake.snake.Snake;
import java.util.ArrayList;
import com.thebiggestsnake.views.*;


public class theBiggestSnake extends Game {
    private LoadingScreen loadingScreen;
    private PreferencesScreen preferencesScreen;
    private MenuScreen menuScreen;
    private MainScreen mainScreen;
    private EndScreen endScreen;

    public final static int MENU = 0;
    public final static int PREFERENCES = 1;
    public final static int APPLICATION = 2;
    public final static int ENDGAME = 3;
	
	@Override
	public void create () {
        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
	}
	
	@Override
	public void dispose () {

	}

    public void changeScreen(int screen){
        switch(screen){
            case MENU:
                if(menuScreen == null) menuScreen = new MenuScreen(this);
                this.setScreen(menuScreen);
                break;
            case PREFERENCES:
                if(preferencesScreen == null) preferencesScreen = new PreferencesScreen(this);
                this.setScreen(preferencesScreen);
                break;
            case APPLICATION:
                if(mainScreen == null) mainScreen = new MainScreen(this);
                this.setScreen(mainScreen);
                break;
            case ENDGAME:
                if(endScreen == null) endScreen = new EndScreen(this);
                this.setScreen(endScreen);
                break;
        }
    }

}
