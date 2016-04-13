package com.nosheep.mainMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.network.Database;
import com.nosheep.network.Register;
import com.nosheep.player.Player;
import com.nosheep.tools.Button;
import com.nosheep.tools.Input;

public class Menu extends MainMenu {

	@SuppressWarnings("unused")
	private Button play;
	@SuppressWarnings("unused")
	private Button quit;
	@SuppressWarnings("unused")
	private Button options;
	
	public String ip;
	private boolean typingEmail = true;
	private Button login;
	private Button register;
	
	private Database db;

	private String email = "", password = "";
	private Player player;
	
	private Input input = new Input();
	
	public Menu(){
		login = new Button("Login", 550, 10, 300, 70, false);
		register = new Button("Register", 550, 110, 300, 70, false);
		play = new Button("Play", 100, 100, 300, 70, false);
	}
	
	private void checkClicked(){
		
		if(login.clicked()){
			login();
		}
		if(register.clicked()){
			register();
		}
		
	}

	private void login(){
		rpgGame.stop(AssetLoader.intro);
		db = new Database(this, email, password);
	}
	private void register(){
		new Register();
	}
	
	private void checkActiveInput(){
		if(Gdx.input.isKeyJustPressed(Keys.TAB)){
			if(typingEmail)
				typingEmail = false;
			else
				typingEmail = true;
		}
	}
	
	private void update(){
		if(Gdx.input.isKeyJustPressed(Keys.ENTER))
			login();
		
		checkActiveInput();
		if(typingEmail){
			if(input.checkRemove() && !email.isEmpty())
				email = email.substring(0, email.length() - 1);
			if(input.listen() != '´')
				email += input.listen();
		}
		else{
			if(input.checkRemove() && !password.isEmpty())
				password = password.substring(0, password.length() - 1);
			if(input.listen() != '´')
				password += input.listen();
		}
			
		if(rpgGame.checkHover(100, 10, 430, 70)){
			if(Gdx.input.justTouched()){
				typingEmail = true;
			}
		}
		if(rpgGame.checkHover(100, 110, 430, 70)){
			if(Gdx.input.justTouched()){
				typingEmail = false;
			}
		}
	}
	public void render(SpriteBatch batch){
		update();

		batch.draw(AssetLoader.ui, 0, 0, rpgGame.screen.x, rpgGame.screen.y);
		batch.draw(AssetLoader.slot, 90, 190, rpgGame.screen.x - 180, rpgGame.screen.y - 380);
		batch.draw(AssetLoader.backGround, 100, 200, rpgGame.screen.x - 200, rpgGame.screen.y - 400);
		checkClicked();
		rpgGame.font.setColor(Color.BLACK);
		if(typingEmail){
			batch.draw(AssetLoader.green, 100, 10, 430, 70);
			batch.draw(AssetLoader.slot, 100, 110, 430, 70);
			batch.draw(AssetLoader.black, 110, 70, 410, 5);
		}
		else{
			batch.draw(AssetLoader.slot, 100, 10, 430, 70);
			batch.draw(AssetLoader.green, 100, 110, 430, 70);
			batch.draw(AssetLoader.black, 110, 170, 410, 5);
		}
		if(email != null)
			rpgGame.font.draw(batch, email, 110, 40);
		if(password != null){
			String pwSize = "";
			for(int i=0; i<password.length(); i++){
				pwSize += "*";
			}
			rpgGame.font.draw(batch, pwSize, 110, 140);
		}
		
		login.render(batch);
		register.render(batch);
	}
	public void sRenderFill(ShapeRenderer render){
		render.setColor(Color.BLACK);
		render.rect(0, 0, Gdx.graphics.getWidth() * rpgGame.screenScale, Gdx.graphics.getHeight() * rpgGame.screenScale);
	}
	public void sRenderLine(ShapeRenderer render){}

	public Database getDb() {
		return db;
	}

	public void setDb(Database db) {
		this.db = db;
	}

	public void setPlayer(Player player){
		this.player = player;
	}
	public Player getPlayer(){
		return player;
	}
}
