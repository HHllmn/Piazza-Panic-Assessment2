package Sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.team13.piazzapanic.MainGame;
import com.team13.piazzapanic.PlayScreen;

/**
 * The `Order` class extends the `Sprite` class and represents a recipe order
 * in the game.
 */
public class Powerup extends Sprite {
    /**
     * The image representing this Powerup.
     */
    public Texture powerupImg;
    public int powerUpId;

    private PowerUpType powerUpType;

    public enum PowerUpType {
        REPUTATION,
        SPEED,
        COOK,
        MONEY,
        PATIENCE
    }

    public PowerUpType getPowerUpType() {
        return powerUpType;
    }

    public int x;
    public int y;

    /**
     * Constructor for the `PowerUp` class.
     *
     * @param powerupImg The image representing this PowerUp.
     */
    public Powerup(Texture powerupImg, int id, int x, int y, PowerUpType type) {
        this.powerupImg = powerupImg;
        this.powerUpId = id;
        this.powerUpType = type;
        this.x = x;
        this.y = y;
    }

    /**
     * Creates the order image and adds it to the given `SpriteBatch`.
     *
     * @param x     The x coordinate of the order image.
     * @param y     The y coordinate of the order image.
     * @param batch The `SpriteBatch` to add the order image to.
     */
    public void create(float x, float y, SpriteBatch batch) {
        Sprite sprite = new Sprite(powerupImg);
        float adjustedX = x / MainGame.PPM;
        float adjustedY = y / MainGame.PPM;
        sprite.setBounds(adjustedX, adjustedY, 16 / MainGame.PPM, 16 / MainGame.PPM);
        sprite.draw(batch);
    }

}