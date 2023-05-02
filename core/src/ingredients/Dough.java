package ingredients;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Dough extends Ingredient{

    /**
     * The Tomato class represents a specific type of ingredient in the game, specifically tomatoes.
     * It extends the {@link Ingredient} class and has a preparation time and cooking time.
     * The Tomato class sets up an ArrayList of textures for its different skins.
     */

    public Dough(float prepareTime, float cookTime) {
        super(prepareTime, cookTime);
        super.tex = new ArrayList<>();
        tex.add(new Texture("Food/Dough.png"));
        tex.add(new Texture("Food/Dough_Rolled.png"));
        }
}
