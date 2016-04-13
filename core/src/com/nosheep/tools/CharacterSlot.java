package com.nosheep.tools;

import java.io.Serializable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.main.rpgGame;

public class CharacterSlot implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2729207355584879951L;
	private int positionX, positionY, width, height;
	
	public CharacterSlot(int positionX, int positionY, int width, int height){
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
	}

	public boolean clicked(){
		if(rpgGame.checkHover(positionX, positionY, width, height) && Gdx.input.justTouched()){
			return true;
		}
		else
			return false;
	}
	
	public void sRenderFill(ShapeRenderer render){
		if(rpgGame.checkHover(positionX, positionY, width, height))
			render.setColor(Color.YELLOW);
		else
			render.setColor(Color.BLACK);
		render.rect(positionX, positionY, width, height);
			
	}
	public void sRenderLine(ShapeRenderer render){
		render.setColor(Color.ORANGE);
		render.rect(positionX, positionY, width, height);
	}
	
}
