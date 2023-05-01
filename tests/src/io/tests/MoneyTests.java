package io.tests;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.team13.piazzapanic.HUD;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;

@RunWith(GdxTestRunner.class)
public class MoneyTests {
    @Test
    public void updateScoreTest(){
        SpriteBatch batch = mock(SpriteBatch.class);
        HUD hud = new HUD(batch);
        hud.score = 0;
        hud.scenarioComplete = true;
        hud.updateScore(false, 100);
        Assert.assertTrue(hud.score == 0);

        hud.scenarioComplete = false;
        hud.score = 0;
        hud.worldTimerM = 0;
        hud.updateScore(false, 121);
        Assert.assertTrue(hud.score == 100);

        hud.score = 0;
        hud.worldTimerM = 2;
        hud.updateScore(false, 119);
        Assert.assertTrue(hud.score == 95);

        hud.updateScore(false, 121);
        Assert.assertTrue(hud.score == 195);

        hud.worldTimerM = 100;
        hud.updateScore(false, 120);
        Assert.assertTrue(hud.score == 195);
    }
}
