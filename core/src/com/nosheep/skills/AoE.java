package com.nosheep.skills;

import java.io.Serializable;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.enemy.Enemy;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

public abstract class AoE implements Skill, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4924021605977251367L;
	
	private boolean coolDown;
	private int coolDownTimer = 0, coolDownCounter = 0, requiredLevel;
	protected int range;
	protected Player.DIRECTION direction;
	protected boolean attacking = false;
	protected boolean active;
	protected transient Sprite image;
	private transient Sprite icon;
	protected int magicAttack, damage;
	protected List<Enemy> enemies;
	protected String name;
	protected int positionX, positionY, width, height;
	protected int skillButton;
	protected Player player;
	protected boolean onGround = false;
	protected int groundCounter = 0;
	protected int damageCounter = 0;
	protected int xOffset, yOffset;
	
	public AoE(){
		active = false;
	}
	
	public AoE(List<Enemy> enemies, Player player){
		this.enemies = enemies;
		this.player = player;
		init();
	}
	public AoE(int magicAttack, List<Enemy> enemies, Player player){
		this.magicAttack = magicAttack;
		this.enemies = enemies;
		this.player = player;
		xOffset = (int) (Math.random() * 100);
		yOffset = (int) (Math.random() * 100);
		init();
	}
	public void init(){
		active = true;
		width = 200;
		height = 200;
	}
	public void render(SpriteBatch batch){
		if(image != null && active)
			batch.draw(image, positionX - width / 2, positionY - width / 2, width, height);
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
	
	public void update(){
		positionX = rpgGame.getMouseX();
		positionY = rpgGame.getMouseY();
	
		if(coolDownCounter >= coolDownTimer) {
			coolDown = false;
			coolDownCounter = 0;
		}
		else{
			coolDown = true;
			coolDownCounter++;
		}
		
		if(active && Gdx.input.justTouched()){
			attack();
		}
	}
	protected void attack(){
		
	}
	public void setRange(int range){
		this.range = range;
	}
	public boolean isActive() {
		return active;
	}
	@Override
	public void setActive(boolean active) {
		this.active = active;
	}
	public Sprite getImage() {
		return image;
	}
	public String getName() {
		return name;
	}
	public void setImage(Sprite image) {
		this.image = image;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean getActive() {
		// TODO Auto-generated method stub
		return active;
	}
	@Override
	public boolean getDisplayDamage(){
		return false;
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
