package Sprites;

import Ingredients.Dough;
import Ingredients.Ingredient;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * The `DoughStation` class extends the `InteractiveTileObject` class.
 * It is used to represent a station for producing potato in the game.
 */
public class DoughStation extends InteractiveTileObject {
    /**
     * Constructs a DoughStation.
     *
     * @param world the world where the DoughStation will be located
     * @param map the TiledMap that the DoughStation is in
     * @param bdef the BodyDef for the physics of the DoughStation
     * @param rectangle the rectangle representing the boundaries of the DoughStation
     */
    public DoughStation(World world, TiledMap map, BodyDef bdef, Rectangle rectangle) {
        super(world, map, bdef, rectangle);
        fixture.setUserData(this);
    }

    /**
     * Returns the ingredient Potato.
     *
     * @return a Potato object
     */
    public Ingredient getIngredient(){
        return (new Dough(2,0));
    }
}


