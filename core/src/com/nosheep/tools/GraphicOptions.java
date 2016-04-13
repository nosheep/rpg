package com.nosheep.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.main.rpgGame;

public class GraphicOptions extends Window{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2063489243121554691L;
	private Button fullScreen;
	private Button window;
	private Button windowedFullscreen;
	private Button vSync;
	private boolean vSyncActive = false;
	
	public GraphicOptions(String text, int positionX, int positionY, int width, int height) {
		super(text, positionX, positionY, width, height);
		fullScreen = new Button("Fullscreen", positionX + 100, positionY + 150, 300, 70, true);
		window = new Button("Window", positionX + 450, positionY + 150, 300, 70, true);
		windowedFullscreen = new Button("Windowed Fullscreen", positionX + 800, positionY + 150, 330, 70, true);
		vSync = new Button("Off", positionX + 200, positionY + 250, 100, 70, true);
	}
	private void checkClick(){
		if(fullScreen.clicked()){
			rpgGame.setFullScreen();
		}
		if(windowedFullscreen.clicked()){
			rpgGame.setWindowedFullscreen();
		}
		if(window.clicked()){
			rpgGame.setWindowed();
		}
		if(vSync.clicked()){
			if(vSyncActive){
				Gdx.graphics.setVSync(false);
				vSync.setText("Off");
				vSyncActive = false;
			}
			else{
				Gdx.graphics.setVSync(true);
				vSync.setText("On");
				vSyncActive = true;
			}
		}
	}
	@Override
	public void render(SpriteBatch batch) {
		if(isActive()){
			checkClick();
			super.render(batch);
			fullScreen.update(positionX + 100, positionY + 150);
			window.update(positionX + 450, positionY + 150);
			windowedFullscreen.update(positionX + 800, positionY + 150);
			vSync.update(positionX + 200, positionY + 250);
			vSync.setWidth(100);
			vSync.setHeight(70);
			fullScreen.render(batch);
			window.render(batch);
			windowedFullscreen.render(batch);
			rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, "vSync", positionX + 100, positionY + 270);
			vSync.render(batch);
		}
	}
	@Override
	public void sRenderFill(ShapeRenderer render) {
		if(isActive()){
			super.sRenderFill(render);
			fullScreen.sRenderFill(render);
			window.sRenderFill(render);
		}
	}
	@Override
	public void sRenderLine(ShapeRenderer render) {
		if(isActive()){
			super.sRenderLine(render);
			fullScreen.sRenderLine(render);
			window.sRenderLine(render);
		}
	}
}
