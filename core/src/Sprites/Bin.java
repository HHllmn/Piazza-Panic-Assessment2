/**
 *  Bin is a workstation in the game.
 */
package Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Bin is a concrete class that extends the {@link InteractiveTileObject}
 * class. It creates a bin object that interacts with other objects in
 * the game world.
 */
public class Bin extends InteractiveTileObject {

    /**
     * Constructor for Bin.
     * Creates a new Bin with a Box2D body and fixture.
     *
     * @param world The playable world.
     * @param map The tiled map.
     * @param bdef The body definition of a tile.
     * @param rectangle Rectangle shape.
     */
    public Bin(World world, TiledMap map, BodyDef bdef, Rectangle rectangle) {
        super(world, map, bdef, rectangle);
        fixture.setUserData(this);
    }
}
