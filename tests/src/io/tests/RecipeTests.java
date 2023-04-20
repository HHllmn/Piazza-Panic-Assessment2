package io.tests;

import Recipe.Recipe;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.team13.piazzapanic.MainGame;
import io.utils.MockGame;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;


@RunWith(GdxTestRunner.class)
public class RecipeTests {
    @Test
    public void createRecipeTest(){
        Texture completedImg = MockGame.mockTexture();
        Recipe recipe = new Recipe();
        Sprite mockedSprite = MockGame.mockSprite(completedImg);
        SpriteBatch mockedBatch = MockGame.mockSpriteBatch();
        recipe.create(2f, 3f, mockedBatch);
    }
}
