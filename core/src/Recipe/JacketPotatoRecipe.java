package Recipe;

import ingredients.Bun;
import ingredients.Cheese;
import ingredients.Potato;
import ingredients.Steak;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;


/**

 The JacketPotatoRecipe class is a subclass of the Recipe class and represents a burger dish in the kitchen game.
 It holds an ArrayList of ingredients needed to make a burger and a Texture of the completed dish image.
 The ingredients in the ArrayList consist of a {@link Bun} and a {@link Steak}.
 */


public class JacketPotatoRecipe extends Recipe{

    public JacketPotatoRecipe(){
        super.ingredients = new ArrayList<>();
        super.amIReady = false;
        super.cookTime = 2;
        ingredients.add(new Potato(0,0));
        ingredients.add(new Cheese(0,0));
        completedImg = new Texture("Food/Jacket_Potato.png");
    }
}