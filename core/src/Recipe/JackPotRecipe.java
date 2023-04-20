package Recipe;

import Ingredients.Bun;
import Ingredients.Cheese;
import Ingredients.Potato;
import Ingredients.Steak;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;


/**

 The BurgerRecipe class is a subclass of the Recipe class and represents a burger dish in the kitchen game.
 It holds an ArrayList of ingredients needed to make a burger and a Texture of the completed dish image.
 The ingredients in the ArrayList consist of a {@link Bun} and a {@link Steak}.
 */


public class JackPotRecipe extends Recipe{

    public JackPotRecipe(){
        super.ingredients = new ArrayList<>();
        ingredients.add(new Potato(0,0));
        ingredients.add(new Cheese(0,0));
        completedImg = new Texture("Food/JacketPotato.png");
    }
}