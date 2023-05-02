package Recipe;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.team13.piazzapanic.MainGame;
import com.team13.piazzapanic.PlayScreen;

/**
 * The `Order` class extends the `Sprite` class and represents a recipe order
 * in the game.
 */
public class Order extends Sprite {
    /**
     * The `Recipe` object associated with this order.
     */
    public Recipe recipe;
    /**
     * A flag indicating whether the order has been completed.
     */
    public Boolean orderComplete;
    /**
     * The image representing this order.
     */
    public Texture orderImg;
    public float timeMade;
    Texture timerTex;
    Texture borderTexG, borderTexO, borderTexR;
    Rectangle rect;
    public static int orderTimeout = 40;
    float timeSince;
    Sprite timerSprite;



    /**
     * Constructor for the `Order` class.
     *
     * @param recipe   The `Recipe` object associated with this order.
     * @param orderImg The image representing this order.
     */
    public Order(Recipe recipe, Texture orderImg) {
        this.recipe = recipe;
        this.orderImg = orderImg;
        this.orderComplete = false;
        this.timeMade = PlayScreen.timeSecondsTotal;
        this.borderTexG = new Texture("borderTexG.png");
        this.borderTexO = new Texture("borderTexO.png");
        this.borderTexR = new Texture("borderTexR.png");
        this.timerTex = borderTexG;
        this.timeSince = 0;
        orderTimeout = orderTimeout - 12*(MainGame.difficulty -1);
    }

    /**
     * Creates the order image and adds it to the given `SpriteBatch`.
     *
     * @param x     The x coordinate of the order image.
     * @param y     The y coordinate of the order image.
     * @param batch The `SpriteBatch` to add the order image to.
     */
    public void create(float x, float y, SpriteBatch batch) {
        Sprite sprite = new Sprite(orderImg);
        float adjustedX = x + (50 / MainGame.PPM);
        float adjustedY = y - (2 / MainGame.PPM);
        if (orderImg.toString().equals("Food/salad_recipe.png")) {
            sprite.setBounds(adjustedX, adjustedY, 53 / MainGame.PPM, 28 / MainGame.PPM);
            sprite.draw(batch);
        } else if (orderImg.toString().equals("Food/burger_recipe.png")) {
            sprite.setBounds(adjustedX, adjustedY, 33 / MainGame.PPM, 28 / MainGame.PPM);
            sprite.draw(batch);
        } else if (orderImg.toString().equals("Food/jacket_potato_recipe.png")) {
            sprite.setBounds(adjustedX, adjustedY, 53 / MainGame.PPM, 28 / MainGame.PPM);
            sprite.draw(batch);
        } else {
            sprite.setBounds(adjustedX, adjustedY, 53 / MainGame.PPM, 28 / MainGame.PPM);
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
        } else if (orderImg.toString().equals("Food/burger_recipe.png")) {
            sprite.setBounds(adjustedX, adjustedY, 33 / MainGame.PPM, 28 / MainGame.PPM);
            sprite.draw(batch);
        } else if (orderImg.toString().equals("Food/jacket_potato_recipe.png")) {
            sprite.setBounds(adjustedX, adjustedY, 53 / MainGame.PPM, 28 / MainGame.PPM);
            sprite.draw(batch);
        } else {
            sprite.setBounds(adjustedX, adjustedY, 53 / MainGame.PPM, 28 / MainGame.PPM);
            sprite.draw(batch);
        }
        float width = 53/MainGame.PPM;
        if (orderImg.toString().equals("Food/burger_recipe.png")) width = 33/MainGame.PPM;


        if (MainGame.GameMode == MainGame.Mode.ENDLESS) {
            timerSprite = new Sprite(timerTex);
            timeSince = PlayScreen.timeSecondsTotal - timeMade;
            if ((timeSince/orderTimeout) < 0.3) timerTex = borderTexG;
            else if ((timeSince/orderTimeout) < 0.6) timerTex = borderTexO;
            else timerTex = borderTexR;
            this.timerSprite.setBounds(adjustedX, adjustedY - (1/MainGame.PPM), width - (width*(timeSince/orderTimeout)), 2/MainGame.PPM);
            this.timerSprite.draw(batch);
        }
    }
}