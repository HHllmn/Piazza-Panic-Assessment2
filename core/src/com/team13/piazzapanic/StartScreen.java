package com.team13.piazzapanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * This class implements the `Screen` interface and represents the start screen of the game.
 */
public class StartScreen implements Screen {
    public final MainGame game; //Changed from private to public for testing
    public Texture backgroundImage = new Texture("situationImage.png");//Changed from private to public for testing
    public Sprite backgroundSprite;//Changed from private to public for testing
    public final OrthographicCamera camera;//Changed from private to public for testing
    public final Viewport viewport;//Changed from private to public for testing

    /**
     * Constructor for StartScreen.
     *
     * @param game the game object.
     */
    public StartScreen(MainGame game) {
        this.game = game;
        if (MainGame.GameMode == MainGame.Mode.SITUATION)backgroundImage = new Texture("situationImage.png");
        else if (MainGame.GameMode == MainGame.Mode.ENDLESS && MainGame.difficulty == 1)backgroundImage = new Texture("endlessImage1.png");
        else if (MainGame.GameMode == MainGame.Mode.ENDLESS && MainGame.difficulty == 2)backgroundImage = new Texture("endlessImage2.png");
        else if (MainGame.GameMode == MainGame.Mode.ENDLESS && MainGame.difficulty == 3)backgroundImage = new Texture("endlessImage3.png");
        backgroundSprite = new Sprite(backgroundImage);
        camera = new OrthographicCamera();
        viewport = new FitViewport(MainGame.V_WIDTH, MainGame.V_HEIGHT, camera);
    }

    /**
     * Method called when the screen is shown.
     * Initializes the sprite and camera position.
     */
    @Override
    public void show() {
        if (MainGame.GameMode == MainGame.Mode.SITUATION)backgroundImage = new Texture("situationImage.png");
        else if (MainGame.GameMode == MainGame.Mode.ENDLESS && MainGame.difficulty == 1)backgroundImage = new Texture("endlessImage1.png");
        else if (MainGame.GameMode == MainGame.Mode.ENDLESS && MainGame.difficulty == 2)backgroundImage = new Texture("endlessImage2.png");
        else if (MainGame.GameMode == MainGame.Mode.ENDLESS && MainGame.difficulty == 3)backgroundImage = new Texture("endlessImage3.png");
        backgroundSprite = new Sprite(backgroundImage);
        backgroundSprite.setSize(MainGame.V_WIDTH, MainGame.V_HEIGHT);
        backgroundSprite.setPosition(0, 0);
        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
    }

    /**
     * Method to render the screen.
     * Clears the screen and draws the background sprite.
     *
     * @param delta the time in seconds since the last frame.
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.5f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        backgroundSprite.draw(game.batch);
        game.batch.end();
    }

    /**
     * Method called when the screen is resized.
     * Updates the viewport and camera position.
     *
     * @param width the new screen width.
     * @param height the new screen height.
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
    }
    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    /**
     * Dispose method that is called when the screen is no longer used.
     * It is used to free up resources and memory that the screen was using.
     */
    @Override
    public void dispose() {
        backgroundImage.dispose();
    }
}
