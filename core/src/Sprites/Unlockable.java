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
public class Unlockable extends Sprite {
    /**
     * The image representing this unlockable.
     */
    public Texture unlockableImg;
    public int lockedId;
    public int x;
    public int y;

    /**
     * Constructor for the `Unlockable` class.
     *
     * @param unlockableImg The image representing this order.
     */
    public Unlockable(Texture unlockableImg, int id, int x, int y) {
        this.unlockableImg = unlockableImg;
        this.lockedId = id;
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
        Sprite sprite = new Sprite(unlockableImg);
        float adjustedX = x  / MainGame.PPM;
        float adjustedY = y / MainGame.PPM;
        sprite.setBounds(adjustedX, adjustedY, 16 / MainGame.PPM, 16 / MainGame.PPM);
        sprite.draw(batch);
    }

    //public void create(float x, float y, SpriteBatch batch, int newY) {
    //    Sprite sprite = new Sprite(unlockableImg);
    //    float adjustedX = x + ((float) 1.05 / MainGame.PPM);
    //    float adjustedY = y - ((float) 10 / MainGame.PPM);
    //    sprite.setBounds(adjustedX, adjustedY, 16 / MainGame.PPM, 16 / MainGame.PPM);
    //    sprite.draw(batch);
    //}

    //private void addTime(){
    //    Label timeLabel;
    //    float fontX = 0.5F;
    //    float fontY = 0.3F;
    //    BitmapFont font = new BitmapFont();
    //    timeLabel = new Label(String.format(String.valueOf(PlayScreen.timeSeconds - this.timeMade)), new Label.LabelStyle(font, Color.WHITE));
    //    //timeLabel.draw(batch,1);
    //}

}