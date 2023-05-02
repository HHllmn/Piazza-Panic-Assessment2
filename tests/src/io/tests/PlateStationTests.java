package io.tests;

import Ingredients.*;
import Ingredients.Ingredient;
import Sprites.PlateStation;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.team13.piazzapanic.MainGame;
import com.team13.piazzapanic.PlayScreen;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(GdxTestRunner.class)
public class PlateStationTests {
    PlayScreen screen = mock(PlayScreen.class);
    World world  = screen.world;
    TiledMap map = mock(TiledMap.class);
    BodyDef bdef = mock(BodyDef.class);
    Rectangle rectangle = mock(Rectangle.class);

    @Test
    public void dropItemTest(){
        PlateStation platestation = mock(PlateStation.class);
        Ingredient mockIngredient1 = mock(Ingredient.class);
        Ingredient mockIngredient2 = mock(Ingredient.class);

        Assert.assertEquals(0, platestation.getPlate().size());

        List<Ingredient> mockPlate = new ArrayList<>();
        mockPlate.add(mockIngredient1);
        mockPlate.add(mockIngredient2);
        when(platestation.getPlate()).thenReturn(new ArrayList<>(mockPlate));

        platestation.dropItem(mockIngredient1);
        platestation.dropItem(mockIngredient2);

        List<Ingredient> plate = platestation.getPlate();
        Assert.assertEquals(2, plate.size());
        Assert.assertTrue(plate.contains(mockIngredient1));
        Assert.assertTrue(plate.contains(mockIngredient2));
    }
}
