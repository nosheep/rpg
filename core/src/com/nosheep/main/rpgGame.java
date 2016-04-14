package com.nosheep.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;
import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.items.BatBow;
import com.nosheep.items.BatStaff;
import com.nosheep.items.BatSword;
import com.nosheep.items.BeginnerBody;
import com.nosheep.items.BeginnerBow;
import com.nosheep.items.BeginnerLegs;
import com.nosheep.items.BeginnerStaff;
import com.nosheep.items.BeginnerSword;
import com.nosheep.items.IronHelmet;
import com.nosheep.items.Item;
import com.nosheep.items.KingBatBow;
import com.nosheep.items.KingBatStaff;
import com.nosheep.items.KingBatSword;
import com.nosheep.items.LavaCape;
import com.nosheep.mainMenu.Menu;
import com.nosheep.map.BatCave;
import com.nosheep.map.CrazyStumps;
import com.nosheep.map.CrazyStumps2;
import com.nosheep.map.CrazyStumps3;
import com.nosheep.map.CrazyStumps4;
import com.nosheep.map.Map;
import com.nosheep.map.NullMap;
import com.nosheep.network.Client;
import com.nosheep.network.Database;
import com.nosheep.objects.Tree;
import com.nosheep.player.Player;
import com.nosheep.tools.GraphicOptions;
import com.nosheep.tools.Portal;
import com.nosheep.tools.Window;
import com.nosheep.tools.inGameOptions;

public class rpgGame extends ApplicationAdapter {

	// NETWORK //
	private Client client;
	// NETWORK END //
	
	public static List<Item> items = new ArrayList<Item>();
	public static boolean loggedIn = false;
	private String version = "Alpha v1.2.9";
	public static final String TITLE = "ReallyPoorGraphics";
	private static boolean fullScreen = false;

	public static BitmapFont font;
	public static boolean mainMenu;
	public static float screenScale;

	@SuppressWarnings("unused")
	private Database db;

	// MAP //
	private List<Menu> mm = new ArrayList<Menu>();
	public static byte menuIndex;
	public static List<Map> map;
	public static byte mapIndex;

	public static List<List<Map>> zone = new ArrayList<List<Map>>();
	
	// DEV MAPS //
	public static List<Map> kingsForest = new ArrayList<Map>();
	public static List<Map> alphaCave = new ArrayList<Map>();
	public static List<Map> unknownArea = new ArrayList<Map>();
	// DEV MAPS END //
	
	public static List<Map> hauntedWoods = new ArrayList<Map>();
	public static List<Map> batCave = new ArrayList<Map>();
	
	// MAP END //

	// PLAYER //
	public static List<Player> connectedPlayers = new ArrayList<Player>();
	private Player player;
	public static int playerX, playerY;
	// PLAYER END //

	// GRAPHIC //
	private static SpriteBatch batch;
	private ShapeRenderer render;
	public static OrthographicCamera cam;
	// GRAPHIC END //

	// TOOLS //
	public static List<Window> windows = new ArrayList<Window>();
	// TOOLS END //

	private static Vector3 mouse;
	public static Vector3 screen;
	
