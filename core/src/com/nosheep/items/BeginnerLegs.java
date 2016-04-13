package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class BeginnerLegs extends Leg{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9137116664047571716L;

	public BeginnerLegs(){
		super();
	}
	
	public BeginnerLegs(int positionX, int positionY) {
		super(positionX, positionY);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() {
		setName("Beginner Legs");
		setIdleBack(AssetLoader.beginnerLegsIdleBack);
		setIdleFront(AssetLoader.beginnerLegsIdleFront);
		setRangedDamage(1);
		setMagicDamage(1);
		setMeleeDamage(1);
		setBackWalk(AssetLoader.beginnerLegsWalkBack);
		setFrontWalk(AssetLoader.beginnerLegsWalkFront);
		super.init();
	}

}
