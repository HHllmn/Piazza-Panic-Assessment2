package Sprites;

import Ingredients.Potato;
import Ingredients.Ingredient;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * The `PotatoStation` class extends the `InteractiveTileObject` class.
 * It is used to represent a station for producing potato in the game.
 */
public class PotatoStation extends InteractiveTileObject {
    /**
     * Constructs a PotatoStation.
     *
     * @param world the world where the PotatoStation will be located
     * @param map the TiledMap that the PotatoStation is in
     * @param bdef the BodyDef for the physics of the PotatoStation
     * @param rectangle the rectangle representing the boundaries of the PotatoStation
     */
    public PotatoStation(final World world,
                         final TiledMap map,
                         final BodyDef bdef,
                         final Rectangle rectangle) {
        super(world, map, bdef, rectangle);
        fixture.setUserData(this);
    }

    /**
     * Returns the ingredient Potato.
     *
     * @return a Potato object
     */
    public Ingredient getIngredient() {
        return (new Potato(2, 0));
    }
}


