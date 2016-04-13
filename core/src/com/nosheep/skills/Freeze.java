package com.nosheep.skills;

import java.util.List;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.player.Player;

public class Freeze extends AoE{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7526791944987731442L;

	public Freeze(){
		super();
		setIcon(AssetLoader.aoeFreeze);
		setCoolDownTimer(500);
		setReuiredLevel(5);
	}
	public Freeze(List<Enemy> enemies, Player player) {
		super(enemies, player);
	}
	@Override
	public void init() {
		setImage(AssetLoader.aoeFreeze);
		setName("Freeze");
		super.init();
	}
	
	@Override
	protected void attack() {
		if(active){
			for(Enemy e : enemies){
				if(e.getPositionX() + e.getWidth() >= positionX-width/2 &&
					e.getPositionX() <= (positionX-width/2 + width) &&
						e.getPositionY() + e.getHeight() >= positionY-height/2 &&
						e.getPositionY() <= (positionY-height/2 + height)){
					e.setFrozen(true);
				}
			}
			active = false;
		}
		super.attack();
	}

}
