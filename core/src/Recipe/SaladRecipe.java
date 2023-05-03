/**
 *  SaladRecipe is a recipe in the game.
 */
package Recipe;

import Ingredients.Lettuce;
import Ingredients.Tomato;
import Ingredients.Onion;
import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;

/**
 * The SaladRecipe class is a subclass of the Recipe class.
 * It holds an ArrayList of ingredients that makes up a salad
 * dish, and the texture of the completed salad dish.
 * <p>
 * The salad dish consists of {@link Ingredients.Lettuce},
 * {@link Ingredients.Tomato} and {@link Ingredients.Onion} ingredients.
 */

/**
 * Constructor for the SaladRecipe class.
 */
public class SaladRecipe extends Recipe {
    public SaladRecipe() {
        super.ingredients = new ArrayList<>();
        super.amIReady = true;
        ingredients.add(new Lettuce(0, 0));
        ingredients.add(new Tomato(0, 0));
        ingredients.add(new Onion(0, 0));
        completedImg = new Texture("Food/Salad.png");
    }
}
