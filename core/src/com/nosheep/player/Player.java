package com.nosheep.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.items.Backpiece;
import com.nosheep.items.Body;
import com.nosheep.items.Helmet;
import com.nosheep.items.Leg;
import com.nosheep.items.Weapon;
import com.nosheep.main.rpgGame;
import com.nosheep.map.Map;
import com.nosheep.skills.AoE;
import com.nosheep.skills.Arrow;
import com.nosheep.skills.Cleave;
import com.nosheep.skills.FireBall;
import com.nosheep.skills.Freeze;
import com.nosheep.skills.LavaCarpet;
import com.nosheep.skills.LightningStrike;
import com.nosheep.skills.Punch;
import com.nosheep.skills.Skill;
import com.nosheep.skills.WaterSplash;
import com.nosheep.tools.Button;
import com.nosheep.tools.CharacterMenu;
import com.nosheep.tools.Inventory;
import com.nosheep.tools.InventorySlot;
import com.nosheep.tools.WorldMap;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3827886332813274624L;

	public enum DIRECTION {
		UP, DOWN, LEFT, RIGHT;
	}

	private DIRECTION direction, skillDirection;
	public String location, area;

	private boolean moving;
	public boolean outOfRange = false;
	private int outOfRangeCounter = 0;

	public boolean autoAttacking;
	private int autoAttackCounter = 0;
	private int bowAttackTime, staffAttackTime, swordAttackTime, attackTime;
	private boolean dead;
	private Button respawn;
	private String name;
	private int positionX, positionY, width, height;
	private int speed = 3;
	private Vector3 screen;
	private boolean combat = false;

	// WINDOWS //
	public Inventory bag;
	public CharacterMenu characterMenu;
	public WorldMap map;
	// WINDOWS END //

	// SKILLS //
	public ArrayList<Skill> activeSkills = new ArrayList<Skill>();
	public ArrayList<Skill> skillRemove = new ArrayList<Skill>();
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	public ArrayList<Skill> fireMagic = new ArrayList<Skill>();
	public ArrayList<Skill> waterMagic = new ArrayList<Skill>();
	public ArrayList<Skill> chaosMagic = new ArrayList<Skill>();
	public ArrayList<Skill> hunterRanged = new ArrayList<Skill>();
	public ArrayList<Skill> sniperRanged = new ArrayList<Skill>();
	public ArrayList<Skill> scoutRanged = new ArrayList<Skill>();
	public ArrayList<Skill> warriorMelee = new ArrayList<Skill>();
	public ArrayList<Skill> knightMelee = new ArrayList<Skill>();
	public ArrayList<Skill> mercenaryMelee = new ArrayList<Skill>();
	public ArrayList<Skill> unArmed = new ArrayList<Skill>();
	// SKILLS END //
	public boolean hasTarget = false;
	private boolean enduranceEmpty = false;
	
	// STATS //
	private int levelPoints = 0;
	private int level, currentExperience, maxExperience, currentHealth, maxHealth, defenceLevel, magicLevel,
			rangedLevel, meleeLevel;
	private int defence, meleeAttack, rangedAttack, magicAttack, meleeDefence, rangedDefence, magicDefence, endurance,
			maxEndurance;
			// STATS END //

	// EQUIP //
	private Weapon mainHand;

	private Leg legs;
	int legMeleeDamage = 0;
	int legRangeDamage = 0;
	int legMagicDamage = 0;
	
	private Helmet helmet;
	int helmetMeleeDamage = 0;
	int helmetRangeDamage = 0;
	int helmetMagicDamage = 0;

	private Body body;
	int bodyMeleeDamage = 0;
	int bodyRangedDamage = 0;
	int bodyMagicDamage = 0;

	private Backpiece backpiece;
	int backpieceMeleeDamage = 0;
	int backpieceRangedDamage = 0;
	int backpieceMagicDamage = 0;

	private transient AnimatedSprite emptyWalkFront;
	private transient AnimatedSprite emptyWalkBack;
	// EQUIP END //

	// LOCATION //
		public List<Map> zone;
		public byte mapIndex = -1;
	// LOCATION END //
	
	// CURRENCY //
		private int coins = 0;
	// CURRENCY END //
	
	public Player(String name, int positionX, int positionY, int width, int height, int level) {
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
		this.level = level;

		maxExperience = 50;
		currentExperience = 0;
		maxHealth = 100;
		currentHealth = maxHealth;
		defenceLevel = 1;
		magicLevel = 1;
		rangedLevel = 1;
		meleeLevel = 1;
		maxEndurance = 1000;
		endurance = maxEndurance;

		autoAttacking = false;
		bowAttackTime = 10;
		staffAttackTime = 20;
		swordAttackTime = 40;
		attackTime = 0;

		moving = false;
		direction = DIRECTION.DOWN;
		skillDirection = DIRECTION.DOWN;

		emptyWalkFront = AssetLoader.beginnerLegsWalkFront;
		emptyWalkBack = AssetLoader.beginnerLegsWalkBack;

		screen = new Vector3(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
		bag = new Inventory("Inventory(I)", 1400, 200, 370, 800, this);
		characterMenu = new CharacterMenu("Character(C)", 0, 170, 600, 800);
		characterMenu.setLink(this);
		map = new WorldMap("Map(M)", 200, 200, 1500, 1000);
		dead = false;
		respawn = new Button("          Respawn", 700, 600, 500, 100, false);
	}

	public void initAssets() {
		bag.setLink(this);
		emptyWalkFront = AssetLoader.beginnerLegsWalkFront;
		emptyWalkBack = AssetLoader.beginnerLegsWalkBack;
		initSkills();
	}
	private void initSkills(){
		fireMagic.clear();
		waterMagic.clear();
		chaosMagic.clear();
		hunterRanged.clear();
		sniperRanged.clear();
		scoutRanged.clear();
		warriorMelee.clear();
		knightMelee.clear();
		mercenaryMelee.clear();
		// Needed re-init for some weird reason //
		unArmed = new ArrayList<Skill>();
		unArmed.clear();
		
		fireMagic.add(new FireBall());
		fireMagic.add(new LavaCarpet());
		fireMagic.add(new FireBall());
		
		waterMagic.add(new WaterSplash());
		waterMagic.add(new Freeze());
		waterMagic.add(new WaterSplash());
		
		chaosMagic.add(new LightningStrike());
		chaosMagic.add(new LightningStrike());
		chaosMagic.add(new LightningStrike());
		
		hunterRanged.add(new Arrow());
		hunterRanged.add(new Arrow());
		hunterRanged.add(new Arrow());
		
		sniperRanged.add(new Arrow());
		sniperRanged.add(new Arrow());
		sniperRanged.add(new Arrow());
		
		scoutRanged.add(new Arrow());
		scoutRanged.add(new Arrow());
		scoutRanged.add(new Arrow());
		
		warriorMelee.add(new Cleave());
		warriorMelee.add(new Cleave());
		warriorMelee.add(new Cleave());
		
		knightMelee.add(new Cleave());
		knightMelee.add(new Cleave());
		knightMelee.add(new Cleave());
		
		mercenaryMelee.add(new Cleave());
		mercenaryMelee.add(new Cleave());
		mercenaryMelee.add(new Cleave());
		
		unArmed.add(new Punch());
		
		if(mainHand == null)
			skills = unArmed;
		else
			skills = fireMagic;
		
		System.out.println("Init done.");
	}

	public void render(SpriteBatch batch) {
		try{
			for (Skill s : activeSkills) {
				s.update();
				if(!(s.getClass().getSuperclass().toString().equals(AoE.class.toString())))
					s.render(batch);
			}
		}
		catch(Exception ex){}

		if (!dead) {

			// WEAPON !COMBAT //
			if (mainHand != null && !combat) {
				try{
					if (direction == DIRECTION.DOWN) {
						if (mainHand.type == Weapon.Type.STAFF)
							batch.draw(mainHand.getNonCombatFront(), positionX - 10, positionY + 5, 80, 80);
						else if (mainHand.type == Weapon.Type.BOW)
							batch.draw(mainHand.getNonCombatFront(), positionX + 20, positionY + 5, 40, 90);
						else if (mainHand.type == Weapon.Type.SWORD)
							batch.draw(mainHand.getNonCombatFront(), positionX - 5, positionY + 10, 80, 80);
					}
				}
				catch(Exception ex){ System.out.println("Non combat assets not set."); }
			}

			if (direction == DIRECTION.UP)
				batch.draw(AssetLoader.playerBack, positionX, positionY, width, height);
			else
				batch.draw(AssetLoader.playerFront, positionX, positionY, width, height);

			// BACKPIECE //
			if (backpiece != null) {
				if (direction == DIRECTION.DOWN)
					backpiece.render(batch, positionX + 16, positionY + 38, 56, 60);
			}

			// HELMET //
			if (helmet != null) {
				if (direction == DIRECTION.UP)
					helmet.render(batch, positionX + 34, positionY, 36, 44);
				else
					helmet.render(batch, positionX + 34, positionY, 36, 44);
			}
			
			// LEGS //
			if (legs != null) {
				if (moving)
					legs.render(batch, positionX + 34, positionY + 70, 36, 30);
				else {
					legs.renderIdle(batch, positionX + 28, positionY + 70, 48, 30);
				}
			} else {
				if (direction == DIRECTION.DOWN) {
					if (moving) {
						emptyWalkFront.setPosition(positionX + 24, positionY + 70);
						emptyWalkFront.setSize(36, 30);
						emptyWalkFront.draw(batch);
					} else
						batch.draw(AssetLoader.beginnerLegsIdleFront, positionX + 18, positionY + 70, 48, 30);
				} else {
					if (moving) {
						emptyWalkBack.setPosition(positionX + 34, positionY + 70);
						emptyWalkBack.setSize(36, 30);
						emptyWalkBack.draw(batch);
					} else
						batch.draw(AssetLoader.beginnerLegsIdleBack, positionX + 28, positionY + 70, 48, 30);
				}
			}

			// BODY //
			if (body != null) {
				if (direction == DIRECTION.UP)
					body.render(batch, positionX + 32, positionY + 40, 38, 29);
				else
					body.render(batch, positionX + 34, positionY + 39, 36, 31);
			} else {
				if (direction == DIRECTION.UP) {
					batch.draw(AssetLoader.BodyBack, positionX + 32, positionY + 40, 38, 30);
				} else {
					batch.draw(AssetLoader.BodyFront, positionX + 23, positionY + 39, 38, 32);
				}
			}
			// BACKPIECE //
			if (backpiece != null) {
				if (direction == DIRECTION.UP)
					backpiece.render(batch, positionX + 22, positionY + 35, 64, 60);
			}

			// WEAPON //
			if (mainHand != null) {
				if (combat) {
					if (direction == DIRECTION.UP) {
						if (mainHand.type == Weapon.Type.SWORD)
							mainHand.render(batch, positionX + 76, positionY + 10, 40, 60);
						else if (mainHand.type == Weapon.Type.BOW)
							mainHand.render(batch, positionX + 5, positionY + 12, 20, 80);
						else if (mainHand.type == Weapon.Type.STAFF)
							mainHand.render(batch, positionX + 60, positionY + 15, 50, 70);
					} else {
						if (mainHand.type == Weapon.Type.SWORD)
							mainHand.render(batch, positionX - 24, positionY + 12, 40, 60);
						else if (mainHand.type == Weapon.Type.BOW)
							mainHand.render(batch, positionX + 65, positionY + 12, 20, 80);
						else if (mainHand.type == Weapon.Type.STAFF)
							mainHand.render(batch, positionX - 15, positionY + 15, 50, 70);
					}
				} else {
					if (direction == DIRECTION.UP) {
						try{
							if (mainHand.type == Weapon.Type.STAFF)
								batch.draw(mainHand.getNonCombatBack(), positionX + 15, positionY + 10, 80, 80);
							else if (mainHand.type == Weapon.Type.BOW)
								batch.draw(mainHand.getNonCombatBack(), positionX + 25, positionY + 5, 40, 90);
							else if (mainHand.type == Weapon.Type.SWORD)
								batch.draw(mainHand.getNonCombatBack(), positionX + 15, positionY + 10, 80, 80);
						}
						catch(Exception ex){ System.out.println("Non combat assets not set."); }	
					}
				}
			}

		} else {
			respawn.render(batch);
			if (respawn.clicked()) {
				rpgGame.map = rpgGame.hauntedWoods;
				rpgGame.mapIndex = 45;
				currentHealth = maxHealth;
				dead = false;
			}
		}

		update();

		// BOTTOM BAR //
		batch.draw(AssetLoader.ui, 0, screen.y - 132, screen.x, 150);

		batch.draw(AssetLoader.ui, 0, screen.y - 35, screen.x, 35);
		float exp = (currentExperience * 100.0f) / maxExperience;
		rpgGame.font.setColor(Color.LIGHT_GRAY);
		rpgGame.font.draw(batch, String.format("%.1f", exp) + "%", screen.x - 200, screen.y - 28);

		rpgGame.font.setColor(Color.LIGHT_GRAY);
		rpgGame.font.draw(batch, Integer.toString(level), 15, screen.y - 28);
		rpgGame.font.setColor(Color.LIGHT_GRAY);
		rpgGame.font.draw(batch, Integer.toString(level + 1), screen.x - 70, screen.y - 28);

		rpgGame.font.setColor(Color.LIGHT_GRAY);
		rpgGame.font.draw(batch, "Endurance", 440, screen.y - 108);
		// BOTTOM BAR END //

		// SKILLS //

		batch.draw(AssetLoader.ui, 680, screen.y - 124, 500, 110);
		batch.draw(AssetLoader.slot, 690, screen.y - 105, 70, 70);
		batch.draw(AssetLoader.blackBorder, 690, screen.y - 105, 70, 70);
		batch.draw(AssetLoader.slot, 790, screen.y - 105, 70, 70);
		batch.draw(AssetLoader.blackBorder, 790, screen.y - 105, 70, 70);
		batch.draw(AssetLoader.slot, 890, screen.y - 105, 70, 70);
		batch.draw(AssetLoader.blackBorder, 890, screen.y - 105, 70, 70);

		if (autoAttacking) {
			batch.draw(AssetLoader.green, 695, 1342, 59, 59);
		}
		
		rpgGame.font.setColor(Color.ORANGE);
		rpgGame.font.draw(batch, "1", 695, screen.y - 65);
		rpgGame.font.draw(batch, "2", 795, screen.y - 65);
		rpgGame.font.draw(batch, "3", 895, screen.y - 65);

		if (mainHand != null) {
			try{
				batch.draw(skills.get(0).getIcon(), 710, screen.y - 95, 40, 40);
				
				if(skills.get(1).getRequiredLevel() > level)
					batch.draw(AssetLoader.lock, 810, screen.y - 95, 40, 40);
				else if(skills.get(1).isCoolDown())
					batch.draw(AssetLoader.coolDown, 810, screen.y - 95, 40, 40);
				else
					batch.draw(skills.get(1).getIcon(), 810, screen.y - 95, 40, 40);
				
				if(skills.get(2).getRequiredLevel() > level)
					batch.draw(AssetLoader.lock, 910, screen.y - 95, 40, 40);
				else if(skills.get(2).isCoolDown())
					batch.draw(AssetLoader.coolDown, 910, screen.y - 95, 40, 40);
				else
					batch.draw(skills.get(2).getIcon(), 910, screen.y - 95, 40, 40);
			}
			catch(Exception ex){}
		}
		else{
			batch.draw(skills.get(0).getIcon(), 710, screen.y - 95, 40, 40);
		}

		if (outOfRange) {
			batch.draw(AssetLoader.red, 690, 1330, 70, 10);
		}
		// SKILLS END //

		rpgGame.font.setColor(Color.ORANGE);
		rpgGame.font.draw(batch, name, 10, screen.y - 110);

		int h = (int) ((currentHealth * 100f) / maxHealth);
		if (h >= 75)
			rpgGame.font.setColor(Color.GREEN);
		else if (h >= 50)
			rpgGame.font.setColor(Color.YELLOW);
		else if (h >= 25)
			rpgGame.font.setColor(Color.ORANGE);
		else if (h >= 0)
			rpgGame.font.setColor(Color.RED);

		if (currentHealth <= 0)
			rpgGame.font.draw(batch, 0 + " / " + maxHealth, 230, screen.y - 70);
		else
			rpgGame.font.draw(batch, currentHealth + " / " + maxHealth, 230, screen.y - 70);

		if (outOfRange) {
			outOfRangeCounter++;
			batch.draw(AssetLoader.ui, positionX - 55, positionY + height + 15, 205, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 55, positionY + height + 15, 205, 35);
			rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, "Out Of Range", positionX - 50, positionY + height + 20);
		}
		if (outOfRangeCounter >= 100) {
			outOfRange = false;
			outOfRangeCounter = 0;
		}

	}

	public void sRenderFill(ShapeRenderer render) {

	}

	public void fillExpBar(ShapeRenderer render) {
		render.setColor(Color.ORANGE);
		int exp = (int) ((currentExperience * 100.0f) / maxExperience);
		render.rect(120, screen.y - 25, exp * 16, 15);
	}

	public void drawExpBar(ShapeRenderer render) {
		render.setColor(Color.ORANGE);
		render.rect(120, screen.y - 25, screen.x - 330, 15);
	}

	// Draws hp AND endurance
	public void drawHp(ShapeRenderer render) {

		render.setColor(Color.BLACK);
		render.rect(10, screen.y - 70, 200, 30);

		int h = (int) ((currentHealth * 100f) / maxHealth);
		if (h >= 75)
			render.setColor(Color.GREEN);
		else if (h >= 50)
			render.setColor(Color.YELLOW);
		else if (h >= 25)
			render.setColor(Color.ORANGE);
		else if (h >= 0)
			render.setColor(Color.RED);

		if (h <= 0)
			render.rect(10, screen.y - 70, 0, 30);
		else
			render.rect(10, screen.y - 70, h * 2, 30);

		// Draws endurance as well
		int e = (int) ((endurance * 100f) / maxEndurance);
		render.setColor(Color.BLACK);
		render.rect(440, screen.y - 70, 200, 30);
		render.setColor(Color.LIGHT_GRAY);
		render.rect(440, screen.y - 70, e * 2, 30);
	}

	public void drawHpLine(ShapeRenderer render) {
		render.setColor(Color.BLACK);
		render.rect(10, screen.y - 70, 200, 30);
		// Draws endurance as well
		render.rect(440, screen.y - 70, 200, 30);
	}

	public void sRenderLine(ShapeRenderer render) {

	}
	
	private Skill createSkill(Skill skill, List<Enemy> enemies){
		if(skill.getClass().toString().equals(Freeze.class.toString())) { return new Freeze(enemies, this); }
		else if(skill.getClass().toString().equals(LavaCarpet.class.toString())){ return new LavaCarpet(magicAttack, enemies, this); }
		
		return new Freeze(enemies, this);
	}
	private Skill createSkill(Skill skill, Enemy e){
		if(skill.getClass().toString().equals(FireBall.class.toString())) { return new FireBall(positionX + 40, positionY + 25, 25, 25, magicAttack, e, this); }
		else if(skill.getClass().toString().equals(WaterSplash.class.toString())){ return new WaterSplash(positionX + 40, positionY + 25, 25, 25, magicAttack, e, this); }
		else if(skill.getClass().toString().equals(LightningStrike.class.toString())){ return new LightningStrike(positionX - 100, positionY + 25, 25, 25, magicAttack * 2,
				e, this); }
		else if(skill.getClass().toString().equals(Cleave.class.toString())){ return new Cleave(getPositionX(), getPositionY(), 40, 40, meleeAttack, e, this); }
		else if(skill.getClass().toString().equals(Arrow.class.toString())){ return new Arrow(positionX + 40, positionY + 25, 24, 32, rangedAttack, e, this); }
		
		return new Punch(getPositionX(), getPositionY(), 40, 40, meleeAttack, e, this);
	}
	
	public void autoAttack(Enemy e) {
		if (!dead) {
			if(mainHand == null){
				attackTime = 40;
			}
			if(autoAttackCounter >= attackTime){
				if (positionX + width + skills.get(0).getRange() >= e.getPositionX()
						&& positionX - skills.get(0).getRange() <= (e.getPositionX() + e.getWidth())
						&& positionY + height + skills.get(0).getRange() >= e.getPositionY()
						&& positionY - skills.get(0).getRange() <= (e.getPositionY() + e.getHeight())) { 
					activeSkills.add(createSkill(skills.get(0), e));
					autoAttackCounter = 0;
				} else {
					outOfRange = true;
				}
			}
		}
		if (!e.isAlive()) {
			autoAttackCounter = 0;
			autoAttacking = false;
		}
	}

	public DIRECTION getDirection() {
		return direction;
	}

	public void setDirection(DIRECTION direction) {
		this.direction = direction;
	}

	public void secondAttack(List<Enemy> enemies) {
		try{
			if (!dead) {
				if(level >= skills.get(1).getRequiredLevel() &&
						!skills.get(1).isCoolDown()) {
					activeSkills.add(createSkill(skills.get(1), enemies));
					skills.get(1).setCoolDown(true);
				}
			}
		}
		catch(Exception ex){}
	}

	public void thirdAttack(Enemy e) {
		try{
			if(!dead){
				if(level >= skills.get(2).getRequiredLevel() &&
						!skills.get(2).isCoolDown()){
					activeSkills.add(createSkill(skills.get(2), e));
				}
			}
		}
		catch(Exception ex){}
	}

	private void levelUp() {
		level += 1;
		if (level % 5 == 0)
			levelPoints += 1;

		magicLevel += 1;
		rangedLevel += 1;
		meleeLevel += 1;
		endurance = 100;
		currentExperience = currentExperience - maxExperience;
		maxExperience += 10;
		maxHealth += 50;
		currentHealth = maxHealth;
		//characterMenu.setActive(true);
	}

	private void die() {
		for (InventorySlot s : bag.slots) {
			if (s.full) {
				s.dropWeapon();
				s.dropLegs();
				s.dropBody();
				s.dropBackpiece();
			}
		}
		currentExperience = 0;
		autoAttacking = false;
		autoAttackCounter = 0;
		activeSkills.clear();
		skillRemove.clear();
		for (Enemy e : rpgGame.map.get(rpgGame.mapIndex).enemies) {
			e.setTarget(false);
		}
		hasTarget = false;
	}

	private void update() {
		
		zone = rpgGame.map;
		mapIndex = rpgGame.mapIndex;
		
		for(Skill s : skills)
			s.updateCoolDown();
		
		location = rpgGame.map.get(rpgGame.mapIndex).getName();
		area = rpgGame.map.get(rpgGame.mapIndex).getArea();

		if (autoAttacking) {
			autoAttackCounter++;
		}

		if (!hasTarget) {
			autoAttacking = false;
			autoAttackCounter = 0;
		}

		if (currentHealth >= maxHealth)
			currentHealth = maxHealth;

		if (currentHealth <= 0) {
			dead = true;
			die();
		}

		//Allows the player to start running again even though the endurance may not be fully recharged
		if(Gdx.input.isKeyJustPressed(Keys.SHIFT_LEFT) && endurance > 0)
			enduranceEmpty = false;
		if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
			if (endurance > 0 && moving &&!enduranceEmpty) {
				endurance -= 20;
				speed = 5;
			} else {
				enduranceEmpty = true;
				speed = 3;
				if (endurance < maxEndurance) {
					endurance += 5;
				}
				if(endurance >= maxEndurance)
					enduranceEmpty = false;
			}
		} else {
			// safety line to keep it from getting 0 on already saved accounts
			maxEndurance = 1000;

			speed = 3;
			if (endurance < maxEndurance) {
				endurance += 5;
			}
		}

		if (currentExperience >= maxExperience) {
			levelUp();
		}

		// SKILL LISTS //
		for (Skill s : activeSkills) {
			if (!s.getActive() && !s.getDisplayDamage())
				skillRemove.add(s);
		}
		activeSkills.removeAll(skillRemove);
		skillRemove.clear();

		// SKILL LISTS END //

		if(helmet != null)
			helmet.setDirection(this.direction);
		
		if(helmet != null) {
			helmetMagicDamage = helmet.magicDamage;
			helmetRangeDamage = helmet.rangedDamage;
			helmetMeleeDamage = helmet.meleeDamage;
		}
		else {
			helmetMagicDamage = 0;
			helmetRangeDamage = 0;
			helmetMeleeDamage = 0;
		}
		if (legs != null) {
			legMagicDamage = legs.magicDamage;
			legRangeDamage = legs.rangedDamage;
			legMeleeDamage = legs.meleeDamage;
		} else {
			legMagicDamage = 0;
			legRangeDamage = 0;
			legMeleeDamage = 0;
		}
		if (body != null) {
			bodyMagicDamage = body.magicDamage;
			bodyRangedDamage = body.rangedDamage;
			bodyMeleeDamage = body.meleeDamage;
		} else {
			bodyMagicDamage = 0;
			bodyRangedDamage = 0;
			bodyMeleeDamage = 0;
		}
		if (backpiece != null) {
			backpieceMagicDamage = backpiece.magicDamage;
			backpieceRangedDamage = backpiece.rangedDamage;
			backpieceMeleeDamage = backpiece.meleeDamage;
		} else {
			backpieceMagicDamage = 0;
			backpieceRangedDamage = 0;
			backpieceMeleeDamage = 0;
		}

		if (mainHand == null) {
			rangedAttack = rangedLevel + helmetRangeDamage + legRangeDamage + bodyRangedDamage + backpieceRangedDamage;
			magicAttack = magicLevel + helmetMagicDamage + legMagicDamage + bodyMagicDamage + backpieceMagicDamage;
			meleeAttack = meleeLevel + helmetMeleeDamage + legMeleeDamage + bodyMeleeDamage + backpieceMeleeDamage;
		}
		try {
			if (mainHand.type == Weapon.Type.BOW) {
				if (characterMenu.rangeType[characterMenu.rangeIndex].equals("Hunter"))
					skills = hunterRanged;
				else if(characterMenu.rangeType[characterMenu.rangeIndex].equals("Sniper"))
					skills = sniperRanged;
				else if(characterMenu.rangeType[characterMenu.rangeIndex].equals("Scout"))
					skills = scoutRanged;
				
				attackTime = bowAttackTime;
				rangedAttack = rangedLevel + mainHand.rangedDamage + helmetRangeDamage + legRangeDamage + bodyRangedDamage
						+ backpieceRangedDamage;
			} else {
				rangedAttack = rangedLevel + helmetRangeDamage + legRangeDamage + bodyRangedDamage + backpieceRangedDamage;
			}
			if (mainHand.type == Weapon.Type.STAFF) {
				if (characterMenu.magicType[characterMenu.magicIndex].equals("Fire"))
					skills = fireMagic;
				else if(characterMenu.magicType[characterMenu.magicIndex].equals("Water"))
					skills = waterMagic;
				else if(characterMenu.magicType[characterMenu.magicIndex].equals("Chaos"))
					skills = chaosMagic;
				
				attackTime = staffAttackTime;
				magicAttack = magicLevel + mainHand.magicDamage + helmetMagicDamage + legMagicDamage + bodyMagicDamage
						+ backpieceMagicDamage;
			} else {
				magicAttack = magicLevel + helmetMagicDamage + legMagicDamage + bodyMagicDamage + backpieceMagicDamage;
			}
			if (mainHand.type == Weapon.Type.SWORD) {
				if (characterMenu.meleeType[characterMenu.meleeIndex].equals("Warrior"))
					skills = warriorMelee;
				else if(characterMenu.meleeType[characterMenu.meleeIndex].equals("Knight"))
					skills = knightMelee;
				else if(characterMenu.meleeType[characterMenu.meleeIndex].equals("Mercenary"))
					skills = mercenaryMelee;
				
				attackTime = swordAttackTime;
				meleeAttack = meleeLevel + mainHand.meleeDamage + helmetMeleeDamage + legMeleeDamage + bodyMeleeDamage
						+ backpieceMeleeDamage;
			} else {
				meleeAttack = meleeLevel + helmetMeleeDamage + legMeleeDamage + bodyMeleeDamage + backpieceMeleeDamage;
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		if (Gdx.input.isKeyJustPressed(Keys.I)) {
			if (bag.isActive())
				bag.setActive(false);
			else
				bag.setActive(true);
		}
		if (Gdx.input.isKeyJustPressed(Keys.C)) {
			if (characterMenu.isActive())
				characterMenu.setActive(false);
			else
				characterMenu.setActive(true);
		}
		if (Gdx.input.isKeyJustPressed(Keys.M)) {
			if (map.isActive())
				map.setActive(false);
			else
				map.setActive(true);
		}

		if (!dead) {
			if (Gdx.input.isKeyPressed(Keys.W))
				moveUp();
			if (Gdx.input.isKeyPressed(Keys.S))
				moveDown();
			if (Gdx.input.isKeyPressed(Keys.A))
				moveLeft();
			if (Gdx.input.isKeyPressed(Keys.D))
				moveRight();

			if (Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.A)
					|| Gdx.input.isKeyPressed(Keys.D)) {
				moving = true;
			} else
				moving = false;
		}

		screen.x = Gdx.graphics.getWidth();
		screen.y = Gdx.graphics.getHeight();
		rpgGame.cam.unproject(screen);
		if (positionX <= 5)
			positionX = 5;
		if (positionX + width + 5 >= screen.x)
			positionX = (int) (screen.x - (width + 5));
		if (positionY <= 5)
			positionY = 5;
		if (positionY + height + 5 >= screen.y - 122)
			positionY = (int) (screen.y - 122 - (height + 5));

		// SAVE PLAYER //
		Data.save(this);
	}

	public void equipMainHand(Weapon weapon) {
		unEquipMainHand();
		mainHand = weapon;
		mainHand.direction = direction;
	}

	public void equipHelmet(Helmet helmet) {
		unEquipHelmet();
		this.helmet = helmet;
		helmet.direction = direction;
	}
	
	public void equipLegs(Leg legs) {
		unEquipLegs();
		this.legs = legs;
		legs.direction = direction;
	}

	public void equipBody(Body body) {
		unEquipBody();
		this.body = body;
		body.direction = direction;
	}

	public void equipBackpiece(Backpiece backpiece) {
		unEquipBackpiece();
		this.backpiece = backpiece;
		backpiece.direction = direction;
	}

	public void unEquipMainHand() {
		if (mainHand != null)
			bag.add(mainHand);
	}
	
	public void unEquipHelmet() {
		if (helmet != null)
			bag.add(helmet);
	}
	
	public void unEquipLegs() {
		if (legs != null)
			bag.add(legs);
	}

	public void unEquipBody() {
		if (body != null)
			bag.add(body);
	}

	public void unEquipBackpiece() {
		if (backpiece != null)
			bag.add(backpiece);
	}

	private void moveUp() {
		moving = true;
		if (mainHand != null)
			mainHand.direction = DIRECTION.UP;
		if (legs != null)
			legs.direction = DIRECTION.UP;
		if (body != null)
			body.direction = DIRECTION.UP;
		if (backpiece != null)
			backpiece.direction = DIRECTION.UP;

		skillDirection = DIRECTION.UP;
		direction = DIRECTION.UP;
		positionY -= speed;
	}

	private void moveDown() {
		moving = true;
		if (mainHand != null)
			mainHand.direction = DIRECTION.DOWN;
		if (legs != null)
			legs.direction = DIRECTION.DOWN;
		if (body != null)
			body.direction = DIRECTION.DOWN;
		if (backpiece != null)
			backpiece.direction = DIRECTION.UP;

		skillDirection = DIRECTION.DOWN;
		direction = DIRECTION.DOWN;
		positionY += speed;
	}

	private void moveLeft() {
		moving = true;
		skillDirection = DIRECTION.LEFT;
		positionX -= speed;
	}

	private void moveRight() {
		moving = true;
		skillDirection = DIRECTION.RIGHT;
		positionX += speed;
	}

	public DIRECTION getSkillDirection() {
		return skillDirection;
	}

	public void setSkillDirection(DIRECTION skillDirection) {
		this.skillDirection = skillDirection;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public int getLevel() {
		return level;
	}

	public int getCurrentExperience() {
		return currentExperience;
	}

	public int getMaxExperience() {
		return maxExperience;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getDefenceLevel() {
		return defenceLevel;
	}

	public int getMagicLevel() {
		return magicLevel;
	}

	public int getRangedLevel() {
		return rangedLevel;
	}

	public int getMeleeLevel() {
		return meleeLevel;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setCurrentExperience(int currentExperience) {
		this.currentExperience = currentExperience;
	}

	public void setMaxExperience(int maxExperience) {
		this.maxExperience = maxExperience;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setDefenceLevel(int defenceLevel) {
		this.defenceLevel = defenceLevel;
	}

	public void setMagicLevel(int magicLevel) {
		this.magicLevel = magicLevel;
	}

	public void setRangedLevel(int rangedLevel) {
		this.rangedLevel = rangedLevel;
	}

	public void setMeleeLevel(int meleeLevel) {
		this.meleeLevel = meleeLevel;
	}

	public int getDefence() {
		return defence;
	}

	public int getMeleeAttack() {
		return meleeAttack;
	}

	public int getRangedAttack() {
		return rangedAttack;
	}

	public int getMagicAttack() {
		return magicAttack;
	}

	public int getMeleeDefence() {
		return meleeDefence;
	}

	public int getRangedDefence() {
		return rangedDefence;
	}

	public int getMagicDefence() {
		return magicDefence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public void setMeleeAttack(int meleeAttack) {
		this.meleeAttack = meleeAttack;
	}

	public void setRangedAttack(int rangedAttack) {
		this.rangedAttack = rangedAttack;
	}

	public void setMagicAttack(int magicAttack) {
		this.magicAttack = magicAttack;
	}

	public void setMeleeDefence(int meleeDefence) {
		this.meleeDefence = meleeDefence;
	}

	public void setRangedDefence(int rangedDefence) {
		this.rangedDefence = rangedDefence;
	}

	public void setMagicDefence(int magicDefence) {
		this.magicDefence = magicDefence;
	}

	public int getLevelPoints() {
		return levelPoints;
	}

	public void setLevelPoints(int levelPoints) {
		this.levelPoints = levelPoints;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Inventory getBag() {
		return bag;
	}

	public CharacterMenu getCharacterMenu() {
		return characterMenu;
	}

	public void setBag(Inventory bag) {
		this.bag = bag;
	}

	public void setCharacterMenu(CharacterMenu characterMenu) {
		this.characterMenu = characterMenu;
	}

	public WorldMap getMap() {
		return map;
	}

	public void setMap(WorldMap map) {
		this.map = map;
	}

	public Weapon getMainHand() {
		return mainHand;
	}

	public Leg getLegs() {
		return legs;
	}

	public Body getBody() {
		return body;
	}

	public void setMainHand(Weapon mainHand) {
		this.mainHand = mainHand;
	}

	public void setLegs(Leg legs) {
		this.legs = legs;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Backpiece getBackpiece() {
		return backpiece;
	}

	public void setBackpiece(Backpiece backpiece) {
		this.backpiece = backpiece;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getMaxEndurance() {
		return maxEndurance;
	}

	public void setMaxEndurance(int maxEndurance) {
		this.maxEndurance = maxEndurance;
	}

	public boolean isCombat() {
		return combat;
	}

	public void setCombat(boolean combat) {
		this.combat = combat;
	}

	public Helmet getHelmet() {
		return helmet;
	}

	public void setHelmet(Helmet helmet) {
		this.helmet = helmet;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

}
