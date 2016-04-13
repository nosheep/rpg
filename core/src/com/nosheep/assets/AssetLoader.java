package com.nosheep.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

public class AssetLoader {

	// TEXTURES //
	public static Sprite moss;
	public static Sprite grass;
	public static Sprite ui;
	public static Sprite slot;
	public static Sprite rock;
	// TEXTURES END //
	
	// CHARACTER //
	public static Sprite playerFront;
	public static Sprite playerBack;
	// CHARACTER END //

	// SOUND //
	public static Music intro;
	// SOUND END //

	// COLORS //
	public static Sprite blue;
	public static Sprite black;
	public static Sprite blackBorder;
	public static Sprite green;
	public static Sprite forestGreen;
	public static Sprite yellow;
	public static Sprite orange;
	public static Sprite red;
	public static Sprite brown;
	public static Sprite gray;
	public static Sprite darkgray;
	public static Sprite teal;
	public static Sprite purple;
	public static Sprite pink;
	// COLORS END //

	public static Texture back;

	// BACKGROUND //
	public static Sprite backGround;
	public static Sprite gubbeBG;
	// BACKGROUND END //

	// TOOLS //
	public static Sprite window;
	public static Sprite smallWindow;
	public static Sprite inventorySlot;
	public static Sprite inventorySlotHover;
	public static Sprite exitButton;
	public static Sprite exitButtonHover;
	public static Sprite button;
	public static Sprite buttonHover;
	public static Sprite plus;
	public static Sprite mapLocation;
	public static Sprite portal;
	// TOOLS END //

	// ENVIRONMENT //
	public static Sprite cave;
	public static Sprite bloodstain;
	public static Sprite bones;
	public static Animation unknownPortalAnim;
	public static AnimatedSprite unknownPortal;
	// ENVIRONMENT END //

	// TREES //
	public static Animation regularTreeAnim;
	public static AnimatedSprite regularTree;
	public static Sprite regularTreeCutDown;
	// TREES END //

	// ENEMIES //
	private static Animation stumpWalkAnim;
	public static AnimatedSprite stumpWalk;
	private static Animation stumpAttackAnim;
	public static AnimatedSprite stumpAttack;
	private static Animation batFlyAnim;
	public static AnimatedSprite batFly;
	private static Animation kingBatFlyAnim;
	public static AnimatedSprite kingBatFly;
	private static Animation unknownDragonFlyUpAnim;
	public static AnimatedSprite unknownDragonFlyUp;
	private static Animation unknownDragonFlyDownAnim;
	public static AnimatedSprite unknownDragonFlyDown;
	// ENEMIES END //

	// WEAPONS //
	public static Sprite beginner_bow;
	public static Sprite beginner_staff;
	public static Sprite beginner_sword;
	public static Sprite batBowFront;
	public static Sprite batStaffFront;
	public static Sprite batSwordFront;
	public static Sprite kingBatBowFront;
	public static Sprite kingBatStaffFront;
	public static Sprite kingBatSwordFront;
	public static Sprite beginnerSwordFront;
	public static Sprite beginnerSwordBack;
	public static Sprite beginnerBowFront;
	public static Sprite beginnerBowBack;
	public static Sprite beginnerStaffFront;
	public static Sprite beginnerStaffBack;
	public static Sprite batBowBack;
	public static Sprite batStaffBack;
	public static Sprite batSwordBack;
	public static Sprite kingBatBowBack;
	public static Sprite kingBatStaffBack;
	public static Sprite kingBatSwordBack;
	// WEAPONS END //
	// WEAPON NON COMBAT //
	public static Sprite nonCombatBeginner_bow;
	public static Sprite nonCombatBeginner_staff;
	public static Sprite nonCombatBeginner_sword;
	public static Sprite nonCombatBatBowFront;
	public static Sprite nonCombatBatStaffFront;
	public static Sprite nonCombatBatSwordFront;
	public static Sprite nonCombatKingBatBowFront;
	public static Sprite nonCombatKingBatStaffFront;
	public static Sprite nonCombatKingBatSwordFront;
	public static Sprite nonCombatBeginnerSwordFront;
	public static Sprite nonCombatBeginnerSwordBack;
	public static Sprite nonCombatBeginnerBowFront;
	public static Sprite nonCombatBeginnerBowBack;
	public static Sprite nonCombatBeginnerStaffFront;
	public static Sprite nonCombatBeginnerStaffBack;
	public static Sprite nonCombatBatBowBack;
	public static Sprite nonCombatBatStaffBack;
	public static Sprite nonCombatBatSwordBack;
	public static Sprite nonCombatKingBatBowBack;
	public static Sprite nonCombatKingBatStaffBack;
	public static Sprite nonCombatKingBatSwordBack;
	// WEAPON NON COMBAT END //

