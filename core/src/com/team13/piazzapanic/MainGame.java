package com.team13.piazzapanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;

public class MainGame extends Game {

	/**
	 * MainGame class is the central class of the game that creates and manages the two screens, PlayScreen and StartScreen.
	 *
	 * Class Members:
	 *     V_WIDTH (int): Width of the view.
	 *     V_HEIGHT (int): Height of the view.
	 *     TILE_SIZE (int): Size of the tile.
	 *     PPM (float): Pixels per meter.
	 *     batch (SpriteBatch): Instance of SpriteBatch.
	 *     isPlayScreen (bool): Flag indicating whether the PlayScreen is displayed or not.
	 *     playScreen (PlayScreen): Instance of PlayScreen.
	 *     startScreen (StartScreen): Instance of StartScreen.
	 *
	 * Methods:
	 *     __init__: Initializes the MainGame class.
	 *     create: Creates the instances of StartScreen and PlayScreen and initializes the SpriteBatch instance.
	 *     render: Renders the StartScreen or PlayScreen based on the value of isPlayScreen flag.
	 * 	   dispose: Releases resources used by the MainGame class.
	 */
	public static final int V_WIDTH = 210;
	public static final int V_HEIGHT = 160;
	public static final int TILE_SIZE = 16;

	public static final float PPM = 100;
	public SpriteBatch batch;
	public boolean isPlayScreen;
	public boolean isStartScreen;

	private PauseScreen pauseScreen;
	public static StartScreen startScreen;
	private PlayScreen playScreen;

	public enum Mode{
		SITUATION,
		ENDLESS
	}
	public static Mode GameMode = Mode.SITUATION;

	public MainGame(){
		isStartScreen = true;
		isPlayScreen = false;

	}
	@Override
	public void create() {
		batch = new SpriteBatch();
		pauseScreen = new PauseScreen(this);
		playScreen = new PlayScreen(this);
		startScreen = new StartScreen((this));
	}

	@Override
	public void render() {
		super.render();
		if (Gdx.input.isKeyJustPressed((Input.Keys.M))) {
			if(GameMode == Mode.SITUATION) GameMode = Mode.ENDLESS;
			else if (GameMode == Mode.ENDLESS) GameMode = Mode.SITUATION;
			PlayScreen.hud = new HUD(batch);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)){
			if (isStartScreen == true) {
				isStartScreen = false;
				isPlayScreen = false;
			}
				isPlayScreen = !isPlayScreen;
		}
		if (isStartScreen){
			setScreen(startScreen);
		}
		else if (isPlayScreen) {
			setScreen(playScreen);
		} else {
			setScreen(pauseScreen);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
	}
}