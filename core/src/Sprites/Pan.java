package Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Pan is a concrete class that extends the {@link InteractiveTileObject}
 * class. Pan is a class extending InteractiveTileObject representing a
 * Pan in the game where the chef can cook steaks and toast buns.
 */

public class Pan extends InteractiveTileObject {

    /**
     * Constructor for BunsStation.
     * Creates a new BunsStation with a Box2D body and fixture.
     *
     * @param world The playable world.
     * @param map The tiled map.
     * @param bdef The body definition of a tile.
     * @param rectangle Rectangle shape.
     */
    public Pan(final World world,
               final TiledMap map,
               final BodyDef bdef,
               final Rectangle rectangle) {
        super(world, map, bdef, rectangle);
        fixture.setUserData(this);
    }

    /**
     * Gets x coordinate from the station.
     *
     * @return A new Bun object.
     */
    public float getX() {
        return super.bdefNew.position.x;
    }

    /**
     * Gets y coordinate from the station.
     *
     * @return A new Bun object.
     */
    public float getY() {
        return super.bdefNew.position.y;
    }
}
