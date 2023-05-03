package Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * The ChoppingBoard class extends the InteractiveTileObject class.
 * <p>
 * This class is used to define a chopping board object in the game that can chop up steak into a patty and
 * to cut up fruit and vegetables
 */
public class ChoppingBoard extends InteractiveTileObject {

    /**
     * Constructor for BunsStation.
     * Creates a new BunsStation with a Box2D body and fixture.
     *
     * @param world The playable world.
     * @param map The tiled map.
     * @param bdef The body definition of a tile.
     * @param rectangle Rectangle shape.
     */
    public ChoppingBoard(World world, TiledMap map, BodyDef bdef, Rectangle rectangle) {
        super(world, map, bdef, rectangle);
        fixture.setUserData(this);
    }

    /**
     * Gets x (in this case a bun) from the station.
     *
     * @return A float x coordinate.
     */
    public float getX(){
        return super.bdefNew.position.x;
    }

    /**
     * Gets y (in this case a bun) from the station.
     *
     * @return A float y coordinate.
     */
    public float getY(){
        return super.bdefNew.position.y;
    }
}
