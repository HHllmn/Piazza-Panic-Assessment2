/**
 *  Dough is an ingredient in the game.
 */
package Ingredients;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Dough extends Ingredient {

    /**
     * The Dough class represents a specific type of ingredient in the game,
     * specifically Dough. It extends the {@link Ingredient} class and has
     * a preparation time and cooking time. The Dough class sets up an
     * ArrayList of textures for its different skins.
     */

    public Dough(final float prepareTime, final float cookTime) {
        super(prepareTime, cookTime);
        super.tex = new ArrayList<>();
        tex.add(new Texture("Food/Dough.png"));
        tex.add(new Texture("Food/Dough_Rolled.png"));
        }
}
