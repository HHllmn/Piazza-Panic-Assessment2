package io.tests;

import Ingredients.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.team13.piazzapanic.MainGame;
import com.team13.piazzapanic.PlayScreen;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;


@RunWith(GdxTestRunner.class)
public class IngredientsTests {
    MainGame main = Mockito.mock(MainGame.class);
    PlayScreen play = Mockito.mock(PlayScreen.class);
    //Arbitrary times will be given for the ingredients cooktime and preptime
    float pTime = 1.0f;
    float cTime = 1.0f;
    @Test
    public void TomatoConstructorTest(){
        Tomato tomato = new Tomato(pTime, cTime);
        Assert.assertFalse(tomato.isPrepared());

        tomato.setPrepared();
        Assert.assertTrue(tomato.isPrepared());
    }
    @Test
    public void BunConstructorTest(){
        Bun bun = new Bun(pTime,cTime);
        Assert.assertTrue(bun.isPrepared());
        Bun bun2 = new Bun();
        Assert.assertTrue(bun2.isPrepared());
        Assert.assertTrue(bun2.prepareTime == 0);
        Assert.assertTrue(bun2.cookTime == 3);
    }
    @Test
    public void CheeseConstructorTest(){
        Cheese cheese = new Cheese(pTime,cTime);
        Assert.assertFalse(cheese.isPrepared());
        cheese.setPrepared();
        Assert.assertTrue(cheese.isPrepared());
    }

    @Test
    public void DoughConstructorTest(){
        Dough dough = new Dough(pTime,cTime);
        Assert.assertFalse(dough.isPrepared());
    }

    @Test
    public void LettuceConstructorTest(){
        Lettuce lettuce = new Lettuce(pTime,cTime);
        Assert.assertFalse(lettuce.isPrepared());
    }
    @Test
    public void OnionConstructorTest(){
        Onion onion = new Onion(pTime,cTime);
        Assert.assertFalse(onion.isPrepared());
    }
    @Test
    public void PotatoConstructorTest(){
        Potato potato = new Potato(pTime,cTime);
        Assert.assertFalse(potato.isPrepared());
    }
    @Test
    public void SteakConstructorTest(){
        Steak steak = new Steak(pTime,cTime);
        Assert.assertFalse(steak.isCooked());
        Assert.assertFalse(steak.isPrepared());
        steak.setCooked();
        Assert.assertTrue(steak.isCooked());

        Steak steak2 = new Steak();
        Assert.assertFalse(steak2.isPrepared());
        Assert.assertTrue(steak2.prepareTime == 2);
        Assert.assertTrue(steak2.cookTime == 3);
    }
    @Test
    public void createIngredientTest(){
        SpriteBatch batch = Mockito.mock(SpriteBatch.class);
        Steak steak = new Steak(pTime,cTime);
        steak.create(200,200,batch);

    }
}
