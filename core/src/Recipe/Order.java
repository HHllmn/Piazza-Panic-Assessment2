package Recipe;

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
public class Order extends Sprite {
    /** The `Recipe` object associated with this order. */
    public Recipe recipe;
    /** A flag indicating whether the order has been completed. */
    public Boolean orderComplete;
    /** The image representing this order. */
    public Texture orderImg;
    public float timeMade;

    /**
     * Constructor for the `Order` class.
     *
     * @param recipe The `Recipe` object associated with this order.
     * @param orderImg The image representing this order.
     */
    public Order(Recipe recipe, Texture orderImg) {
        this.recipe = recipe;
        this.orderImg = orderImg;
        this.orderComplete = false;
        this.timeMade = PlayScreen.timeSeconds;
    }

    /**
     * Creates the order image and adds it to the given `SpriteBatch`.
     *
     * @param x The x coordinate of the order image.
     * @param y The y coordinate of the order image.
     * @param batch The `SpriteBatch` to add the order image to.
     */
    public void create(float x, float y, SpriteBatch batch) {
        Sprite sprite = new Sprite(orderImg);
        float adjustedX = x + (50 / MainGame.PPM);
        float adjustedY = y - (2 / MainGame.PPM);
        if (orderImg.toString().equals("Food/salad_recipe.png")) {
            sprite.setBounds(adjustedX, adjustedY, 53 / MainGame.PPM, 28 / MainGame.PPM);
            sprite.draw(batch);
        } else {
            sprite.setBounds(adjustedX, adjustedY, 33 / MainGame.PPM, 28 / MainGame.PPM);
            sprite.draw(batch);
        }
    }
    public void create(float x, float y, SpriteBatch batch, int newY) {
        Sprite sprite = new Sprite(orderImg);
        float adjustedX = x + (50 / MainGame.PPM);
        float adjustedY = y - ((2 + newY*30) / MainGame.PPM);
        if (orderImg.toString().equals("Food/salad_recipe.png")) {
            sprite.setBounds(adjustedX, adjustedY, 53 / MainGame.PPM, 28 / MainGame.PPM);
            sprite.draw(batch);
        } else {
            sprite.setBounds(adjustedX, adjustedY, 33 / MainGame.PPM, 28 / MainGame.PPM);
            sprite.draw(batch);
        }


    }

    private void addTime(){
        Label timeLabel;
        float fontX = 0.5F;
        float fontY = 0.3F;
        BitmapFont font = new BitmapFont();
        timeLabel = new Label(String.format(String.valueOf(PlayScreen.timeSeconds - this.timeMade)), new Label.LabelStyle(font, Color.WHITE));
        //timeLabel.draw(batch,1);
    }
}
