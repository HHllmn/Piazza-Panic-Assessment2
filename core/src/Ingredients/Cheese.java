/**
 *  Cheese is an ingredient in the game.
 */
package Ingredients;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Cheese extends Ingredient{

    /**
     * The Cheese class represents a specific type of ingredient in the game,
     * specifically cheese. It extends the {@link Ingredient} class and has
     * a preparation time and cooking time. The Cheese class sets up an
     * ArrayList of textures for its different skins.
     */

    /**
     * Constructs a new Cheese object with the specified preparation and cooking times.
     *
     * @param prepareTime The time required to prepare the ingredient.
     * @param cookTime The time required to cook the ingredient.
     */
    public Cheese(final float prepareTime, final float cookTime) {
        super(prepareTime, cookTime);
        super.tex = new ArrayList<>();
        tex.add(new Texture("Food/Cheese.png"));
        tex.add(new Texture("Food/Grated_cheese.png"));
    }
}
