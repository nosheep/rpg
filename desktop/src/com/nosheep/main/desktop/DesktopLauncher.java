package com.nosheep.main.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nosheep.main.rpgGame;

public class DesktopLauncher {
	public static void main (String[] arg) {

		/*Patcher patcher = new Patcher();
		while(patcher.progressBar.getValue() < patcher.progressBar.getMaximum()){
			for(int i = 0; i < 10000000; i++){
				if(i % 100000 == 0)
					patcher.progressBar.setValue(patcher.progressBar.getValue() + 1);
			}
		}
		patcher.dispose();*/
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "ReallyPoorGraphics";
		config.width = 1280;
		config.height = config.width / 16 * 9;
		config.vSyncEnabled = false;
		config.addIcon("icon/icon.png", Files.FileType.Internal);
		new LwjglApplication(new rpgGame(), config);
	}
}
