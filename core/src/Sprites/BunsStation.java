package Sprites;

import Ingredients.Bun;
import Ingredients.Ingredient;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class BunsStation extends InteractiveTileObject {
    public BunsStation(World world, TiledMap map, BodyDef bdef, Rectangle rectangle) {
        super(world, map, bdef, rectangle);
        fixture.setUserData(this);

    }
    public Ingredient getIngredient(){
        return new Bun(0,3);
    }
}

