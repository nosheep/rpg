package com.nosheep.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.items.Item;
import com.nosheep.main.rpgGame;
import com.nosheep.objects.Tree;
import com.nosheep.player.Player;
import com.nosheep.skills.AoE;
import com.nosheep.skills.Skill;
import com.nosheep.tools.Portal;
import com.nosheep.tools.UnknownPortal;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

public abstract class Map implements Serializable{

	private static final long serialVersionUID = 6069892403820735077L;
	
	public static enum Weather{
		sunny, raining;
	}
	
	protected Weather weather = Weather.sunny;
	protected int weatherCounter = 0;
	protected transient AnimatedSprite weatherAnimation;
	protected boolean weatherRotaion = true;
	
	protected String name = "";
	protected String area = "";
	protected transient Sprite image;
	protected transient Sprite borderLeft, borderRight, borderUp, borderDown;
	public List<Enemy> enemies = new ArrayList<Enemy>();
	public List<Tree> trees = new ArrayList<Tree>();
	public List<Item> loot = new ArrayList<Item>();
	private List<Item> lootRemove = new ArrayList<Item>();
	public List<Portal> portals = new ArrayList<Portal>();
	private int tabIndex = 0;
	private Player player;
	
	private UnknownPortal uPortal;
	
	public Map(Player player){
		this.player = player;
		init(player);
	}
	public void init(Player player){
		uPortal = new UnknownPortal(enemies, player);
	}

	public void renderEnvironment(SpriteBatch batch){
		
	}
	public void update(){
		for(Item i : loot){
			i.update();
			if(i.getLootTimer() >= 5000)
				lootRemove.add(i);
		}
		loot.removeAll(lootRemove);
		lootRemove.clear();
	}
	
	public void render(SpriteBatch batch){
		int xOffset, yOffset;
		xOffset = 0;
		yOffset = 0;
		if(image != null) {
			//batch.draw(image, 0, 0, Gdx.graphics.getWidth() * rpgGame.screenScale, Gdx.graphics.getHeight() * rpgGame.screenScale);
			for(int i = 0; i < 200; i++) {
				batch.draw(image, xOffset * rpgGame.screenScale, yOffset * rpgGame.screenScale, 100 * rpgGame.screenScale, 100 * rpgGame.screenScale);
				xOffset += 100;
				if(i % 20 == 18) {
					xOffset = 0;
					yOffset += 100;
				}
			}	
		}
		
		if(borderUp != null)
			batch.draw(borderUp, 0, -20, rpgGame.screen.x, 100);
		if(borderDown != null)
			batch.draw(borderDown, 0, rpgGame.screen.y - 170, rpgGame.screen.x, 40);
		if(borderLeft != null)
			batch.draw(borderLeft, 0, 0, 40, rpgGame.screen.y);
		if(borderRight != null)
			batch.draw(borderRight, rpgGame.screen.x - 40, 0, 40, rpgGame.screen.y);
			
		renderEnvironment(batch);
		
		for(Portal p : portals){
			p.render(batch);
		}
		
		for(Tree t : trees){
			t.render(batch);
		}
		for(Skill s : player.activeSkills)
			if(s.getClass().getSuperclass().toString().equals(AoE.class.toString()))
				s.render(batch);
		for(Enemy e : enemies){
			e.render(batch);
		}
		for(Item i : loot)
			i.render(batch);
		
		uPortal.render(batch);
		renderWeather(batch);
		checkEscapePressed();
	}
	
	private void checkWeather(){
		weatherCounter++;
		//System.out.println("WeatherCounter: " + weatherCounter);
		if(weatherCounter >= 10000){
			if(weather == Weather.sunny)
				for(Map m : rpgGame.map)
					m.weather = Weather.raining;
			else if(weather == Weather.raining)
				for(Map m : rpgGame.map)
					m.weather = Weather.sunny;
			weatherCounter = 0;
		}
	}
	private void renderWeather(SpriteBatch batch){
		if(weatherRotaion)
			checkWeather();
		
		if(weather == Weather.sunny){ weatherAnimation = null; }
		else if(weather == Weather.raining){ weatherAnimation = AssetLoader.raining; }
		
		if(weatherAnimation != null){
			weatherAnimation.setPosition(0, 0);
			weatherAnimation.setSize(Gdx.graphics.getWidth() * rpgGame.screenScale, 
									 Gdx.graphics.getHeight() * rpgGame.screenScale);
			weatherAnimation.draw(batch);
		}
	}
	
	private void checkTab(){
		if(Gdx.input.isKeyJustPressed(Keys.TAB)){
			for(Enemy e : enemies){
				e.setTarget(false);
			}
			
			if(tabIndex >= 0){
				boolean foundTarget = false;
				while(!foundTarget){
					if(enemies.get(tabIndex).isAlive()){
						enemies.get(tabIndex).getPlayer().autoAttacking = false;
						enemies.get(tabIndex).setTarget(true);
						foundTarget = true;
						break;
					} 
					else {
						tabIndex++;
						if(tabIndex >= enemies.size())
							tabIndex = 0;
						continue;
					}
				}
			}
			
			tabIndex++;
			
			if(tabIndex >= enemies.size())
				tabIndex = -1;	
		}
		checkTarget();
	}
	private void checkTarget(){
		if(Gdx.input.isButtonPressed(Buttons.RIGHT)){
			for(Enemy e : enemies){
				e.setTarget(false);
			}
		}
		for(Enemy e : enemies){
			if(e.checkTargeted()){
				for(Enemy en : enemies){
					if(en.isTarget()){
						if(en == e){
							break;
						}
						else{
							en.setTarget(false);
							en.getPlayer().autoAttacking = false;
							e.setTarget(true);
						}
					}
				}
				for(Enemy enn : enemies){
					enn.setTarget(false);
				}
				e.setTarget(true);
				break;
			}
		}
	}
	public void sRenderFill(ShapeRenderer render){
		checkTab();
		for(Enemy e : enemies){
			e.sRenderFill(render);
		}
		for(Tree t : trees){
			t.sRenderFill(render);
		}
	}
	public void sRenderLine(ShapeRenderer render){
		for(Enemy e : enemies){
			e.sRenderLine(render);
		}
		for(Tree t : trees){
			t.sRenderLine(render);
		}
	}
	private void checkEscapePressed(){
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
			if(rpgGame.windows.get(2).isActive())
				rpgGame.windows.get(2).setActive(false);
			else{
				if(!rpgGame.windows.get(1).isActive())
					rpgGame.windows.get(1).setActive(true);
				else
					rpgGame.windows.get(1).setActive(false);
			}
		}
	}

	public void setLink(Player player){
		this.player = player;
		for(Portal p : portals)
			p.setLink(player);
		uPortal.setLink(player);
	}
	
	public String getName() {
		return name;
	}

	public String getArea() {
		return area;
	}

	public TextureRegion getImage() {
		return image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setImage(Sprite window) {
		this.image = window;
	}
	public boolean isWeatherRotaion() {
		return weatherRotaion;
	}
	public void setWeatherRotaion(boolean weatherRotaion) {
		this.weatherRotaion = weatherRotaion;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	public Player getPlayer() {
		return player;
	}

}
