package com.thebiggestsnake.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.thebiggestsnake.theBiggestSnake;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "The Biggest Snake";
        config.width = 1920;
        config.height = 1080;
		new LwjglApplication(new theBiggestSnake(), config);
	}
}
