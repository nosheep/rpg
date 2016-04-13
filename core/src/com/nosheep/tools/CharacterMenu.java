package com.nosheep.tools;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

public class CharacterMenu extends Window implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5173733088317200020L;
	public int points = 0;
	public Button[] plus;
	public Button[] right;
	public Button[] left;
	private Player player;
	public byte magicIndex = 0;
	public byte rangeIndex = 0;
	public byte meleeIndex = 0;
	public String[] magicType = new String[3];
	public String[] rangeType = new String[3];
	public String[] meleeType = new String[3];
	
	public CharacterMenu(String text, int positionX, int positionY, int width,
			int height) {
		super(text, positionX, positionY, width, height);
		plus = new Button[4];
		right = new Button[3];
		left = new Button[3];
		plus[0] = new Button("", getPositionX() + 260, getPositionY() + 200, 50, 50, true);
		plus[1] = new Button("", getPositionX() + 260, getPositionY() + 300, 50, 50, true);
		plus[2] = new Button("", getPositionX() + 260, getPositionY() + 400, 50, 50, true);
		plus[3] = new Button("", getPositionX() + 260, getPositionY() + 500, 50, 50, true);
		right[0] = new Button("", getPositionX() + 260, getPositionY() + 200, 50, 50, true);
		right[1] = new Button("", getPositionX() + 260, getPositionY() + 200, 50, 50, true);
		right[2] = new Button("", getPositionX() + 260, getPositionY() + 200, 50, 50, true);
		left[0] = new Button("", getPositionX() + 260, getPositionY() + 200, 50, 50, true);
		left[1] = new Button("", getPositionX() + 260, getPositionY() + 200, 50, 50, true);
		left[2] = new Button("", getPositionX() + 260, getPositionY() + 200, 50, 50, true);
		
		magicType[0] = "Fire";
		magicType[1] = "Water";
		magicType[2] = "Chaos";
		
		rangeType[0] = "Hunter";
		rangeType[1] = "Sniper";
		rangeType[2] = "Scout";
		
		meleeType[0] = "Warrior";
		meleeType[1] = "Knight";
		meleeType[2] = "Mercenary";
	}
	public void setLink(Player player){
		this.player = player;
	}
	private void update(){
		
		if(magicIndex >= 2)
			magicIndex = 2;
		if(magicIndex <= 0)
			magicIndex = 0;
		
		if(rangeIndex >= 2)
			rangeIndex = 2;
		if(rangeIndex <= 0)
			rangeIndex = 0;
		
		if(meleeIndex >= 2)
			meleeIndex = 2;
		if(meleeIndex <= 0)
			meleeIndex = 0;
		/*plus[0].update(getPositionX() + 260, getPositionY() + 200);
		plus[1].update(getPositionX() + 260, getPositionY() + 300);
		plus[2].update(getPositionX() + 260, getPositionY() + 400);
		plus[3].update(getPositionX() + 260, getPositionY() + 500);*/
		
		right[0].update(getPositionX() + 525, getPositionY() + 125);
		right[1].update(getPositionX() + 525, getPositionY() + 325);
		right[2].update(getPositionX() + 525, getPositionY() + 525);
		left[0].update(getPositionX() + 25, getPositionY() + 125);
		left[1].update(getPositionX() + 25, getPositionY() + 325);
		left[2].update(getPositionX() + 25, getPositionY() + 525);
		
		if(isActive()){
			if(right[0].clicked()){
				if(magicIndex < 2)
					magicIndex++;
			}
			if(right[1].clicked()){
				if(rangeIndex < 2)
					rangeIndex++;
			}
			if(right[2].clicked()){
				if(meleeIndex < 2)
					meleeIndex++;
			}
			
			if(left[0].clicked()){
				if(magicIndex > 0)
					magicIndex--;
			}
			if(left[1].clicked()){
				if(rangeIndex > 0)
					rangeIndex--;
			}
			if(left[2].clicked()){
				if(meleeIndex > 0)
					meleeIndex--;
			}
			/*
			if(player.getLevelPoints() > 0){
				if(plus[0].clicked()){
					player.setMagicLevel(player.getMagicLevel()+1);
					player.setLevelPoints(player.getLevelPoints()-1);
				}
				else if(plus[1].clicked()){
					player.setRangedLevel(player.getRangedLevel()+1);
					player.setLevelPoints(player.getLevelPoints()-1);
				}
				else if(plus[2].clicked()){
					player.setMeleeLevel(player.getMeleeLevel()+1);
					player.setLevelPoints(player.getLevelPoints()-1);
				}
				else if(plus[3].clicked()){
					player.setMaxHealth(player.getMaxHealth()+10);
					player.setLevelPoints(player.getLevelPoints()-1);
				}
			}
			*/
		}
	}
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
		if(isActive()){
			/*for(int i=0; i<=3; i++){
				plus[i].render(batch);
				batch.draw(AssetLoader.plus, 
						plus[i].getPositionX(), 
						plus[i].getPositionY(),
						plus[i].getWidth(),
						plus[i].getHeight());
			}*/
			for(int i=0; i<=2; i++){
				right[i].render(batch);
				left[i].render(batch);
			}
			batch.draw(AssetLoader.slot, getPositionX() + 95, getPositionY() + 100, 400, 100);
			if(magicType[magicIndex].equals("Fire")){
				batch.draw(AssetLoader.orange, getPositionX() + 105, getPositionY() + 115, 380, 70);
				batch.draw(AssetLoader.fireBallIcon, getPositionX() + 240, getPositionY() + 110, 100, 80);
			}
			if(magicType[magicIndex].equals("Water")){
				batch.draw(AssetLoader.blue, getPositionX() + 105, getPositionY() + 115, 380, 70);
				batch.draw(AssetLoader.waterSplashTexture, getPositionX() + 240, getPositionY() + 120, 100, 60);
			}
			if(magicType[magicIndex].equals("Chaos")){
				batch.draw(AssetLoader.lightningStrikeTexture, getPositionX() + 105, getPositionY() + 115, 380, 70);
				//batch.draw(AssetLoader.blue, getPositionX() + 105, getPositionY() + 115, 380, 70);
				//batch.draw(AssetLoader.lightningStrikeTexture, getPositionX() + 240, getPositionY() + 120, 100, 60);
			}
				
			batch.draw(AssetLoader.slot, getPositionX() + 95, getPositionY() + 300, 400, 100);
			batch.draw(AssetLoader.slot, getPositionX() + 95, getPositionY() + 500, 400, 100);
			rpgGame.font.setColor(Color.ORANGE);
			
			rpgGame.font.draw(batch, "<", getPositionX() + 40, getPositionY() + 140);
			rpgGame.font.draw(batch, "<", getPositionX() + 40, getPositionY() + 340);
			rpgGame.font.draw(batch, "<", getPositionX() + 40, getPositionY() + 540);
			
			rpgGame.font.draw(batch, ">", getPositionX() + 540, getPositionY() + 140);
			rpgGame.font.draw(batch, ">", getPositionX() + 540, getPositionY() + 340);
			rpgGame.font.draw(batch, ">", getPositionX() + 540, getPositionY() + 540);
			
			rpgGame.font.draw(batch, "Magic: " + magicType[magicIndex], getPositionX() + 95, getPositionY() + 70);
			rpgGame.font.draw(batch, "Range: " + rangeType[rangeIndex], getPositionX() + 95, getPositionY() + 270);
			rpgGame.font.draw(batch, "Melee: " + meleeType[meleeIndex], getPositionX() + 95, getPositionY() + 470);
			
			rpgGame.font.setColor(Color.LIGHT_GRAY);
			rpgGame.font.draw(batch, "Magic Level: " + player.getMagicLevel(), getPositionX() + 25, getPositionY() + 620);
			rpgGame.font.draw(batch, "Ranged Level: " + player.getRangedLevel(), getPositionX() + 25, getPositionY() + 680);
			rpgGame.font.draw(batch, "Melee Level: " + player.getMeleeLevel(), getPositionX() + 25, getPositionY() +740);
			
			rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, "Magic Attack: " + player.getMagicAttack(), getPositionX() + 300, getPositionY() + 620);
			rpgGame.font.draw(batch, "Ranged Attack: " + player.getRangedAttack(), getPositionX() + 300, getPositionY() + 680);
			rpgGame.font.draw(batch, "Melee Attack: " + player.getMeleeAttack(), getPositionX() + 300, getPositionY() +740);
		}
	}
	@Override
	public void sRenderFill(ShapeRenderer render) {
		update();
		super.sRenderFill(render);
		/*if(isActive()){
			for(int i=0; i<=3; i++){
				plus[i].sRenderFill(render);
				render.setColor(Color.ORANGE);
				render.line(plus[i].getPositionX() + 10, plus[i].getPositionY() + plus[i].getHeight() / 2, 
						plus[i].getPositionX() + plus[i].getWidth() - 10, plus[i].getPositionY() + plus[i].getHeight() / 2);
				
				render.line(plus[i].getPositionX() + plus[i].getWidth() / 2, plus[i].getPositionY() + 10, 
						plus[i].getPositionX() + plus[i].getWidth() / 2, plus[i].getPositionY() + plus[i].getHeight() - 10);
			}
		}*/
	}
	@Override
	public void sRenderLine(ShapeRenderer render) {
		super.sRenderLine(render);
		if(isActive()){
			for(int i=0; i<=3; i++)
				plus[i].sRenderLine(render);
		}
	}
}
