package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class BeginnerBody extends Body{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4346456650355602725L;
	public BeginnerBody(){
		super();
	}
	public BeginnerBody(int positionX, int positionY) {
		super(positionX, positionY);
	}
	@Override
	public void init() {
		setName("Beginner Body");
		setBodyBack(AssetLoader.beginnerBodyBack);
		setBodyFront(AssetLoader.beginnerBodyFront);
		setRangedDamage(2);
		setMagicDamage(2);
		setMeleeDamage(2);
		super.init();
	}

}
