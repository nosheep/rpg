package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class BeginnerStaff extends Weapon{

	/**
	 * 
	 */
	private static final long serialVersionUID = -295883216177057604L;
	public BeginnerStaff(){
		super();
	}
	public BeginnerStaff(int positionX, int positionY){
		super(positionX, positionY);
	}
	public void init(){
		setType(Type.STAFF);
		setName("Beginner Staff");
		setBack(AssetLoader.beginnerStaffBack);
		setFront(AssetLoader.beginnerStaffFront);
		magicDamage = 10;
		rangedDamage = 0;
		meleeDamage = 0;
		setOnBackImages(AssetLoader.nonCombatBeginnerStaffFront, AssetLoader.nonCombatBeginnerStaffBack);
	}
	
}
