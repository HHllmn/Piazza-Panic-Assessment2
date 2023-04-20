package io.tests;

import Ingredients.Bun;
import Ingredients.Lettuce;
import Ingredients.Tomato;
import com.badlogic.gdx.graphics.Texture;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;


@RunWith(GdxTestRunner.class)
public class IngredientsTests {
    //Arbitrary times will be given for the ingredients cooktime and preptime
    float pTime = 1.0f;
    float cTime = 1.0f;
    @Test
    public void TomatoConstructorTest(){
        Tomato tomato = new Tomato(pTime, cTime);
        tomato.setPrepared();
        Assert.assertTrue(tomato.isPrepared());
    }
    @Test
    public void BunConstructorTest(){
        Bun bun = new Bun(pTime,cTime);
        Assert.assertTrue(bun.isPrepared());
    }
    @Test
    public void LettuceConstructorTest(){

    }
}