	// HELMETS //
	public static Sprite ironHelmetFront;
	public static Sprite ironHelmetBack;
	// HELMETS END //
	
	// LEGS //
	public static Sprite beginnerLegsIdleFront;
	public static Sprite beginnerLegsIdleBack;

	public static Animation beginnerLegsWalkFrontAnim;
	public static AnimatedSprite beginnerLegsWalkFront;

	public static Animation beginnerLegsWalkBackAnim;
	public static AnimatedSprite beginnerLegsWalkBack;
	// LEGS END //

	// BODY //
	public static Sprite BodyFront;
	public static Sprite BodyBack;
	public static Sprite beginnerBodyFront;
	public static Sprite beginnerBodyBack;
	// BODY END //

	// BACKPIECE //
	public static Animation lavaCapeAnim;
	public static AnimatedSprite lavaCape;
	public static Sprite lavaCapeImage;
	// BACKPIECE END //

	// ENEMY SKILLS //
	private static Animation greenFireBallAnim;
	public static AnimatedSprite greenFireBall;
	public static Sprite gFireBall;
	// ENEMY SKILLS END //

	// SKILLS //
	public static Sprite waterSplashTexture;
	public static Sprite lightningStrikeTexture;
	public static Sprite fireBall;
	public static Sprite arrowUp;
	public static Sprite arrowDown;
	public static Sprite arrowLeft;
	public static Sprite arrowRight;
	public static Sprite aoeFreeze;
	public static Sprite cleave;
	public static Sprite lavaCarpet;
	public static Sprite lavaCarpetSide;
	public static Sprite coolDown;
	public static Sprite lock;
	public static Sprite burn;
	// SKILLS END //

	// SKILLICONS //
	public static Sprite fireBallIcon;
	public static Sprite arrowIcon;
	public static Sprite freezeIcon;
	public static Sprite cleaveIcon;
	public static Sprite healIcon;
	public static Sprite punchIcon;
	// SKILLICONS END //

	// OTHER //
	public static Sprite combat;
	public static Sprite target;
	// OTHER END //

	// ANIMATIONS //
	public static Animation explosionAnim;
	public static AnimatedSprite explosion;

	public static Animation bleedingAnim;
	public static AnimatedSprite bleeding;

	public static Animation waterSplashAnim;
	public static AnimatedSprite waterSplash;

	public static Animation lightningStrikeAnim;
	public static AnimatedSprite lightningStrike;

	public static Animation rainingAnim;
	public static AnimatedSprite raining;
	// ANIMATIONS END //
	
	// BORDERS //
		public static Sprite treeBorderUp;
		public static Sprite treeBorderDown;
		public static Sprite treeBorderLeft;
		public static Sprite treeBorderRight;
	// BORDERS END //
		
	// CURRENCY //
		public static Sprite coins;
	// CURRENCY END //

