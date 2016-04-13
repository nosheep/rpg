package com.nosheep.skills;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.enemy.Enemy;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

public abstract class Melee implements Skill, Serializable {

	private static final long serialVersionUID = -1555153433378214803L;

	public enum DIRECTION {
		UP, DOWN, LEFT, RIGHT;
	}
	
	protected DIRECTION direction = DIRECTION.UP;

	private boolean coolDown;
	private int coolDownTimer = 0, coolDownCounter = 0, requiredLevel;
	protected boolean hasHealed = true;
	protected int range;
	public boolean active = true;
	public boolean displayDamage = false;
	protected int damageCounter = 0;
	public int speed = 5;
	protected int positionX, positionY, width, height, damage, hit, randomY, randomX;
	public Enemy e;

	private transient Sprite imageUp, imageDown, imageLeft, imageRight;

	private transient Sprite icon;
	public String name;
	protected int skillDamage;
	protected transient AnimatedSprite hitAnimation, animation;
	private boolean lineAnimation;

	protected int animationWidth, animationHeight;
	protected Player player;
	protected int xOffset, yOffset;

	public Melee(){
		active = false;
		init();
	}
	public Melee(int positionX, int positionY, int width, int height, int damage, Enemy e, Player player) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
		this.damage = damage;
		this.e = e;
		this.player = player;
		xOffset = (int) (Math.random() * 100);
		yOffset = (int) (Math.random() * 100);
		init();
	}

	public void init() {
	}

	@Override
	public void render(SpriteBatch batch) {
		if (active) {
			// May not work properly due to copy from Projectile
			if (animation != null) {
				if (lineAnimation) {
					animation.setPosition(positionX, positionY);
					animation.setSize(animationWidth, animationHeight);
					animation.draw(batch);
				} else {
					animation.setPosition(positionX, positionY);
					animation.setSize(animationWidth, animationHeight);
					animation.draw(batch);
				}
			} else {
				int size = 40;
				if (direction == DIRECTION.UP)
					batch.draw(imageUp, e.getPositionX() + size, e.getPositionY() + size, e.getWidth() - size, e.getHeight() - size);
				if (direction == DIRECTION.DOWN)
					batch.draw(imageDown, e.getPositionX() + size, e.getPositionY() + size, e.getWidth() - size, e.getHeight() - size);
				if (direction == DIRECTION.LEFT)
					batch.draw(imageLeft, e.getPositionX() + size, e.getPositionY() + size, e.getWidth() - size, e.getHeight() - size);
				if (direction == DIRECTION.RIGHT)
					batch.draw(imageRight, e.getPositionX() + size, e.getPositionY() + size, e.getWidth() - size, e.getHeight() - size);
			}
		}

		if (displayDamage) {
			if (hitAnimation != null) {
				hitAnimation.setPosition(positionX, positionY);
				hitAnimation.setSize(animationWidth, animationHeight);
				hitAnimation.draw(batch);
			}
			if (hit <= 0)
				rpgGame.font.setColor(Color.BLUE);
			else
				rpgGame.font.setColor(Color.BLACK);
			// rpgGame.font.draw(batch, Integer.toString(hit),
			// (e.getPositionX() - 100) + randomX, e.getPositionY()
			// + randomY);
			int hitLength = 0;
			if (hit >= 100) {
				hitLength = 55;
			} else if (hit >= 10) {
				hitLength = 45;
			} else {
				hitLength = 35;
			}

			e.showDealtDamage(batch, hit, hitLength, xOffset, yOffset);
			
			/*batch.draw(AssetLoader.red, positionX - 5, positionY - 20, hitLength, 30);
			batch.draw(AssetLoader.blackBorder, positionX - 5, positionY - 20, hitLength, 30);
			rpgGame.font.draw(batch, Integer.toString(hit), positionX, positionY - 15);*/
			damageCounter++;
			if (damageCounter >= 100) {
				damageCounter = 0;
				displayDamage = false;
			}
		}
	}

	@Override
	public void updateCoolDown(){
		if(coolDown){
			coolDownCounter++;
			if(coolDownCounter >= coolDownTimer) {
				coolDownCounter = 0;
				coolDown = false;
			}
		}
	}
	
	@Override
	public void update() {
		
		if(coolDownCounter >= coolDownTimer) {
			coolDown = false;
			coolDownCounter = 0;
		}
		else{
			coolDown = true;
			coolDownCounter++;
		}
		
		if (active) {
			if (e.isAlive()) {
				if (positionX >= (e.getPositionX() + (e.getWidth() / 2) - width / 2)) {
					direction = DIRECTION.LEFT;
					positionX -= speed;
				} else if (positionX <= (e.getPositionX() + (e.getWidth() / 2) - width / 2)) {
					direction = DIRECTION.RIGHT;
					positionX += speed;
				}

				if (positionY >= (e.getPositionY() + (e.getHeight() / 2) - height / 2)) {
					direction = DIRECTION.UP;
					positionY -= speed;
				} else if (positionY <= (e.getPositionY() + (e.getHeight() / 2) - height / 2)) {
					direction = DIRECTION.DOWN;
					positionY += speed;
				}

				// if (positionX == (e.getPositionX() + (e.getWidth() / 2) -
				// width / 2)
				// && positionY == (e.getPositionY() + (e.getHeight() / 2) -
				// height / 2)) {
				if (positionX >= e.getPositionX() + 10 && positionX <= (e.getPositionX() + 10 + e.getWidth() - 10)
						&& positionY >= e.getPositionY() - 10
						&& positionY <= (e.getPositionY() - 10 + e.getHeight() + 10)) {
					randomX = (int) (Math.random() * e.getWidth());
					randomY = (int) (Math.random() * e.getHeight());
					hit = (int) (Math.random() * damage + skillDamage);
					e.setCurrentHealth(e.getCurrentHealth() - hit);
					displayDamage = true;
					hasHealed = false;
					active = false;
				}
			} else {
				active = false;
			}
		}
	}
	
	public void setRange(int range){
		this.range = range;
	}

	protected int getSpeed() {
		return speed;
	}

	protected String getName() {
		return name;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
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
	public void setActive(boolean active){
		this.active = active;
		displayDamage = false;
	}
	
	@Override
	public boolean getActive() {
		// TODO Auto-generated method stub
		return active;
	}

	@Override
	public boolean getDisplayDamage() {
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

	public Sprite getImageUp() {
		return imageUp;
	}

	public Sprite getImageDown() {
		return imageDown;
	}

	public Sprite getImageLeft() {
		return imageLeft;
	}

	public Sprite getImageRight() {
		return imageRight;
	}

	public void setImageUp(Sprite imageUp) {
		this.imageUp = imageUp;
	}

	public void setImageDown(Sprite imageDown) {
		this.imageDown = imageDown;
	}

	public void setImageLeft(Sprite imageLeft) {
		this.imageLeft = imageLeft;
	}

	public void setImageRight(Sprite imageRight) {
		this.imageRight = imageRight;
	}

	public void setAllImage(Sprite image) {
		this.imageUp = image;
		this.imageDown = image;
		this.imageLeft = image;
		this.imageRight = image;
	}

	public AnimatedSprite getAnimation() {
		return animation;
	}

	public void setAnimation(AnimatedSprite animation) {
		this.animation = animation;
	}

	public boolean isLineAnimation() {
		return lineAnimation;
	}

	public void setLineAnimation(boolean lineAnimation) {
		this.lineAnimation = lineAnimation;
	}
	public int getRange() {
		return range;
	}

	public void setIcon(Sprite icon) {
		this.icon = icon;
	}
	@Override
	public Sprite getIcon() {
		return icon;
	}
	@Override
	public boolean isCoolDown() {
		return coolDown;
	}

	@Override
	public int getRequiredLevel() {
		return requiredLevel;
	}

	public void setCoolDownTimer(int coolDownTimer) {
		this.coolDownTimer = coolDownTimer;
	}

	public void setReuiredLevel(int requiredLevel) {
		this.requiredLevel = requiredLevel;
	}
	public int getCoolDownTimer() {
		return coolDownTimer;
	}
	@Override
	public void setCoolDown(boolean coolDown) {
		this.coolDown = coolDown;
	}

}
