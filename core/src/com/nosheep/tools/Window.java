package com.nosheep.tools;

import java.io.Serializable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;

public abstract class Window implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4487016020269928471L;
	protected String text;
	private boolean moving = false;
	private boolean active;
	protected int positionX, positionY, width, height;
	
	Vector3 mouse;
	Vector3 screen;
	public Window(){}
	public Window(String text, int positionX, int positionY, int width, int height){
		active = false;
		this.text = text;
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
		mouse = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		screen = new Vector3(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
	}
	private void checkExit(){
		if(Gdx.input.justTouched() && rpgGame.checkHover((positionX + width) - 50, positionY + 10, 40, 40)){
			this.active = false;
		}
	}
	private void checkMove(){
		if(rpgGame.checkHover(positionX, positionY, width, 60) && 
				!rpgGame.checkHover((positionX + width) - 50, positionY + 10, 40, 40)){
			if(Gdx.input.isTouched())
				moving = true;
			else
				moving = false;
		}
	}
	private void move(){
		mouse.x = Gdx.input.getX();
		mouse.y = Gdx.input.getY();
		rpgGame.cam.unproject(mouse);
		screen.x = Gdx.graphics.getWidth();
		screen.y = Gdx.graphics.getHeight();
		rpgGame.cam.unproject(screen);
		positionX = (int)(mouse.x - width / 2);
		positionY = (int)(mouse.y - 10);
		if(positionX <= 5)
			positionX = 5;
		if(positionY <= 5)
			positionY = 5;
		if(positionX + width >= screen.x)
			positionX = (int)(screen.x - (width + 5));
		if(positionY + height >= screen.y)
			positionY = (int)(screen.y - (height + 5));
	}
	public void render(SpriteBatch batch){
		if(active)
			checkMove();
		
		if(moving)
			move();
		checkExit();
		if(active){
			batch.draw(AssetLoader.ui, positionX, positionY, width, height);
			batch.draw(AssetLoader.ui, positionX, positionY, width, 60);
			
			if(!rpgGame.checkHover((positionX + width) - 50, positionY + 10, 40, 40)) {
				batch.draw(AssetLoader.slot, (positionX + width) - 50, positionY + 10, 40, 40);
			}
			else {
				batch.draw(AssetLoader.black, positionX + width - 52, positionY + 8, 44, 44);
				batch.draw(AssetLoader.buttonHover, (positionX + width) - 50, positionY + 10, 40, 40);
			}
			rpgGame.font.setColor(Color.BLACK);
			rpgGame.font.draw(batch, "X", positionX + width - 37, positionY + 18);
			
			rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, text, positionX + 10, positionY + 20);
		}
	}
	public void sRenderFill(ShapeRenderer render){
		if(active){
			/*render.setColor(Color.BLACK);
			render.rect(positionX, positionY, width, height);
			if(rpgGame.checkHover(positionX, positionY, width, 60) && 
					!rpgGame.checkHover((positionX + width) - 50, positionY + 10, 40, 40))
				render.setColor(Color.DARK_GRAY);
			else
				render.setColor(Color.BLACK);
			render.rect(positionX, positionY, width, 60);
			
			if(rpgGame.checkHover((positionX + width) - 50, positionY + 10, 40, 40))
				render.setColor(Color.YELLOW);
			else
				render.setColor(Color.BLACK);
			render.rect((positionX + width) - 50, positionY + 10, 40, 40);*/
		}
	}
	public void sRenderLine(ShapeRenderer render){
		if(active){
			/*render.setColor(Color.ORANGE);
			render.rect(positionX, positionY, width, height);
			render.rect(positionX, positionY, width, 60);
			
			render.rect((positionX + width) - 50, positionY + 10, 40, 40);
			render.line((positionX + width) - 10, positionY + 10, (positionX + width) - 50, positionY + 50);
			render.line((positionX + width) - 50, positionY + 10, (positionX + width) - 10, positionY + 50);*/
		}
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isHovered() {
		if(active){
			if(rpgGame.checkHover(positionX, positionY, width, height))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
