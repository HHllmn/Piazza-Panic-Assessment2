package Recipe;

import Ingredients.*;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;


/**

 The PizzaRecipe class is a subclass of the Recipe class and represents a burger dish in the kitchen game.
 It holds an ArrayList of ingredients needed to make a pizza and a Texture of the completed dish image.
 The ingredients in the ArrayList consist of a {@link Bun} and a {@link Steak}.
 */


public class PizzaRecipe extends Recipe{

    public PizzaRecipe(){
        super.ingredients = new ArrayList<>();
        super.amIReady = false;
        super.cookTime = 2;
        ingredients.add(new Dough(0,0));
        ingredients.add(new Tomato(0,0));
        ingredients.add(new Cheese(0,0));
        completedImg = new Texture("Food/Pizza.png");
    }
}
