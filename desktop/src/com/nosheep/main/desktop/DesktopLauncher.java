package com.nosheep.main.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nosheep.main.Patcher;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "patcher_nosheep";
		config.width = 1024;
		config.height = config.width / 16 * 9;
		config.resizable = false;
		config.addIcon("icon/logo.png", Files.FileType.Internal);
		System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		new LwjglApplication(new Patcher(), config);
	}
}
