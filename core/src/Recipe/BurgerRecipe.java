/**
 *  BurgerRecipe is a recipe in the game.
 */
package Recipe;

import Ingredients.Bun;
import Ingredients.Steak;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;


/**
 * The BurgerRecipe class is a subclass of the Recipe class and represents
 * a burger dish in the kitchen game. It holds an ArrayList of ingredients
 * needed to make a burger and a Texture of the completed dish image.
 * <p>
 * The ingredients in the ArrayList consist of a {@link Ingredients.Bun}
 * and a {@link Ingredients.Steak}.
 */
public class BurgerRecipe extends Recipe {

    /**
     * Constructor for the BurgerRecipe class.
     */
    public BurgerRecipe() {
        super.ingredients = new ArrayList<>();
        super.amIReady = true;
        ingredients.add(new Bun(0, 0));
        ingredients.add(new Steak(0, 0));
        completedImg = new Texture("Food/Burger.png");
    }
}
