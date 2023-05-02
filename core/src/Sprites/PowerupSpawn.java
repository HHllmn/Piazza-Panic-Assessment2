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

public class PowerupSpawn extends InteractiveTileObject {


    /**
     *  Integer that states the ID of the oven.
     */
    private int powerupSpawnId;

    /**
     * Boolean that states if the oven has been purchased
     * */
    private boolean hasPowerup;

    public PowerupSpawn(World world, TiledMap map, BodyDef bdef, Rectangle rectangle, int id) {
        super(world, map, bdef, rectangle);
        powerupSpawnId = id;
        hasPowerup = false;
        fixture.setUserData(this);
    }

    public int getPowerupSpawnId() { return (powerupSpawnId); }

    /**
     * Returns the boolean isPurchased.
     *
     * @return a boolean variable
     */
    public boolean getHasPowerup(){
        return (hasPowerup);
    }

    public void setHasPowerup(){
        hasPowerup = true;
    }

    public float getX(){
        return super.bdefNew.position.x;
    }

    public float getY(){
        return super.bdefNew.position.y;
    }
}