	public AssetLoader() {

		// TEXTURES //
		moss = new Sprite(new Texture("textures/moss.png"));
		moss.flip(false, true);
		grass = new Sprite(new Texture("textures/grass.png"));
		grass.flip(false, true);
		ui = new Sprite(new Texture("textures/ui2.png"));
		slot = new Sprite(new Texture("textures/slot.jpg"));
		rock = new Sprite(new Texture("textures/rock.png"));
		// TEXTURES END //
		
		// CHARACTER //
		playerFront = new Sprite(new Texture("character/charFront.png"));
		playerFront.flip(false, true);
		playerBack = new Sprite(new Texture("character/charBack.png"));
		playerBack.flip(false, true);
		// CHARACTER END //

		// SOUND //
		intro = Gdx.audio.newMusic(Gdx.files.internal("sound/rpg_intro.mp3"));
		// SOUND END //

		// COLORS //
		blue = new Sprite(new Texture("colors/blue.png"));
		black = new Sprite(new Texture("colors/black.png"));
		blackBorder = new Sprite(new Texture("colors/black_border.png"));
		green = new Sprite(new Texture("colors/green.png"));
		forestGreen = new Sprite(new Texture("colors/forestGreen.png"));
		yellow = new Sprite(new Texture("colors/yellow.png"));
		orange = new Sprite(new Texture("colors/orange.png"));
		red = new Sprite(new Texture("colors/red.png"));
		brown = new Sprite(new Texture("colors/brown.png"));
		gray = new Sprite(new Texture("colors/gray.png"));
		darkgray = new Sprite(new Texture("colors/darkgray.png"));
		teal = new Sprite(new Texture("colors/teal.png"));
		purple = new Sprite(new Texture("colors/purple.png"));
		pink = new Sprite(new Texture("colors/pink.png"));
		// COLORS END //

		// BACKGROUND //
		backGround = new Sprite(new Texture("background/background2.png"));
		backGround.flip(false, true);
		gubbeBG = new Sprite(new Texture("background/gubbeBG.png"));
		gubbeBG.flip(false, true);
		// BACKGROUND END //
		// TOOLS //
		window = new Sprite(new Texture("tools/WindowBackground.png"));
		smallWindow = new Sprite(new Texture("tools/smallWindow.png"));
		inventorySlot = new Sprite(new Texture("tools/inventorySlot.png"));
		inventorySlotHover = new Sprite(new Texture("tools/inventorySlotHover.png"));
		exitButton = new Sprite(new Texture("tools/exitButton.png"));
		exitButtonHover = new Sprite(new Texture("tools/exitButtonHover.png"));
		button = new Sprite(new Texture("tools/button.png"));
		buttonHover = new Sprite(new Texture("tools/buttonHover.png"));
		plus = new Sprite(new Texture("tools/plus.png"));
		mapLocation = new Sprite(new Texture("tools/mapLocation.png"));
		mapLocation.flip(true, true);
		portal = new Sprite(new Texture("tools/portal.png"));
		portal.flip(true, true);
		// TOOLS END //

		// ENVIRONMENT //
		cave = new Sprite(new Texture("environment/cave.png"));
		cave.flip(true, true);
		bloodstain = new Sprite(new Texture("environment/bloodstain.png"));
		bloodstain.flip(true, true);
		bones = new Sprite(new Texture("environment/bones.png"));
		bones.flip(true, true);

		unknownPortalAnim = new Animation(1 / 2f,
				new Sprite(new Texture("environment/unknownPortal1.png")),
				new Sprite(new Texture("environment/unknownPortal2.png")),
				new Sprite(new Texture("environment/unknownPortal3.png")));
		unknownPortalAnim.setPlayMode(Animation.PlayMode.LOOP);
		unknownPortal = new AnimatedSprite(unknownPortalAnim);
		unknownPortal.flipFrames(true, true);
		// ENVIRONMENT END //

		// TREES //
		back = new Texture("other/back.png");
		regularTreeCutDown = new Sprite(new Texture("trees/treeCut.png"));
		regularTreeCutDown.flip(true, true);
		regularTreeAnim = new Animation(0.1f, new Sprite(new Texture("trees/tree1.png")),
				new Sprite(new Texture("trees/tree1.png")));
		regularTreeAnim.setPlayMode(Animation.PlayMode.LOOP);
		regularTree = new AnimatedSprite(regularTreeAnim);
		regularTree.flipFrames(true, true);
		// TREES END //

		// ENEMIES //
		stumpWalkAnim = new Animation(1f, new Sprite(new Texture("enemies/stumpWalk1.png")),
				new Sprite(new Texture("enemies/stumpWalk2.png")));
		stumpWalkAnim.setPlayMode(Animation.PlayMode.LOOP);
		stumpWalk = new AnimatedSprite(stumpWalkAnim);
		stumpWalk.flipFrames(true, true);

		stumpAttackAnim = new Animation(1 / 2f, new Sprite(new Texture("enemies/stumpAttack1.png")),
				new Sprite(new Texture("enemies/stumpAttack2.png")),
				new Sprite(new Texture("enemies/stumpAttack3.png")),
				new Sprite(new Texture("enemies/stumpAttack4.png")));
		stumpAttackAnim.setPlayMode(Animation.PlayMode.LOOP);
		stumpAttack = new AnimatedSprite(stumpAttackAnim);
		stumpAttack.flipFrames(true, true);

		batFlyAnim = new Animation(1f, new Sprite(new Texture("enemies/Bat1.png")),
				new Sprite(new Texture("enemies/Bat2.png")));
		batFlyAnim.setPlayMode(Animation.PlayMode.LOOP);
		batFly = new AnimatedSprite(batFlyAnim);
		batFly.flipFrames(true, true);

		kingBatFlyAnim = new Animation(1f, new Sprite(new Texture("enemies/kingBat1.png")),
				new Sprite(new Texture("enemies/kingBat2.png")));
		kingBatFlyAnim.setPlayMode(Animation.PlayMode.LOOP);
		kingBatFly = new AnimatedSprite(kingBatFlyAnim);
		kingBatFly.flipFrames(true, true);

		unknownDragonFlyUpAnim = new Animation(1f, new Sprite(new Texture("enemies/unknownDragonUp3.png")),
				new Sprite(new Texture("enemies/unknownDragonUp1.png")),
				new Sprite(new Texture("enemies/unknownDragonUp2.png")));
		unknownDragonFlyUpAnim.setPlayMode(Animation.PlayMode.LOOP);
		unknownDragonFlyUp = new AnimatedSprite(unknownDragonFlyUpAnim);
		unknownDragonFlyUp.flipFrames(true, true);

		unknownDragonFlyDownAnim = new Animation(1f,
				new Sprite(new Texture("enemies/unknownDragonUp3.png")),
				new Sprite(new Texture("enemies/unknownDragonUp1.png")),
				new Sprite(new Texture("enemies/unknownDragonUp2.png")));
		unknownDragonFlyDownAnim.setPlayMode(Animation.PlayMode.LOOP);
		unknownDragonFlyDown = new AnimatedSprite(unknownDragonFlyDownAnim);
		// ENEMIES END //

		// WEAPONS //
		beginner_bow = new Sprite(new Texture("weapons/beginnerBow.png"));
		beginner_bow.flip(true, true);
		beginner_staff = new Sprite(new Texture("weapons/beginnerStaff.png"));
		beginner_staff.flip(true, true);
		beginner_sword = new Sprite(new Texture("weapons/sword.png"));
		beginner_sword.flip(false, true);

		batBowFront = new Sprite(new Texture("weapons/BatBowFront.png"));
		batBowFront.flip(false, true);
		batStaffFront = new Sprite(new Texture("weapons/BatStaffFront.png"));
		batStaffFront.flip(false, true);
		batSwordFront = new Sprite(new Texture("weapons/BatSwordFront.png"));
		batSwordFront.flip(false, true);

		batBowBack = new Sprite(new Texture("weapons/BatBowBack.png"));
		batBowBack.flip(false, true);
		batStaffBack = new Sprite(new Texture("weapons/BatStaffBack.png"));
		batStaffBack.flip(false, true);
		batSwordBack = new Sprite(new Texture("weapons/BatSwordBack.png"));
		batSwordBack.flip(false, true);

		kingBatBowFront = new Sprite(new Texture("weapons/KingBatBowFront.png"));
		kingBatBowFront.flip(true, true);
		kingBatStaffFront = new Sprite(new Texture("weapons/KingBatStaffFront.png"));
		kingBatStaffFront.flip(false, true);
		kingBatSwordFront = new Sprite(new Texture("weapons/KingBatSwordFront.png"));
		kingBatSwordFront.flip(false, true);

		kingBatBowBack = new Sprite(new Texture("weapons/KingBatBowBack.png"));
		kingBatBowBack.flip(true, true);
		kingBatStaffBack = new Sprite(new Texture("weapons/KingBatStaffBack.png"));
		kingBatStaffBack.flip(false, true);
		kingBatSwordBack = new Sprite(new Texture("weapons/KingBatSwordBack.png"));
		kingBatSwordBack.flip(false, true);

		beginnerSwordBack = new Sprite(new Texture("weapons/swordBack.png"));
		beginnerSwordBack.flip(false, true);
		beginnerSwordFront = new Sprite(new Texture("weapons/swordFront.png"));
		beginnerSwordFront.flip(false, true);
		beginnerBowBack = new Sprite(new Texture("weapons/beginnerBowBack.png"));
		beginnerBowBack.flip(false, true);
		beginnerBowFront = new Sprite(new Texture("weapons/beginnerBowFront.png"));
		beginnerBowFront.flip(false, true);
		beginnerStaffBack = new Sprite(new Texture("weapons/BeginnerStaffBack.png"));
		beginnerStaffBack.flip(false, true);
		beginnerStaffFront = new Sprite(new Texture("weapons/BeginnerStaffFront.png"));
		beginnerStaffFront.flip(false, true);
		// WEAPONS END //

		// WEAPONS NON COMBAT //
		nonCombatBeginner_bow = new Sprite(new Texture("weapons/beginnerBow.png"));
		//nonCombatBeginner_bow.flip(true, true);
		nonCombatBeginner_staff = new Sprite(new Texture("weapons/beginnerStaff.png"));
		nonCombatBeginner_staff.flip(true, true);
		nonCombatBeginner_sword = new Sprite(new Texture("weapons/sword.png"));
		nonCombatBeginner_sword.flip(true, false);

		nonCombatBatBowFront = new Sprite(new Texture("weapons/BatBowFront.png"));
		//nonCombatBatBowFront.flip(false, true);
		nonCombatBatStaffFront = new Sprite(new Texture("weapons/BatStaffFront.png"));
		nonCombatBatStaffFront.flip(false, true);
		nonCombatBatSwordFront = new Sprite(new Texture("weapons/BatSwordFront.png"));
		nonCombatBatSwordFront.flip(true, false);

		nonCombatBatBowBack = new Sprite(new Texture("weapons/BatBowBack.png"));
		//nonCombatBatBowBack.flip(false, true);
		nonCombatBatStaffBack = new Sprite(new Texture("weapons/BatStaffBack.png"));
		nonCombatBatStaffBack.flip(false, true);
		nonCombatBatSwordBack = new Sprite(new Texture("weapons/BatSwordBack.png"));
		nonCombatBatSwordBack.flip(true, false);

		nonCombatKingBatBowFront = new Sprite(new Texture("weapons/KingBatBowFront.png"));
		//nonCombatKingBatBowFront.flip(true, true);
		nonCombatKingBatStaffFront = new Sprite(new Texture("weapons/KingBatStaffFront.png"));
		nonCombatKingBatStaffFront.flip(false, true);
		nonCombatKingBatSwordFront = new Sprite(new Texture("weapons/KingBatSwordFront.png"));
		nonCombatKingBatSwordFront.flip(true, false);

		nonCombatKingBatBowBack = new Sprite(new Texture("weapons/KingBatBowBack.png"));
		//nonCombatKingBatBowBack.flip(true, true);
		nonCombatKingBatStaffBack = new Sprite(new Texture("weapons/KingBatStaffBack.png"));
		nonCombatKingBatStaffBack.flip(false, true);
		nonCombatKingBatSwordBack = new Sprite(new Texture("weapons/KingBatSwordBack.png"));
		nonCombatKingBatSwordBack.flip(true, false);

		nonCombatBeginnerSwordBack = new Sprite(new Texture("weapons/swordBack.png"));
		nonCombatBeginnerSwordBack.flip(true, false);
		nonCombatBeginnerSwordFront = new Sprite(new Texture("weapons/swordFront.png"));
		nonCombatBeginnerSwordFront.flip(true, false);
		nonCombatBeginnerBowBack = new Sprite(new Texture("weapons/beginnerBowBack.png"));
		//nonCombatBeginnerBowBack.flip(false, true);
		nonCombatBeginnerBowFront = new Sprite(new Texture("weapons/beginnerBowFront.png"));
		//nonCombatBeginnerBowFront.flip(false, true);
		nonCombatBeginnerStaffBack = new Sprite(new Texture("weapons/BeginnerStaffBack.png"));
		nonCombatBeginnerStaffBack.flip(false, true);
		nonCombatBeginnerStaffFront = new Sprite(new Texture("weapons/BeginnerStaffFront.png"));
		nonCombatBeginnerStaffFront.flip(false, true);
		// WEAPONS NON COMBAT END //

		// HELMETS //
		ironHelmetFront = new Sprite(new Texture("helmet/ironHelmetFront.png"));
		ironHelmetFront.flip(true, true);
		ironHelmetBack = new Sprite(new Texture("helmet/ironHelmetBack.png"));
		ironHelmetBack.flip(true, true);
		// HELMETS END //
		
		// LEGS //
		beginnerLegsIdleBack = new Sprite(new Texture("legs/beginnerLegsIdleBack.png"));
		beginnerLegsIdleBack.flip(true, true);
		beginnerLegsIdleFront = new Sprite(new Texture("legs/beginnerLegsIdleFront.png"));
		beginnerLegsIdleFront.flip(true, true);

		beginnerLegsWalkFrontAnim = new Animation(0.10f,
				new Sprite(new Texture("legs/beginnerLegsFront1.png")),
				new Sprite(new Texture("legs/beginnerLegsFront2.png")));
		beginnerLegsWalkFrontAnim.setPlayMode(Animation.PlayMode.LOOP);
		beginnerLegsWalkFront = new AnimatedSprite(beginnerLegsWalkFrontAnim);
		beginnerLegsWalkFront.flipFrames(true, true);

		beginnerLegsWalkBackAnim = new Animation(0.10f,
				new Sprite(new Texture("legs/beginnerLegsBack1.png")),
				new Sprite(new Texture("legs/beginnerLegsBack2.png")));
		beginnerLegsWalkBackAnim.setPlayMode(Animation.PlayMode.LOOP);
		beginnerLegsWalkBack = new AnimatedSprite(beginnerLegsWalkBackAnim);
		beginnerLegsWalkBack.flipFrames(true, true);
		// LEGS END //

		// BODY //
		beginnerBodyBack = new Sprite(new Texture("body/beginnerBodyBack.png"));
		beginnerBodyBack.flip(true, true);
		beginnerBodyFront = new Sprite(new Texture("body/beginnerBodyFront.png"));
		beginnerBodyFront.flip(true, true);
		BodyBack = new Sprite(new Texture("body/BodyBack.png"));
		BodyBack.flip(true, true);
		BodyFront = new Sprite(new Texture("body/BodyFront.png"));
		BodyFront.flip(true, true);
		// BODY END //

		// BACKPIECE //
		lavaCapeAnim = new Animation(1 / 8f, new Sprite(new Texture("backpiece/lava_cape1.png")),
				new Sprite(new Texture("backpiece/lava_cape2.png")),
				new Sprite(new Texture("backpiece/lava_cape3.png")));
		lavaCapeAnim.setPlayMode(Animation.PlayMode.LOOP);
		lavaCape = new AnimatedSprite(lavaCapeAnim);
		lavaCape.flipFrames(true, true);
		lavaCapeImage = new Sprite(new Texture("backpiece/lava_cape1.png"));
		lavaCapeImage.flip(true, true);
		// BACKPIECE END //

		// ENEMY SKILLS //
		greenFireBallAnim = new Animation(1 / 8f,
				new Sprite(new Texture("enemySkills/greenFireBall1.png")),
				new Sprite(new Texture("enemySkills/greenFireBall2.png")),
				new Sprite(new Texture("enemySkills/greenFireBall3.png")));
		greenFireBallAnim.setPlayMode(Animation.PlayMode.LOOP);
		greenFireBall = new AnimatedSprite(greenFireBallAnim);
		gFireBall = new Sprite(new Texture("enemySkills/greenFireBall2.png"));
		gFireBall.flip(true, true);
		// ENEMY SKILLS END //

		// SKILLS //
		waterSplashTexture = new Sprite(new Texture("skills/waterProjectile.png"));
		waterSplashTexture.flip(true, true);

		lightningStrikeTexture = new Sprite(new Texture("skills/lightningStrike1.png"));
		lightningStrikeTexture.flip(true, true);

		fireBall = new Sprite(new Texture("effects/explosion3.png"));
		fireBall.flip(true, true);

		arrowUp = new Sprite(new Texture("skills/arrow.png"));
		arrowUp.flip(true, true);

		arrowDown = new Sprite(new Texture("skills/arrow.png"));

		arrowLeft = new Sprite(new Texture("skills/arrowSide.png"));

		arrowRight = new Sprite(new Texture("skills/arrowSide.png"));

		aoeFreeze = new Sprite(new Texture("skills/aoeFreeze.png"));
		cleave = new Sprite(new Texture("skills/Cleave.png"));
		cleave.flip(true, true);

		lavaCarpet = new Sprite(new Texture("skills/lavaCarpet.png"));
		lavaCarpet.flip(true, true);
		lavaCarpetSide = new Sprite(new Texture("skills/lavaCarpetSide.png"));
		lavaCarpetSide.flip(true, true);
		
		coolDown = new Sprite(new Texture("skills/coolDown.png"));
		coolDown.flip(true, true);
		lock = new Sprite(new Texture("skills/lock.png"));
		lock.flip(true, true);
		
		burn = new Sprite(new Texture("skills/burn.png"));
		burn.flip(true, true);
		
		// SKILLS END //

		// SKILLICONS //
		fireBallIcon = new Sprite(new Texture("effects/explosion3.png"));
		fireBallIcon.flip(true, true);
		arrowIcon = new Sprite(new Texture("skillIcons/arrowIcon.png"));
		arrowIcon.flip(true, true);
		freezeIcon = new Sprite(new Texture("skillIcons/freezeIcon.png"));
		freezeIcon.flip(true, true);
		cleaveIcon = new Sprite(new Texture("skills/Cleave.png"));
		cleaveIcon.flip(true, true);
		healIcon = new Sprite(new Texture("skillIcons/heal.png"));
		healIcon.flip(true, true);
		punchIcon = new Sprite(new Texture("skillIcons/punch.png"));
		punchIcon.flip(false, true);
		// SKILLICONS END //

		// OTHER //
		combat = new Sprite(new Texture("icon/sword.png"));
		combat.flip(true, true);
		target = new Sprite(new Texture("other/target.png"));
		target.flip(true, true);
		// OTHER END //

		// ANIMATIONS //
		explosionAnim = new Animation(1 / 8f, new Sprite(new Texture("effects/explosion1.png")),
				new Sprite(new Texture("effects/explosion2.png")),
				new Sprite(new Texture("effects/explosion3.png")),
				new Sprite(new Texture("effects/explosion4.png")));
		explosionAnim.setPlayMode(Animation.PlayMode.LOOP);
		explosion = new AnimatedSprite(explosionAnim);

		bleedingAnim = new Animation(1 / 4f, new Sprite(new Texture("effects/bleeding1.png")),
				new Sprite(new Texture("effects/bleeding2.png")),
				new Sprite(new Texture("effects/bleeding3.png")),
				new Sprite(new Texture("effects/bleeding4.png")));
		bleedingAnim.setPlayMode(Animation.PlayMode.LOOP);
		bleeding = new AnimatedSprite(bleedingAnim);

		waterSplashAnim = new Animation(1 / 8f, new Sprite(new Texture("effects/waterSplash1.png")),
				new Sprite(new Texture("effects/waterSplash2.png")),
				new Sprite(new Texture("effects/waterSplash3.png")),
				new Sprite(new Texture("effects/waterSplash4.png")));
		waterSplashAnim.setPlayMode(Animation.PlayMode.LOOP);
		waterSplash = new AnimatedSprite(waterSplashAnim);

		lightningStrikeAnim = new Animation(1 / 8f, new Sprite(new Texture("skills/lightningStrike1.png")),
				new Sprite(new Texture("skills/lightningStrike2.png")),
				new Sprite(new Texture("skills/lightningStrike3.png")));
		lightningStrikeAnim.setPlayMode(Animation.PlayMode.LOOP);
		lightningStrike = new AnimatedSprite(lightningStrikeAnim);

		rainingAnim = new Animation(1 / 8f, new Sprite(new Texture("weather/raining1.png")),
				new Sprite(new Texture("weather/raining2.png")));
		rainingAnim.setPlayMode(Animation.PlayMode.LOOP);
		raining = new AnimatedSprite(rainingAnim);

		// ANIMATIONS END //

		// BORDERS //
			treeBorderUp = new Sprite(new Texture("borders/treeBorderUp.png"));
			treeBorderUp.flip(false, true);
			treeBorderDown = new Sprite(new Texture("borders/treeBorderDown.png"));
			treeBorderDown.flip(false, true);
			treeBorderLeft = new Sprite(new Texture("borders/treeBorderLeft.png"));
			treeBorderLeft.flip(false, true);
			treeBorderRight = new Sprite(new Texture("borders/treeBorderRight.png"));
			treeBorderRight.flip(false, true);
		// BORDERS END //
			
		// CURRENCY //
			coins = new Sprite(new Texture("currency/coins.png"));
			coins.flip(false, true);
		// CURRENCY END //
		
	}
}
