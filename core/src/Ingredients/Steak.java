/**
 *  Steak is an ingredient in the game.
 */
package Ingredients;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Steak extends Ingredient {

    /**
     * The Steak class represents a specific type of ingredient in the
     * game, specifically steak. It extends the {@link Ingredient}
     * class and has a preparation time and cooking time. The Steak
     * class sets up an ArrayList of textures for its different skins.
     */

    public static final int DEFAULT_PREPTIME = 2;
    public static final int DEFAULT_COOKTIME = 3;


    /**
     * Constructs a new Steak object with the specified preparation and cooking times.
     *
     * @param prepareTime The time required to prepare the ingredient.
     * @param cookTime The time required to cook the ingredient.
     */
    public Steak(float prepareTime, float cookTime) {
        super(prepareTime, cookTime);
        super.tex = new ArrayList<>();
        super.tex.add(new Texture("Food/Meat.png"));
        super.tex.add(new Texture("Food/Patty.png"));
        super.tex.add(new Texture("Food/Cooked_patty.png"));
    }

    /**
     * Constructs a new Bun object with the default preparation and cooking times.
     */
    public Steak() {
        super(DEFAULT_PREPTIME, DEFAULT_COOKTIME);
        super.tex = new ArrayList<>();
        super.tex.add(new Texture("Food/Meat.png"));
        super.tex.add(new Texture("Food/Patty.png"));
        super.tex.add(new Texture("Food/Cooked_patty.png"));
    }
}
