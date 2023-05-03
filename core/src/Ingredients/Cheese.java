package Ingredients;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Cheese extends Ingredient{

    /**
     * The Cheese class represents a specific type of ingredient in the game, specifically tomatoes.
     * It extends the {@link Ingredient} class and has a preparation time and cooking time.
     * The Cheese class sets up an ArrayList of textures for its different skins.
     */

    public Cheese(float prepareTime, float cookTime) {
        super(prepareTime, cookTime);
        super.tex = new ArrayList<>();
        tex.add(new Texture("Food/Cheese.png"));
        tex.add(new Texture("Food/Grated_cheese.png"));

    }
}
