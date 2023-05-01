package io.tests;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.team13.piazzapanic.MainGame;
import com.team13.piazzapanic.StartScreen;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(GdxTestRunner.class)
public class StartScreenTests {
    @Test
    public void StartScreenConstructorTest(){
        MainGame game = mock(MainGame.class);
        StartScreen startScreen = new StartScreen(game);
        assertNotNull(startScreen.game);
        assertNotNull(startScreen.backgroundImage);
        assertNotNull(startScreen.backgroundSprite);
        assertNotNull(startScreen.camera);
        assertNotNull(startScreen.viewport);
        assertTrue(startScreen.viewport instanceof FitViewport);
        assertEquals(MainGame.V_WIDTH, startScreen.viewport.getWorldWidth(), 0.001f);
        assertEquals(MainGame.V_HEIGHT, startScreen.viewport.getWorldHeight(), 0.001f);
    }
}
