package com.nosheep.enemySkills;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

public abstract class EnemyProjectile implements EnemySkill, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5822168564494017917L;
	
	public boolean active = true;
	public boolean displayDamage = false;
	private int damageCounter = 0;
	public int speed = 5;
	protected int positionX, positionY, width, height, damage, hit, randomY,
			randomX;
	private Player p;
	private transient Sprite image;
	public String name;
	protected int skillDamage;
	protected transient AnimatedSprite hitAnimation;
	protected int animationWidth, animationHeight;
	
	public EnemyProjectile(int positionX, int positionY, int width, int height,
			int damage, Player p){
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
		this.damage = damage;
		this.p = p;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		if(active){
			batch.draw(image, positionX, positionY, width, height);
		}
		
		if (displayDamage) {
			if(hitAnimation != null){
				hitAnimation.setPosition(positionX, positionY);
				hitAnimation.setSize(animationWidth, animationHeight);
				hitAnimation.draw(batch);
			}
			if (hit <= 0)
				rpgGame.font.setColor(Color.BLUE);
			else
				rpgGame.font.setColor(Color.BLACK);
				//rpgGame.font.draw(batch, Integer.toString(hit),
					//(e.getPositionX() - 100) + randomX, e.getPositionY()
						//	+ randomY);
				int hitLength = 0;
				if(hit >= 100){
					hitLength = 55;
				}	
				else if(hit >= 10){
					hitLength = 45;
				}
				else{
					hitLength = 35;
				}
				
				batch.draw(AssetLoader.orange, positionX - 5, positionY - 20, hitLength, 30);
				batch.draw(AssetLoader.blackBorder, positionX - 5, positionY - 20, hitLength, 30);
				rpgGame.font.draw(batch, Integer.toString(hit),
						positionX, positionY - 15);
			damageCounter++;
			if (damageCounter >= 100) {
				damageCounter = 0;
				displayDamage = false;
			}
		}
	}

	@Override
	public void update() {
		if (active) {
			if (!p.isDead()) {
				if (positionX >= (p.getPositionX() + (p.getWidth() / 2) - width / 2))
					positionX -= speed;
				else if (positionX <= (p.getPositionX() + (p.getWidth() / 2) - width / 2))
					positionX += speed;

				if (positionY >= (p.getPositionY() + (p.getHeight() / 2) - height / 2))
					positionY -= speed;
				else if (positionY <= (p.getPositionY() + (p.getHeight() / 2) - height / 2))
					positionY += speed;

				if(positionX >= p.getPositionX()+10 &&
						positionX <= (p.getPositionX()+10 + p.getWidth()-10) &&
						positionY >= p.getPositionY()-10 &&
						positionY <= (p.getPositionY()-10 + p.getHeight()+10)){
					randomX = (int) (Math.random() * p.getWidth());
					randomY = (int) (Math.random() * p.getHeight());
					hit = (int) (Math.random() * damage+skillDamage);
					p.setCurrentHealth(p.getCurrentHealth() - hit);
					displayDamage = true;
					active = false;
				}
			} else {
				active = false;
			}
		}
	}

	protected int getSpeed() {
		return speed;
	}

	protected Sprite getImage() {
		return image;
	}

	protected String getName() {
		return name;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
	}

	protected void setImage(Sprite image) {
		this.image = image;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected int getDamage() {
		return skillDamage;
	}

	protected void setDamage(int skillDamage) {
		this.skillDamage = skillDamage;
	}

	@Override
	public boolean getActive() {
		// TODO Auto-generated method stub
		return active;
	}
	@Override
	public boolean getDisplayDamage(){
		return displayDamage;
	}

	public AnimatedSprite getHitAnimation() {
		return hitAnimation;
	}

	public void setHitAnimation(AnimatedSprite hitAnimation) {
		this.hitAnimation = hitAnimation;
	}

	public int getAnimationWidth() {
		return animationWidth;
	}

	public int getAnimationHeight() {
		return animationHeight;
	}

	public void setAnimationWidth(int animationWidth) {
		this.animationWidth = animationWidth;
	}

	public void setAnimationHeight(int animationHeight) {
		this.animationHeight = animationHeight;
	}
	
}
