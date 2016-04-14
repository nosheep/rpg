package com.nosheep.main.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nosheep.main.rpgGame;

public class GameLauncher {
	public GameLauncher(){
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "ReallyPoorGraphics";
		config.width = 1280;
		config.height = config.width / 16 * 9;
		config.vSyncEnabled = false;
		config.addIcon("icon/icon.png", Files.FileType.Internal);
		new LwjglApplication(new rpgGame(), config);
	}
}
