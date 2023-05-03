package Sprites;

import Ingredients.Ingredient;
import Ingredients.Onion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * OnionStation is a class extending InteractiveTileObject representing
 * an Onion ingredient station. It creates an OnionStation object with world,
 * map, body definition and rectangle as parameters. The fixture of the body
 * is then set with the instance of the object as its user data. The class
 * also provides a method getIngredient() that returns a new Onion instance.
 */

public class OnionStation extends InteractiveTileObject {

    /**
     * Constructs a OnionStation.
     *
     * @param world the world where the DoughStation will be located
     * @param map the TiledMap that the DoughStation is in
     * @param bdef the BodyDef for the physics of the DoughStation
     * @param rectangle the rectangle representing the boundaries of the DoughStation
     */
    public OnionStation(final World world,
                        final TiledMap map,
                        final BodyDef bdef,
                        final Rectangle rectangle) {
        super(world, map, bdef, rectangle);
        fixture.setUserData(this);

    }

    /**
     * Returns the ingredient Onion.
     *
     * @return a Potato object
     */
    public Ingredient getIngredient(){
        return new Onion(2, 0);
    }
}