	@Override
	public void create() {
		
		try {
			client = new Client();
			client.connect();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Could not connect to server.\n Please try again later.");
		}
		
		font = new BitmapFont(Gdx.files.internal("Fonts/rpgFont.fnt"), true);
		font.getData().setScale(.50f, .75f);
		rpgGame.font.getRegion().getTexture()
				.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		mainMenu = true;
		new AssetLoader();
		menuIndex = 0;
		mm.add(new Menu());
		mapIndex = 0;
		
		// TEMP PLAYER INIT //
		player = new Player("", 700, 500, 90, 100, 1);

		/*player.bag.add(new BeginnerStaff());
		player.bag.add(new BeginnerBow());
		player.bag.add(new BeginnerSword());*/
		// PLAYER INIT END //

		// AREA/MAP LISTS //
		/*kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap(player));
		kingsForest.add(new AlphaMap2(player));
		alphaCave.add(new AlphaCave1(player));
		unknownArea.add(new Unknown(player));*/
		
		//zone.add(kingsForest);
		//zone.add(alphaCave);
		//zone.add(unknownArea);

		// map = alphaArea;
				//map = kingsForest;
				//mapIndex = 20;
		initNullMaps(hauntedWoods);
		initNullMaps(batCave);
		
		hauntedWoods.set(45, new CrazyStumps(player));
		hauntedWoods.set(38, new CrazyStumps2(player));
		hauntedWoods.set(37, new CrazyStumps3(player));
		hauntedWoods.set(30, new CrazyStumps4(player));
		batCave.set(45, new BatCave(player));
		
		zone.add(hauntedWoods);
		zone.add(batCave);
		
		map = hauntedWoods;
		mapIndex = 45;
		
		// AREA/MAP LISTS END //

		// GRAPHICS INIT //
		batch = new SpriteBatch();
		render = new ShapeRenderer();
		// GRAPHICS INIT END //

		((Menu) mm.get(0)).setPlayer(player);

		for (Enemy e : map.get(mapIndex).enemies) {
			e.setPlayer(player);
		}

		// TOOLS INIT //
		windows.add(new GraphicOptions("Graphic options", 500, 100, 1200, 1000));
		windows.add(new inGameOptions("Options", 750, 200, 400, 800));
		//windows.add(player.bag);
		//windows.add(player.characterMenu);
		//windows.add(player.map);
		// TOOLS INIT END //

		cam = new OrthographicCamera();
		setCamera();
		mouse = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		screen = new Vector3(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);

		if (fullScreen) {
			setFullScreen();
		} else
			setWindowed();
		if (loggedIn)
			mainMenu = false;
		initItemList();
		
		Thread thread = new Thread(){
			public void run() {
				while(true){
					if(client.getData() != null)
						System.out.println("\n"+client.getData());
					client.sendMessage();
				}
			};
		};
		thread.start();
	}
	private void initNullMaps(List<Map> map){
		for(int i = 0; i < 49; i++)
			map.add(new NullMap(player));
	}
	private void initItemList(){
		items.add(new BeginnerBow());
		items.add(new BeginnerSword());
		items.add(new BeginnerStaff());
		items.add(new BeginnerBody());
		items.add(new BeginnerLegs());
		items.add(new BatBow());
		items.add(new BatSword());
		items.add(new BatStaff());
		items.add(new KingBatBow());
		items.add(new KingBatSword());
		items.add(new KingBatStaff());
		items.add(new LavaCape());
		items.add(new IronHelmet());
	}
	
	private void trees() {
		for (Tree t : map.get(mapIndex).trees) {
			t.checkPlayer(player);
		}
	}

	private void loot() {
		for(Item i : map.get(mapIndex).loot){
			if(i.checkPlayer(player)) {
				if(Gdx.input.isKeyJustPressed(Keys.F)){
					player.bag.add(i);
					break;
				}
			}
		}
	}

	private void autoAttack() {
		if (player.autoAttacking) {
			for (Enemy e : map.get(mapIndex).enemies) {
				if (e.isTarget()) {
					player.autoAttack(e);
				}
			}
		}
	}

	private void checkPlayerTarget() {
		boolean target = false;
		boolean combat = false;
		for (Enemy e : map.get(mapIndex).enemies) {
			if(e.isCombat() && e.getPlayer() == player)
				combat = true;
			
			if (e.isTarget()) {
				target = true;
				break;
			}
		}
		if(combat)
			player.setCombat(true);
		else
			player.setCombat(false);
		if (target)
			player.hasTarget = true;
		else
			player.hasTarget = false;
	}

