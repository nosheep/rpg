package com.nosheep.items;

import com.nosheep.assets.AssetLoader;


public class LavaCape extends Backpiece{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8626695090067334019L;

	public LavaCape(int positionX, int positionY) {
		super(positionX, positionY);
		// TODO Auto-generated constructor stub
	}

	public LavaCape() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() {
		setName("Lava Cape");
		setCapeImage(AssetLoader.lavaCapeImage);
		setCapeAnimation(AssetLoader.lavaCape);
		setRangedDamage(10);
		setMagicDamage(10);
		setMeleeDamage(10);
		super.init();
	}

}
