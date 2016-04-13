package com.nosheep.tools;

import java.io.Serializable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;

public class Button implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7218342608918211786L;
	private boolean windowComponent;
	private String text;
	private int positionX, positionY, width, height;
	
	public Button(String text, int positionX, int positionY, int width, int height, boolean windowComponent){
		this.text = text;
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
		this.windowComponent = windowComponent;
	}
	
	public boolean clicked(){
		if(Gdx.input.justTouched() && rpgGame.checkHover(positionX, positionY, width, height)){
			if(windowComponent)
				return true;
			else{
				for(Window w : rpgGame.windows){
					if(rpgGame.checkHover(w.getPositionX(), w.getPositionY(), w.getWidth(), w.getHeight())
							&& w.isActive()){
						return false;
					}
					else
						return true;
				}
			}
			return false;
		}
		else
			return false;
	}
	public void render(SpriteBatch batch){
		if(rpgGame.checkHover(positionX, positionY, width, height)){
			batch.draw(AssetLoader.black, positionX - 10, positionY - 10, width + 20, height + 20);
			batch.draw(AssetLoader.buttonHover, positionX, positionY, width, height);
		}		
		else{
			batch.draw(AssetLoader.slot, positionX, positionY, width, height);
		}
		rpgGame.font.setColor(Color.ORANGE);
		rpgGame.font.draw(batch, text, positionX + 10, positionY + 35);
	}
	public void sRenderFill(ShapeRenderer render){
		/*if(rpgGame.checkHover(positionX, positionY, width, height))
			render.setColor(Color.YELLOW);
		else
			render.setColor(Color.BLACK);
		render.rect(positionX, positionY, width, height);*/
	}
	public void sRenderLine(ShapeRenderer render){
		/*render.setColor(Color.ORANGE);
		render.rect(positionX, positionY, width, height);*/
	}
	public void update(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
