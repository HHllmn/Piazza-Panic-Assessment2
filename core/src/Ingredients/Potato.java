/**
 *  Potato is an ingredient in the game.
 */
package Ingredients;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * The Potato class represents a specific type of ingredient in the game,
 * specifically potatoes. It extends the {@link Ingredient} class and
 * has a preparation time and cooking time. The Potato class sets up
 * an ArrayList of textures for its different skins.
 */
public class Potato extends Ingredient {

    /**
     * Constructs a new Potato object with the specified preparation and
     * cooking times.
     *
     * @param prepareTime The time required to prepare the ingredient.
     * @param cookTime The time required to cook the ingredient.
     */
    public Potato(final float prepareTime, final float cookTime) {
        super(prepareTime, cookTime);
        super.tex = new ArrayList<>();
        super.tex.add(new Texture("Food/Potato.png"));
        super.tex.add(new Texture("Food/Cut_potato.png"));
        super.tex.add(new Texture("Food/Baked_potato.png"));

    }
}
