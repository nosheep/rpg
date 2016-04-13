package com.nosheep.skills;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.player.Player;

/**
 * Created by Johan on 2015-11-16.
 */
public class LightningStrike extends Projectile{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7822748451988524963L;

	public LightningStrike(){
		super();
		setRange(300);
		setIcon(AssetLoader.lightningStrikeTexture);
	}
	public LightningStrike(int positionX, int positionY, int width, int height,
                           int damage, Enemy e, Player player){
        super(positionX, positionY, width, height, damage, e, player);


    }

    @Override
    public void init() {
        setLineAnimation(true);
        setAnimation(AssetLoader.lightningStrike);
        setName("LightningStrike");
        setSpeed(5);
        setDamage(1);
        setAnimationWidth(20);
        setAnimationHeight(20);
        setRange(300);
        super.init();
    }

    @Override
    public void update() {
        if(player.getSkillDirection() == Player.DIRECTION.UP ||
                player.getSkillDirection() == Player.DIRECTION.DOWN){
            animationWidth = 20;
            animationHeight = 132;
            animation.setFlip(false, false);
        }
        else{
            animationWidth = 132;
            animationHeight = 20;
            animation.setFlip(false, true);
        }
        /*if(displayDamage){
            for(Enemy e2: rpgGame.map.get(rpgGame.mapIndex).enemies){
                if (e.getPositionX() + e.getWidth() + 400 >= e2.getPositionX()
                        && e.getPositionX() - 400 <= (e2.getPositionX() + e2
                        .getWidth())
                        && e.getPositionY() + e.getHeight() + 400 >= e2.getPositionY()
                        && e.getPositionY() - 400 <= (e2.getPositionY() + e2
                        .getHeight())){
                    new LightningStrike(e.getPositionX(), e.getPositionY(), 25, 25, damage, e2, player);
                }
            }
        }*/
        super.update();
    }
}
