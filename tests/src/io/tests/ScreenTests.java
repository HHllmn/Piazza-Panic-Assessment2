package io.tests;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.team13.piazzapanic.MainGame;
import com.team13.piazzapanic.PauseScreen;
import com.team13.piazzapanic.StartScreen;
import jdk.tools.jmod.Main;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(GdxTestRunner.class)
public class ScreenTests {
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
    @Test
    public void PauseScreenConstructorTest(){
        MainGame game = mock(MainGame.class);
        PauseScreen screen = new PauseScreen(game);
        assertEquals(game, screen.game);
        assertNotNull(screen.backgroundImage);
        assertNotNull(screen.backgroundSprite);
        assertNotNull(screen.camera);
        assertNotNull(screen.viewport);
        assertEquals(MainGame.V_WIDTH, screen.viewport.getWorldWidth(), 0.1f);
        assertEquals(MainGame.V_HEIGHT, screen.viewport.getWorldHeight(), 0.1f);
    }

    @Test
    public void SelectGameModeTest(){
        MainGame game = new MainGame();
        game.GameMode = MainGame.Mode.ENDLESS;
        StartScreen screen = new StartScreen(game);
        screen.show();
        Texture texture1 = screen.backgroundImage;

        game.GameMode = MainGame.Mode.SITUATION;
        screen.show();
        Texture texture2 = screen.backgroundImage;

        assertNotEquals(System.identityHashCode(texture1), System.identityHashCode(texture2));
    }
}
