package Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.team13.piazzapanic.MainGame;

/**
 * The `InteractiveTileObject` class is designed to be extended.
 * It is used to represent a station for producing potato in the game.
 */
public abstract class InteractiveTileObject {

    protected final Fixture fixture;
    protected final BodyDef bdefNew;

    /**
     * Constructor for the class, initialises b2bodies.
     *
     * @param world The playable world.
     * @param map The tiled map.
     * @param bdef The body definition of a tile.
     * @param rectangle Rectangle shape.
     */
    public InteractiveTileObject(final World world,
                                 final TiledMap map,
                                 final BodyDef bdef,
                                 final Rectangle rectangle) {

        bdefNew = bdef;

        Body b2body = world.createBody(bdef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox((rectangle.getWidth() / 2f) / MainGame.PPM, (rectangle.getHeight() / 2f) / MainGame.PPM);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        fixture = b2body.createFixture(fdef);
    }
}
