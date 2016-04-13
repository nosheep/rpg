package com.nosheep.items;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

public class Backpiece implements Item, Serializable{

	private static final long serialVersionUID = -1556193371680688104L;
	
	public Player.DIRECTION direction;
	
	protected String name;
	public int magicDamage;
	public int rangedDamage;
	public int meleeDamage;
	public int defence;
	public boolean showInfo = false;
	public boolean loot;
	
	protected boolean onPlayer;
	protected int positionX, positionY;
	protected transient Sprite capeImage;
	protected transient AnimatedSprite capeAnimation;
	public int lootTimer = 0;
	
	public Backpiece(){
		loot = false;
		init();
	}
	public Backpiece(int positionX, int positionY){
		loot = true;
		this.positionX = positionX;
		this.positionY = positionY;
		init();
	}
	
	public void init(){
		direction = Player.DIRECTION.UP;
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
	
	public void renderIcon(SpriteBatch batch, int x, int y, int width, int height){
		if(capeImage != null)
			batch.draw(capeImage, x, y, width, height);
		else
			System.out.println("idleFront is null");
	}
	public void render(SpriteBatch batch, int x, int y, int width, int height){
		if(direction == Player.DIRECTION.UP){
			if(capeAnimation == null)
				batch.draw(capeImage, x, y, width, height);
			else{
				capeAnimation.setPlaying(true);
				capeAnimation.setPosition(x, y);
				capeAnimation.setSize(width, height);
				capeAnimation.draw(batch);
			}
		}
	}
	
	public void update(){
		if(isLoot())
			lootTimer++;
	}
	
	public void render(SpriteBatch batch){
		
		batch.draw(capeImage, positionX, positionY, 50, 50);
		
		if(onPlayer){
			batch.draw(AssetLoader.ui, positionX - 30, positionY - 90, 135, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 30, positionY - 90, 135, 35);
			batch.draw(AssetLoader.ui, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 10, positionY - 10, 70, 70);
			rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, name, positionX - 70, positionY - 45);
			rpgGame.font.draw(batch, "Loot (F)", positionX - 25, positionY - 85);
		}
		if(rpgGame.checkHover(positionX - 10, positionY - 10, 70, 70)){
			batch.draw(AssetLoader.ui, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 10, positionY - 10, 70, 70);
			rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, name, positionX - 70, positionY - 45);
		}
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
	public Player.DIRECTION getDirection() {
		return direction;
	}
	public String getName() {
		return name;
	}
	public int getMagicDamage() {
		return magicDamage;
	}
	public int getRangedDamage() {
		return rangedDamage;
	}
	public int getMeleeDamage() {
		return meleeDamage;
	}
	public int getDefence() {
		return defence;
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
	@Override
	public int getLootTimer() {
		return lootTimer;
	}
	public void setDirection(Player.DIRECTION direction) {
		this.direction = direction;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMagicDamage(int magicDamage) {
		this.magicDamage = magicDamage;
	}
	public void setRangedDamage(int rangedDamage) {
		this.rangedDamage = rangedDamage;
	}
	public void setMeleeDamage(int meleeDamage) {
		this.meleeDamage = meleeDamage;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public void setShowInfo(boolean showInfo) {
		this.showInfo = showInfo;
	}
	public void setLoot(boolean loot) {
		this.loot = loot;
	}
	public void setOnPlayer(boolean onPlayer) {
		this.onPlayer = onPlayer;
	}
	public void setLootTimer(int lootTimer) {
		this.lootTimer = lootTimer;
	}
	public Sprite getCapeImage() {
		return capeImage;
	}
	public void setCapeImage(Sprite capeImage) {
		this.capeImage = capeImage;
	}
	public AnimatedSprite getCapeAnimation() {
		return capeAnimation;
	}
	public void setCapeAnimation(AnimatedSprite capeAnimation) {
		this.capeAnimation = capeAnimation;
	}
	
}
