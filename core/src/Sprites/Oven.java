package Sprites;

import Ingredients.Ingredient;
import Ingredients.Potato;
import Recipe.Recipe;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Oven is a concrete class that extends the {@link InteractiveTileObject} class.
 * Oven is a class extending InteractiveTileObject representing a Oven in the game where the chef can cook steaks
 * and toast Oven
 */

public class Oven extends InteractiveTileObject {


    /** Boolean that states if the oven has been purchased */

    private boolean isPurchased;
    public Oven(World world, TiledMap map, BodyDef bdef, Rectangle rectangle) {
        super(world, map, bdef, rectangle);
        isPurchased = false;
        fixture.setUserData(this);
    }

    /**
     * Returns the boolean isPurchased.
     *
     * @return a boolean variable
     */
    public boolean getIsPurchased(){
        return (isPurchased);
    }

    public void setPurchased(){
        isPurchased = true;
    }

    public float getX(){
        return super.bdefNew.position.x;
    }

    public float getY(){
        return super.bdefNew.position.y;
    }
}
