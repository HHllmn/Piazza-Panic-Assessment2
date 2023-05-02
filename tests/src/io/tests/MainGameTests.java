package io.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.team13.piazzapanic.MainGame;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(GdxTestRunner.class)
public class MainGameTests {
    @Test
    public void MainGameRenderTests(){
        SpriteBatch batch = mock(SpriteBatch.class);
        MainGame game = new MainGame();
        game.batch = mock(SpriteBatch.class);
        game.isStartScreen = true;
        game.GameMode = MainGame.Mode.SITUATION;
        Gdx.input = mock(Input.class);
        when(Gdx.input.isKeyJustPressed(Input.Keys.M)).thenReturn(true);
        game.render();
        Assert.assertTrue(game.GameMode == MainGame.Mode.ENDLESS);

        game.GameMode = MainGame.Mode.ENDLESS;
        game.render();
        Assert.assertTrue(game.GameMode == MainGame.Mode.SITUATION);


    }
    @Test
    public void MainGameRenderStartTests(){
        SpriteBatch batch = mock(SpriteBatch.class);
        MainGame game = new MainGame();
        game.batch = batch;
        Gdx.input = mock(Input.class);
        when(Gdx.input.isKeyJustPressed(Input.Keys.TAB)).thenReturn(true);
        game.isStartScreen = true;
        game.isPlayScreen = true;
        game.render();
        Assert.assertTrue(game.isPlayScreen);
        Assert.assertFalse(game.isStartScreen);
        when(Gdx.input.isKeyJustPressed(Input.Keys.TAB)).thenReturn(false);
        game.isStartScreen = true;
        game.render();
        Assert.assertTrue(game.isStartScreen);
    }

}
