/**
 *  JacketPotatoRecipe is a recipe in the game.
 */
package Recipe;

import Ingredients.Cheese;
import Ingredients.Potato;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;


/**
 * The JacketPotatoRecipe class is a subclass of the Recipe class and
 * represents a burger dish in the kitchen game. It holds an ArrayList
 * of ingredients needed to make a burger and a Texture of the completed
 * dish image.
 * <p>
 * The ingredients in the ArrayList consist of a {@link Potato}
 * and a {@link Cheese}.
 */
public class JacketPotatoRecipe extends Recipe{

    private static final int DEFAULT_COOKTIME = 2;

    /**
     * Constructor for the JacketPotatoRecipe class.
     */
    public JacketPotatoRecipe() {
        super.ingredients = new ArrayList<>();
        super.amIReady = false;
        super.cookTime = DEFAULT_COOKTIME;
        ingredients.add(new Potato(0, 0));
        ingredients.add(new Cheese(0, 0));
        completedImg = new Texture("Food/Jacket_Potato.png");
    }
}
