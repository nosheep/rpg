package com.nosheep.enemy;

import java.io.Serializable;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.nosheep.assets.AssetLoader;
import com.nosheep.enemySkills.EnemyPunch;
import com.nosheep.enemySkills.EnemySkill;
import com.nosheep.items.Coins;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;
import com.nosheep.tools.Window;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

public abstract class Enemy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293674848240986563L;

	public enum STAGE{
		first, second;
	}
	protected boolean BOSS = false;
	protected int timer = 0;
	protected int moveTimer = 0;
	protected int rand = 0;
	protected int respawnTime;
	protected int attackSpeed;
	private int attackCounter = 0;
	protected int coins = 0;
	
	protected boolean alive, target, combat;
	protected transient AnimatedSprite walkAnimation;
	protected transient AnimatedSprite walkAnimation2;
	protected transient AnimatedSprite attackAnimation;
	protected int attackAnimationCounter = 0;
	protected boolean attacking = false;
	protected String name;
	protected int positionX, positionY, width, height;
	protected int level, currentHealth, maxHealth, health,
				  speed, combatSpeed, damage, coolDown = 0;
	protected Vector3 screen;
	protected int xp;
	protected boolean givenExp = false, hasAttacked = false;
	
	protected ArrayList<EnemySkill> skills = new ArrayList<EnemySkill>();
	protected ArrayList<EnemySkill> skillRemove = new ArrayList<EnemySkill>();
	
	protected enum Direction{
		LEFT, RIGHT, UP, DOWN;
	}
	protected Direction direction;
	
	// DEBUFFS //
		private boolean frozen;
	// DEBUFFS END //
	
	protected int respawnCounter = 0;
	private boolean haveDroppedLoot = false;
	private Player player;
	
	public Enemy(int level){
		screen = new Vector3(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
		positionX = (int) (Math.random() * screen.x);
		positionY = (int) (Math.random() * screen.y);
		this.level = level;
		init();
	}
	public Enemy(int positionX, int positionY, int level){
		screen = new Vector3(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
		this.positionX = positionX;
		this.positionY = positionY;
		this.level = level;
		init();
	}
	public void init(){
		positionX = (int) (Math.random() * screen.x);
		positionY = (int) (Math.random() * screen.y);
		direction = Direction.UP;
		speed = 5;
		combatSpeed = 2;
		damage = 10 + level;
		alive = true;
		target = false;
		combat = false;
		frozen = false;
		maxHealth = 50 * level;
		currentHealth = maxHealth;
		xp = level * 2;
		respawnTime = 500;
		if(coins == 0)
			coins = level * 10;
	}
	protected void move(int rand){
		if(!combat){
			if(rand == 1){
				direction = Direction.LEFT;
				positionX -= speed;
			}
			if(rand == 2){
				direction = Direction.UP;
				positionY -= speed;
			}
			if(rand == 3){
				direction = Direction.RIGHT;
				positionX += speed;
			}
			if(rand == 4){
				direction = Direction.DOWN;
				positionY += speed;
			}
			else{
				// Idle
			}
		}
		else{
			combatMove();
		}
		moveTimer++;
	}
	private void combatMove(){
			
			if(positionX + width/2 >= player.getPositionX()){
				direction = Direction.LEFT;
				positionX -= combatSpeed;
			}
			
			if(positionX <= player.getPositionX()){
				direction = Direction.RIGHT;
				positionX += combatSpeed;
			}
			
			if(positionY + height/2 >= player.getPositionY()){
				direction = Direction.UP;
				positionY -= combatSpeed;
			}
			
			if(positionY <= player.getPositionY()){
				direction = Direction.DOWN;
				positionY += combatSpeed;
			}
	}
	public boolean checkTargeted(){
		boolean onWindow = false;
		for(Window w : rpgGame.windows){
			if(w.isActive() && rpgGame.checkHover(w.getPositionX(), w.getPositionY(), w.getWidth(), w.getHeight())){
				onWindow = true;
				break;
			}
		}
		if(Gdx.input.justTouched() && rpgGame.checkHover(positionX, positionY, width, height) && alive && !onWindow){
			return true;
		}
		else
			return false;
	}
	protected void respawn(){
		respawnCounter++;
		
		if(respawnCounter >= respawnTime){
			target = false;
			positionX = (int) (Math.random() * screen.x);
			positionY = (int) (Math.random() * screen.y);	
			alive = true;
			currentHealth = maxHealth;
			respawnCounter = 0;
			haveDroppedLoot = false;
			givenExp = false;
			frozen = false;
			timer = 0;
		}
	}
	
	public void showDealtDamage(SpriteBatch batch, int damage, int hitLength, int xOffset, int yOffset){		
		batch.draw(AssetLoader.bloodstain, positionX + xOffset - 10, positionY + yOffset - 20, 70, 40);
		//batch.draw(AssetLoader.blackBorder, positionX - 5, positionY - 20, hitLength, 30);
		rpgGame.font.setColor(Color.BLACK);
		rpgGame.font.draw(batch, Integer.toString(damage), positionX + xOffset, positionY + yOffset - 15);
	}
	
	protected void loot(){
		int c = (int) (Math.random() * 2);
		if(c == 1){
			int amount = (int) (Math.random() * coins);
			if(amount == 0)
				amount = 1;
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new Coins(positionX - 100, positionY, amount));
		}
	}
	protected void update(){
		
		for (EnemySkill s : skills) {
			if (!s.getActive() && !s.getDisplayDamage())
				skillRemove.add(s);
		}
		skills.removeAll(skillRemove);
		skillRemove.clear();
		
		if(player.isDead()){
			currentHealth = maxHealth;
			combat = false;
		}
	
		if(attackAnimationCounter >= 100){
			attacking = false;
			attackAnimationCounter = 0;
		}
		
		// TEMP //
			if(currentHealth < maxHealth)
				combat = true;
			else
				combat = false;
		// TEMP END //
			
		screen.x = Gdx.graphics.getWidth();
		screen.y = Gdx.graphics.getHeight();
		rpgGame.cam.unproject(screen);
		
		if(!alive){
			skills.clear();
			skillRemove.clear();
			if(!givenExp && combat){
				player.setCurrentExperience(player.getCurrentExperience() + xp);
				givenExp = true;
			}
			combat = false;
			respawn();
		}
		
		if(currentHealth <= 0){
			alive = false;
			if(!haveDroppedLoot)
			loot();
			haveDroppedLoot = true;
		}
		
		if(hasAttacked)
			coolDown++;
		
		if(coolDown >= 300){
			hasAttacked = false;
			coolDown = 0;
		}
		
		if(positionX <= 0)
			positionX = 0;
		if(positionX + width >= screen.x)
			positionX = (int) (screen.x - width);
		if(positionY <= 0)
			positionY = 0;
		if(positionY + height >= screen.y - 122)
			positionY = (int) (screen.y - 122 - height);
		if(alive){
			
			if(positionX + width >= player.getPositionX() &&
					positionX <= (player.getPositionX() + player.getWidth()) &&
					positionY + height >= player.getPositionY() &&
					positionY <= (player.getPositionY() + player.getHeight())){
					if(combat && !frozen){
						attackAnimationCounter = 0;
						attacking = true;
						attack();
					}
			}
			if(!frozen){
				if(moveTimer >= 10){
					rand = (int) (Math.random() * 50);
					moveTimer = 0;
				}
				move(rand);
			}
		}
	}
	protected void attack(){
		attackCounter++;
		if(attackCounter >= attackSpeed){
			skills.add(new EnemyPunch(positionX + width / 2, positionY, 64, 64, getDamage(), player));
			attackCounter = 0;
		}

	}
	private void freezeCounter(){
		timer ++;
		if(timer >= 200){
			frozen = false;
			timer = 0;
		}
	}
	public void render(SpriteBatch batch) {
		if(alive){
			for (EnemySkill s : skills) {
				s.update();
				s.render(batch);
			}
			try{
				if(target)
					batch.draw(AssetLoader.target, positionX - 10, positionY + height - 30, width + 20, 40);
				
				if(attacking){
					attackAnimationCounter++;
					attackAnimation.setPosition(positionX, positionY);
					attackAnimation.setSize(width, height);
					attackAnimation.draw(batch);
				}
				else{
					if(direction == Direction.DOWN){
						walkAnimation.setPosition(positionX, positionY);
						walkAnimation.setSize(width, height);
						walkAnimation.draw(batch);
					}
					else{
						walkAnimation2.setPosition(positionX, positionY);
						walkAnimation2.setSize(width, height);
						walkAnimation2.draw(batch);
					}
				}
				if(frozen){
					walkAnimation.setPlaying(false);
					walkAnimation2.setPlaying(false);
					attackAnimation.setPlaying(false);
					batch.draw(AssetLoader.freezeIcon, positionX, positionY, width, height);
					freezeCounter();
				}
				else{
					walkAnimation.setPlaying(true);
					walkAnimation2.setPlaying(true);
					attackAnimation.setPlaying(true);
				}
				if(name != null){
					if(BOSS) {
						batch.draw(AssetLoader.ui, positionX - 30, positionY - 55, 300, 35);
						batch.draw(AssetLoader.blackBorder, positionX - 30, positionY - 55, 300, 35);
					}
					else {
						batch.draw(AssetLoader.ui, positionX - width / 2 + 10, positionY - 55, 150 + name.length() * 10, 35);
						batch.draw(AssetLoader.blackBorder, positionX - width / 2 + 10, positionY - 55, 150 + name.length() * 10, 35);
					}
					
					if(combat)
						rpgGame.font.setColor(Color.RED);
					else
						rpgGame.font.setColor(Color.ORANGE);
					
					if(BOSS){
						rpgGame.font.setColor(Color.PINK);
						if(level == -1)
							rpgGame.font.draw(batch, name + ": " + "??", positionX + 25, positionY - 50, 40, 40, false);
						else
							rpgGame.font.draw(batch, name + ": " + level, positionX + 25, positionY - 50, 40, 40, false);
					}
					else
						rpgGame.font.draw(batch, name + ": " + level, positionX - width / 2 + 20, positionY - 50, 40, 40, false);
					
				}
				if(combat){
					batch.draw(AssetLoader.combat, positionX + width / 2 - 20, positionY - 100, 40, 40);
					rpgGame.font.setColor(Color.BLACK);
				}
				
				health = (int) ((currentHealth * 100.0f) / maxHealth);
				if(BOSS){
					batch.draw(AssetLoader.black, positionX + 20, positionY - 20, 200, 15);
					batch.draw(AssetLoader.pink, positionX + 20, positionY - 20, health * 2, 15);
					batch.draw(AssetLoader.blackBorder, positionX + 20, positionY - 20, 200, 15);
				}
				else{
					batch.draw(AssetLoader.black, positionX + width / 6, positionY - 20, 100, 15);
					if(health >= 75)
						batch.draw(AssetLoader.green, positionX + width / 6, positionY - 20, health, 15);
					else if(health >= 50)
						batch.draw(AssetLoader.yellow, positionX + width / 6, positionY - 20, health, 15);
					else if(health >= 25)
						batch.draw(AssetLoader.orange, positionX + width / 6 , positionY - 20, health, 15);
					else if(health >= 0)
						batch.draw(AssetLoader.red, positionX + width / 6, positionY - 20, health, 15);
					
					batch.draw(AssetLoader.blackBorder, positionX + width / 6, positionY - 20, 100, 15);
				}
			}
			catch(NullPointerException ex){}
		}
	}
	public void renderTarget(SpriteBatch batch){
		if(target){
			batch.draw(AssetLoader.bloodstain, screen.x - 460, screen.y - 132, 460, 100);
			if(BOSS)
				rpgGame.font.setColor(Color.PINK);
			else
				rpgGame.font.setColor(Color.ORANGE);
				
			rpgGame.font.draw(batch, name, screen.x - 420, screen.y - 110);
			rpgGame.font.setColor(Color.BLACK);
			if(level == -1)
				rpgGame.font.draw(batch, "Level: " + "??", screen.x - 420, screen.y - 70);
			else
				rpgGame.font.draw(batch, "Level: " + level, screen.x - 420, screen.y - 70);
			
			if(health >= 75)
				rpgGame.font.setColor(Color.GREEN);
			else if(health >= 50)
				rpgGame.font.setColor(Color.YELLOW);
			else if(health >= 25)
				rpgGame.font.setColor(Color.ORANGE);
			else if(health >= 0)
				rpgGame.font.setColor(Color.RED);
			
			rpgGame.font.draw(batch, "Health:", screen.x - 270, screen.y - 110);
			rpgGame.font.draw(batch, currentHealth + " / " + maxHealth, screen.x - 270, screen.y - 70);
			//batch.draw(AssetLoader.blackBorder, screen.x - 460, screen.y - 132, 460, 100);
		}
	}
	public void sRenderFill(ShapeRenderer render){
		update();
		if(alive){
			
		}
	}
	public void sRenderLine(ShapeRenderer render){
		if(alive){
			
		}
	}
	public String getName() {
		return name;
	}
	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isTarget() {
		return target;
	}
	public void setTarget(boolean target) {
		this.target = target;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public boolean isCombat() {
		return combat;
	}
	public void setCombat(boolean combat) {
		this.combat = combat;
		currentHealth = maxHealth;
	}
	public boolean isFrozen() {
		return frozen;
	}
	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public AnimatedSprite getWalkAnimation() {
		return walkAnimation;
	}
	public AnimatedSprite getAttackAnimation() {
		return attackAnimation;
	}
	public void setWalkAnimation(AnimatedSprite walkAnimation) {
		this.walkAnimation = walkAnimation;
	}
	public void setAttackAnimation(AnimatedSprite attackAnimation) {
		this.attackAnimation = attackAnimation;
	}
	public int getSpeed() {
		return speed;
	}
	public int getCombatSpeed() {
		return combatSpeed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setCombatSpeed(int combatSpeed) {
		this.combatSpeed = combatSpeed;
	}
	public int getRespawnTime() {
		return respawnTime;
	}
	public void setRespawnTime(int respawnTime) {
		this.respawnTime = respawnTime;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public int getDamage() {
		return damage;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public boolean isBOSS() {
		return BOSS;
	}
	public void setBOSS(boolean bOSS) {
		BOSS = bOSS;
	}
	public AnimatedSprite getWalkAnimation2() {
		return walkAnimation2;
	}
	public void setWalkAnimation2(AnimatedSprite walkAnimation2) {
		this.walkAnimation2 = walkAnimation2;
	}
	public int getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
}
