package Sprites;

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


    /**
     *  Integer that states the ID of the oven.
     */
    private final int unlockableId;

    /**
     * Boolean that states if the oven has been purchased
     * */
    private boolean isPurchased;

    /**
     * Constructs a DoughStation.
     *
     * @param world the world where the DoughStation will be located.
     * @param map the TiledMap that the DoughStation is in.
     * @param bdef the BodyDef for the physics of the DoughStation.
     * @param rectangle the boundary rectangle of DoughStation.
     * @param id sets the id of the oven to identify it.
     */
    public Oven(final World world,
                final TiledMap map,
                final BodyDef bdef,
                final Rectangle rectangle,
                final int id) {
        super(world, map, bdef, rectangle);
        unlockableId = id;
        isPurchased = false;
        fixture.setUserData(this);
    }

    public int getOvenId() { return (unlockableId); }

    /**
     * Returns the boolean isPurchased.
     *
     * @return a boolean variable
     */
    public boolean getIsPurchased() {
        return (isPurchased);
    }

    public void setPurchased() {
        isPurchased = true;
    }

    public float getX() {
        return super.bdefNew.position.x;
    }

    public float getY() {
        return super.bdefNew.position.y;
    }
}
