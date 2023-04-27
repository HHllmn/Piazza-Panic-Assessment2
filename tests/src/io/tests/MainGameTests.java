package io.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.team13.piazzapanic.MainGame;
import io.utils.MockGame;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(GdxTestRunner.class)
public class MainGameTests {
    MainGame main = Mockito.mock(MainGame.class);
    @Test
    public void CreateTest(){
        main.create();
    }
}
