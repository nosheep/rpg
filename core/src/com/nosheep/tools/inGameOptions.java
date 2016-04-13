package com.nosheep.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.main.rpgGame;

public class inGameOptions extends Window{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4931603277290850643L;
	private Button graphicOptions;
	private Button menu;
	private Button quit;
	
	public inGameOptions(String text, int positionX, int positionY, int width, int height) {
		super(text, positionX, positionY, width, height);
		graphicOptions = new Button("Graphic Options", positionX + 70, positionY + 100, 250, 70, true);
		menu = new Button("Logout", positionX + 70, positionY + 200, 250, 70, true);
		quit = new Button("Logout & Exit", positionX + 70, positionY + 300, 250, 70, true);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		if(isActive()){
			if(graphicOptions.clicked()){
				this.setActive(false);
				rpgGame.windows.get(0).setActive(true);
			}
			if(menu.clicked()){
				this.setActive(false);
				for(Window w : rpgGame.windows)
					w.setActive(false);
				rpgGame.setWindowed();
				rpgGame.menuIndex = 0;
				rpgGame.mainMenu = true;
				
			}
			if(quit.clicked()){
				for(Window w : rpgGame.windows)
					w.setActive(false);
				Gdx.app.exit();
			}
			super.render(batch);
			graphicOptions.update(getPositionX() + 70, getPositionY() + 100);
			menu.update(getPositionX() + 70, getPositionY() + 200);
			quit.update(getPositionX() + 70, getPositionY() + 300);
			graphicOptions.render(batch);
			menu.render(batch);
			quit.render(batch);
		}
	}
	@Override
	public void sRenderFill(ShapeRenderer render) {
		if(isActive()){
			super.sRenderFill(render);
			graphicOptions.sRenderFill(render);
			menu.sRenderFill(render);
			quit.sRenderFill(render);
		}
	}
	@Override
	public void sRenderLine(ShapeRenderer render) {
		if(isActive()){
			super.sRenderLine(render);
			graphicOptions.sRenderLine(render);
			menu.sRenderLine(render);
			quit.sRenderLine(render);
		}
	}
}
