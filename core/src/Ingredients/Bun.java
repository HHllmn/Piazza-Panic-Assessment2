/**
 *  Bun is an ingredient in the game.
 */
package Ingredients;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Bun extends Ingredient {

    /**

     The Bun class represents a specific type of ingredient in the game,
     specifically the burger buns. It extends the {@link Ingredient}
     class and has a preparation time and cooking time. The Bun class
     sets the prepared flag to true in the constructor, and sets up an
     ArrayList of textures for its different skins.

     */


    public static final int DEFAULT_PREPTIME = 0;
    public static final int DEFAULT_COOKTIME = 3;

    /**
     * Constructs a new Bun object with the specified preparation and
     * cooking times.
     *
     * @param prepareTime The time required to prepare the ingredient.
     * @param cookTime The time required to cook the ingredient.
     */
    public Bun(final float prepareTime, final float cookTime) {
        super(prepareTime, cookTime);
        super.setPrepared();
        super.tex = new ArrayList<>();
        super.tex.add(null);
        super.tex.add(new Texture("Food/Burger_buns.png"));
        super.tex.add(new Texture("Food/Toasted_burger_buns.png"));
    }

    /**
     * Constructs a new Bun object with the default preparation and
     * cooking times.
     */
    public Bun() {
        super(DEFAULT_PREPTIME, DEFAULT_COOKTIME);
        super.setPrepared();
        super.tex = new ArrayList<>();
        super.tex.add(null);
        super.tex.add(new Texture("Food/Burger_buns.png"));
        super.tex.add(new Texture("Food/Toasted_burger_buns.png"));
    }
}
