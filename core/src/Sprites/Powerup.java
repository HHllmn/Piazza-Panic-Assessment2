package Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.team13.piazzapanic.MainGame;

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
    private int x;
    private int y;

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

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    /**
     * Constructor for the `PowerUp` class.
     *
     * @param powerupImg The image representing this PowerUp.
     * @param id The ID of this PowerUp.
     * @param x The x coordinate of this PowerUp.
     * @param y The y coordinate of this PowerUp.
     * @param type The type of PowerUp.
     */
    public Powerup(final Texture powerupImg,
                   final int id,
                   final int x,
                   final int y,
                   final PowerUpType type) {
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
    public void create(final float x, final float y, final SpriteBatch batch) {
        Sprite sprite = new Sprite(powerupImg);
        float adjustedX = x / MainGame.PPM;
        float adjustedY = y / MainGame.PPM;
        sprite.setBounds(adjustedX, adjustedY, 16 / MainGame.PPM, 16 / MainGame.PPM);
        sprite.draw(batch);
    }

}
