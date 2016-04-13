package com.nosheep.tools;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;

public class WorldMap extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6243320489650179323L;
	private String location;
	
	public WorldMap(String text, int positionX, int positionY, int width,
			int height) {
		super(text, positionX, positionY, width, height);
		// TODO Auto-generated constructor stub
	}
	private void update(){
		location = "Location: " + rpgGame.map.get(rpgGame.mapIndex).getArea() + ": " +
			rpgGame.map.get(rpgGame.mapIndex).getName();
	}
	@Override
	public void render(SpriteBatch batch) {
		update();
		super.render(batch);
		if(isActive()){
			rpgGame.font.setColor(Color.PINK);
			rpgGame.font.draw(batch, location, getPositionX() + 450, getPositionY() + 20);
			try{				
				int x = 50,
					y = 90;
				for(int i=0; i<rpgGame.map.size(); i++){
					batch.draw(AssetLoader.slot, getPositionX() + x - 5, getPositionY() + y - 5, 200 + 10, 120 + 10);
					batch.draw(rpgGame.map.get(i).getImage(), getPositionX() + x, getPositionY() + y, 200, 120);
					
					if(i == rpgGame.mapIndex){
						batch.draw(AssetLoader.mapLocation, getPositionX() + x + 64, getPositionY() + y + 20, 64, 64);
					}
					x += 202;
					if(i % 7 == 6 && i != 0) {
						y += 122;
						x = 50;
					}
				}
			}
			catch(Exception ex){}
		}
	}
}
