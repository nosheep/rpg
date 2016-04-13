package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class Coins extends Currency{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8907032097492773149L;

	public Coins(int positionX, int positionY, int amount) {
		super(positionX, positionY, amount);
		name = "Coins";
		image = AssetLoader.coins;
	}
	
	@Override
	public void update() {
		if(image == null){
			image = AssetLoader.coins;
		}
		super.update();
	}
	
}
