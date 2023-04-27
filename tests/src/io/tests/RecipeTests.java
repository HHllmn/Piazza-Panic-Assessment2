package io.tests;

import Ingredients.Ingredient;
import Ingredients.*;
import Recipe.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.team13.piazzapanic.MainGame;
import io.utils.MockGame;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Matchers.anyFloat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;


@RunWith(GdxTestRunner.class)
public class RecipeTests {
    MainGame game = mock(MainGame.class);
    @Test
    public void BurgerRecipeTest(){
        BurgerRecipe burgerRecipe  = new BurgerRecipe();
        ArrayList<Ingredient> ingredients = burgerRecipe.getIngredients();
        Assert.assertEquals(2, ingredients.size());
        Assert.assertTrue(ingredients.get(0) instanceof Bun);
        Assert.assertTrue(ingredients.get(1) instanceof Steak);
    }
    @Test
    public void JacketPotTest(){
        JackPotRecipe jackpotRecipe = new JackPotRecipe();
        ArrayList<Ingredient> ingredients = jackpotRecipe.getIngredients();
        Assert.assertEquals(2, ingredients.size());
        Assert.assertTrue(ingredients.get(0) instanceof Potato);
        Assert.assertTrue(ingredients.get(1) instanceof Cheese);
    }

    @Test
    public void PizzaRecipeTest(){
        PizzaRecipe pizzarecipe = new PizzaRecipe();
        ArrayList<Ingredient> ingredients = pizzarecipe.getIngredients();
        Assert.assertEquals(2, ingredients.size());
        Assert.assertTrue(ingredients.get(0) instanceof Dough);
        Assert.assertTrue(ingredients.get(1) instanceof Tomato);
        Assert.assertTrue(ingredients.get(2) instanceof Cheese);
    }
    //lettuce onion tomato
    @Test
    public void SaladRecipeTest(){
        SaladRecipe saladrecipe = new SaladRecipe();
        ArrayList<Ingredient> ingredients = saladrecipe.getIngredients();
        Assert.assertEquals(2,ingredients.size());
        Assert.assertTrue(ingredients.get(0) instanceof Lettuce);
        Assert.assertTrue(ingredients.get(1) instanceof Onion);
        Assert.assertTrue(ingredients.get(2) instanceof Tomato);
    }

    @Test
    public void OrderCreate(){
        //BurgerRecipe burgerRecipe  = new BurgerRecipe();
        SpriteBatch batch = mock(SpriteBatch.class);
        //Texture texture = new Texture("Food/Burger.png");

        Texture texture = mock(Texture.class);
        when(texture.getWidth()).thenReturn(100);
        when(texture.getHeight()).thenReturn(100);

        Order order = new Order(new Recipe(), texture);
        //Order order = new Order(burgerRecipe, texture);
        order.create(0,0, batch);
        verify(batch).draw(eq(texture), eq(-0.08000183f), eq(0.069999695f), anyFloat(), anyFloat());

    }
}