	private void playerAttackInput() {
		if (Gdx.input.isKeyJustPressed(Keys.NUM_1)) {
			if (player.hasTarget)
				player.autoAttacking = true;
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_2))
			player.secondAttack(map.get(mapIndex).enemies);
		if (Gdx.input.isKeyJustPressed(Keys.NUM_3)) {
			for (Enemy e : map.get(mapIndex).enemies) {
				if (e.isTarget()) {
					player.thirdAttack(e);
				}
			}
		}
	}

	private void checkPortals() {
		for (Portal p : map.get(mapIndex).portals) {
			if (player.getPositionX() + player.getWidth() >= p.getPositionX()
					&& player.getPositionX() <= (p.getPositionX() + p
							.getWidth())
					&& player.getPositionY() + player.getHeight() >= p
							.getPositionY()
					&& player.getPositionY() <= (p.getPositionY() + p
							.getHeight())) {
				p.setOnPlayer(true);
			} else {
				p.setOnPlayer(false);
			}
		}
	}

	private void checkLocation(){		
		if(player.getPositionX() <= 5) {
			if(!(mapIndex <= 0) && mapIndex % 7 != 0 && rpgGame.map.get(mapIndex-1).getName() != "null") {
				mapIndex--;
				player.setPositionX((int)(screen.x - 95 - player.getWidth() + 50));
			}
		}
		else if(player.getPositionX() >= screen.x - 95) {
			if(!(mapIndex >= map.size() - 1) && mapIndex % 7 != 6 && rpgGame.map.get(mapIndex+1).getName() != "null") {
				mapIndex++;
				player.setPositionX(10);
			}
		}
		else if(player.getPositionY() <= 5) {
			if(!(mapIndex - 7 < 0) && rpgGame.map.get(mapIndex-7).getName() != "null") {
				mapIndex -= 7;
				player.setPositionY((int)(screen.y - 222 - player.getHeight() + 30));
			}
		}
		// 132 from Bottom Bar + 5 //
		else if(player.getPositionY() >= screen.y - 132 - player.getHeight() - 50) {
			if(!(mapIndex + 7 >= map.size()) && rpgGame.map.get(mapIndex+7).getName() != "null"){
				mapIndex += 7;
				player.setPositionY(10);
			}
		}
	}
	
	private void getItem(){
		try{
			boolean added = false;
			String item = JOptionPane.showInputDialog("Get Item: ");
			for(Item i : rpgGame.items){
				if(item.equals(i.getName())) {
					Item itemAdd = i.getClass().newInstance();
					player.bag.add(itemAdd);
					added = true;
					break;
				}
			}
			if(!added){
				try{
					int index = Integer.parseInt(item);
					Item itemAdd = rpgGame.items.get(index).getClass().newInstance();
					player.bag.add(itemAdd);
				}
				catch(Exception ex){}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void setMap(){
		String map = JOptionPane.showInputDialog("Map Index: ");
		try{
			int m = Integer.parseInt(map);
			if(m >= 0 && m < rpgGame.map.size())
				mapIndex = (byte)m;
		}
		catch(Exception ex){}
	}
	private void setZone(){
		String zone = JOptionPane.showInputDialog("Zone index: ");
		try{
			int z = Integer.parseInt(zone);
			if(z >= 0 && z < rpgGame.zone.size()){
				rpgGame.map = rpgGame.zone.get(z);
				if(mapIndex >= rpgGame.map.size())
					mapIndex = (byte)(rpgGame.map.size() - 1);
			}
		}
		catch(Exception ex){}
	}
	private void adminCommand(){
		if(Gdx.input.isKeyJustPressed(Keys.PLUS)){
			if(player.getName().equals("Hamsterslott")){
				Thread t = new Thread(new Runnable() {
			         public void run()
			         {
			        	 String option = JOptionPane.showInputDialog("1.Items; 2.Map; 3.Zone");
			        	 try{
			        		 int o = Integer.parseInt(option);
			        		 if(o == 1)
			        			 getItem();
			        		 else if(o == 2)
			        			 setMap();
			        		 else if(o == 3)
			        			 setZone();
			        	 }
			        	 catch(Exception ex){}
			         }
				});
				t.start();
			}
		}
	}
	private void update() {
		
		if(!client.IsConnected()){
			try{
				font.setColor(Color.RED);
				font.draw(getBatch(), "Lost connection with server, trying to re-establish", 100, 100);
				client.connect(); 
			}
			catch(Exception ex){}
		}
		
		adminCommand();
		player = ((Menu) mm.get(0)).getPlayer();
		checkLocation();
		for(Map m : map) {
			if(m.getPlayer() != player)
				m.setLink(player);
		}
		for (Enemy e : map.get(mapIndex).enemies) {
			e.setPlayer(player);
		}

		for (Map m : map) {
			m.update();
		}

		if (mainMenu) {
			play(AssetLoader.intro);
		} else {
			stop(AssetLoader.intro);
		}
		playerAttackInput();
		playerX = player.getPositionX();
		playerY = player.getPositionY();
		checkPlayerTarget();
		keyListener();
		checkFullScreen();
		trees();
		loot();
		checkPortals();
		if (player.hasTarget)
			autoAttack();
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/*if(Gdx.graphics.getWidth() <= 1280 || Gdx.graphics.getHeight() <= 720)
			Gdx.graphics.setDisplayMode(1280, 720, false);*/
		
		screen.x = Gdx.graphics.getWidth();
		screen.y = Gdx.graphics.getHeight();
		cam.unproject(screen);

		update();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(cam.combined);
		render.setProjectionMatrix(cam.combined);

		render.begin(ShapeType.Filled);
		if (mainMenu)
			mm.get(menuIndex).sRenderFill(render);
		else {
			map.get(mapIndex).sRenderFill(render);
			player.sRenderFill(render);
		}
		render.end();
		render.begin(ShapeType.Line);
		if (mainMenu)
			mm.get(menuIndex).sRenderLine(render);
		else {
			map.get(mapIndex).sRenderLine(render);
			player.sRenderLine(render);
		}
		render.end();
		
		batch.begin();
		if (mainMenu)
			mm.get(menuIndex).render(batch);
		else {
			map.get(mapIndex).render(batch);
			player.render(batch);
		}
		font.setColor(Color.ORANGE);
		font.draw(batch, TITLE + " " + version, 100, Gdx.graphics.getHeight()
				* screenScale - 170);
		font.setColor(Color.RED);
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 1700,
				Gdx.graphics.getHeight() * screenScale - 170);
		batch.end();

		// FOR SHAPERENDER NEEDING TO APPEAR ON TOP OF BATCH //
		if (!mainMenu) {
			render.begin(ShapeType.Filled);
			player.drawHp(render);
			player.fillExpBar(render);
			render.end();
			render.begin(ShapeType.Line);
			player.drawHpLine(render);
			player.drawExpBar(render);
			render.end();
		}
		// END //

		// FOR WINDOWS NEEDING TO APPEAR ON TOP //
		render.begin(ShapeType.Filled);
		for (Window w : windows) {
			w.sRenderFill(render);
		}
		render.end();
		render.begin(ShapeType.Line);
		for (Window w : windows) {
			w.sRenderLine(render);
		}
		render.end();
		batch.begin();

		for (Enemy e : map.get(mapIndex).enemies) {
			if (e.isAlive())
				e.renderTarget(batch);
		}
			
		for (Window w : windows) {
			w.render(batch);
		}
		batch.end();
		// FOR WINDOWS END //
	}

	@Override
	public void resize(int width, int height) {
		setCamera();
		super.resize(width, height);
	}

	private void checkFullScreen() {
		if (Gdx.input.isKeyJustPressed(Keys.F11)) {
			if (fullScreen) {
				setWindowed();
			} else {
				setFullScreen();
			}
		}
	}

	public static void setFullScreen() {
		if (!fullScreen && !mainMenu) {
			Gdx.graphics.setDisplayMode(
					Gdx.graphics.getDesktopDisplayMode().width,
					Gdx.graphics.getDesktopDisplayMode().height, true);
			fullScreen = true;
		}
	}

	public static void setWindowedFullscreen(){
		System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode().width,
				Gdx.graphics.getDesktopDisplayMode().height, false);
		fullScreen = false;
	}
	
	public static void setWindowed() {
		System.setProperty("org.lwjgl.opengl.Window.undecorated", "false");
		Gdx.graphics.setDisplayMode(1280, (1280 / 16) * 10, false);
		fullScreen = false;
	}

	@SuppressWarnings("unused")
	private void setCamera() {
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameHeight = 1440;
		float gameWidth;
		gameWidth = 1920;
		screenScale = gameHeight / screenHeight;
		cam.setToOrtho(true, gameWidth, gameHeight);
	}

	public static boolean checkHover(int x, int y, int w, int h) {
		mouse.x = Gdx.input.getX();
		mouse.y = Gdx.input.getY();
		cam.unproject(mouse);

		if (mouse.x >= x && mouse.x <= (x + w) && mouse.y >= y
				&& mouse.y <= (y + h)) {
			return true;
		} else
			return false;
	}

	public static void play(Music music) {
		music.setVolume(0.3f);
		music.play();
	}

	public static void stop(Music music) {
		music.stop();
	}

	public static int getMouseX() {
		mouse.x = Gdx.input.getX();
		cam.unproject(mouse);
		return (int) mouse.x;
	}

	public static int getMouseY() {
		mouse.y = Gdx.input.getY();
		cam.unproject(mouse);
		return (int) mouse.y;
	}

	private void keyListener() {
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			windows.get(0).setActive(false);
		}
	}

	public static SpriteBatch getBatch(){
		return batch;
	}
	
	@Override
	public void dispose() {
		client.disconnect();
		super.dispose();
	}
	
}
