package com.nosheep.items;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

public abstract class Weapon implements Item, Serializable{

	private static final long serialVersionUID = 3109429211457925095L;
	
	public static enum Type{
		STAFF, BOW, SWORD
	};
	
	public Player.DIRECTION direction;
	
	protected boolean rare = false;
	public int magicDamage;
	public int rangedDamage;
	public int meleeDamage;
	public Type type;
	protected transient Sprite front, nonCombatFront;
	protected transient Sprite back, nonCombatBack;
	protected String name;
	public boolean showInfo = false;
	public boolean loot, onPlayer;
	protected int positionX, positionY;
	public int lootTimer = 0;
	
	public Weapon(){
		loot = false;
		init();
	}
	public Weapon(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
		loot = true;
		init();
	}
	public void init(){}
	protected void setOnBackImages(Sprite f, Sprite b) {
		nonCombatFront = f;
		nonCombatBack = b;
	}
	public boolean checkPlayer(Player player){
		if(player.getPositionX() + player.getWidth() >= getPositionX()-10 &&
				player.getPositionX() <= (getPositionX()-10 + 70) &&
				(player.getPositionX() + player.getWidth()) >= getPositionX()-10 &&
				player.getPositionY() + player.getHeight() >= getPositionY()-10 &&
				player.getPositionY() <= (getPositionY()-10 + 70) &&
				(player.getPositionY() + player.getHeight()) >= getPositionY()-10){
			onPlayer = true;
			return true;
		}
		else{
			onPlayer = false;
			return false;
		}
	}
	public void renderInfo(ShapeRenderer render, int x, int y){
		if(showInfo){
			//render.setColor(Color.BLACK);
			//render.rect(x, y, 290, 240);
		}
	}
	public void update(){
		if(isLoot())
			lootTimer++;
	}
	
	public void render(SpriteBatch batch){
		
		if(type == Weapon.Type.BOW)
			batch.draw(front, positionX + 17, positionY, 20, 50);
		else
			batch.draw(front, positionX, positionY, 50, 50);
		
		if(onPlayer){
			batch.draw(AssetLoader.ui, positionX - 30, positionY - 90, 135, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 30, positionY - 90, 135, 35);
			batch.draw(AssetLoader.ui, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 10, positionY - 10, 70, 70);
			
			if(rare)
				rpgGame.font.setColor(Color.GREEN);
			else
				rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, name, positionX - 70, positionY - 45);
			rpgGame.font.draw(batch, "Loot (F)", positionX - 25, positionY - 85);
		}
		if(rpgGame.checkHover(positionX - 10, positionY - 10, 70, 70)){
			batch.draw(AssetLoader.ui, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 10, positionY - 10, 70, 70);
			if(rare)
				rpgGame.font.setColor(Color.GREEN);
			else
				rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, name, positionX - 70, positionY - 45);
		}
	}
	public void sRenderFill(ShapeRenderer render){

	}
	public void sRenderLine(ShapeRenderer render){
		render.setColor(Color.PINK);
		render.rect(positionX - 10, positionY - 10, 70, 70);
	}
	public void renderIcon(SpriteBatch batch, int x, int y, int width, int height){
		if(front != null)
			batch.draw(front, x, y, width, height);
	}
	public void render(SpriteBatch batch, int x, int y, int width, int height){
		if(direction == Player.DIRECTION.UP){
			if(back != null)
				batch.draw(back, x, y, width, height);
		}
		else{
			if(front != null)
				batch.draw(front, x, y, width, height);
		}
	}
	public void sRenderFill(ShapeRenderer render, int x, int y, int width, int height){
		
	}
	public void sRenderLine(ShapeRenderer render, int x, int y, int width, int height){}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	protected int getMagicDamage() {
		return magicDamage;
	}
	protected int getRangedDamage() {
		return rangedDamage;
	}
	protected int getMeleeDamage() {
		return meleeDamage;
	}
	protected void setMagicDamage(int magicDamage) {
		this.magicDamage = magicDamage;
	}
	protected void setRangedDamage(int rangedDamage) {
		this.rangedDamage = rangedDamage;
	}
	protected void setMeleeDamage(int meleeDamage) {
		this.meleeDamage = meleeDamage;
	}
	public Sprite getFront() {
		return front;
	}
	public Sprite getBack() {
		return back;
	}
	public void setFront(Sprite front) {
		this.front = front;
	}
	public void setBack(Sprite back) {
		this.back = back;
	}
	public Player.DIRECTION getDirection() {
		return direction;
	}
	public void setDirection(Player.DIRECTION direction) {
		this.direction = direction;
	}
	public boolean isShowInfo() {
		return showInfo;
	}
	public boolean isLoot() {
		return loot;
	}
	public boolean isOnPlayer() {
		return onPlayer;
	}
	public void setShowInfo(boolean showInfo) {
		this.showInfo = showInfo;
	}
	public void setLoot(boolean loot) {
		lootTimer = 0;
		this.loot = loot;
	}
	public void setOnPlayer(boolean onPlayer) {
		this.onPlayer = onPlayer;
	}
	@Override
	public int getLootTimer() {
		return lootTimer;
	}
	public Sprite getNonCombatFront() {
		return nonCombatFront;
	}
	public Sprite getNonCombatBack() {
		return nonCombatBack;
	}
	public void setNonCombatFront(Sprite nonCombatFront) {
		this.nonCombatFront = nonCombatFront;
	}
	public void setNonCombatBack(Sprite nonCombatBack) {
		this.nonCombatBack = nonCombatBack;
	}
	public boolean isRare() {
		return rare;
	}
	public void setRare(boolean rare) {
		this.rare = rare;
	}
}
