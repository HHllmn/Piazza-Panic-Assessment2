package io.tests;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.team13.piazzapanic.HUD;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;

@RunWith(GdxTestRunner.class)
public class LevelCompleteTests {
    @Test
    public void updateTimeTest(){
        SpriteBatch batch = mock(SpriteBatch.class);
        HUD hud = new HUD(batch);
        hud.worldTimerM = 1;
        hud.worldTimerS = 59;
        hud.scenarioComplete = false;
        hud.updateTime(false);
        Assert.assertTrue(hud.worldTimerM == 2);
        Assert.assertTrue(hud.worldTimerS == 0);
        hud.worldTimerS = 0;
        hud.updateTime(false);
        Assert.assertTrue(hud.worldTimerS == 1);

        hud.worldTimerM = 0;
        hud.worldTimerS = 0;
        hud.scenarioComplete = true;
        hud.updateTime(true);
        Assert.assertTrue(hud.timeStr != null);
    }
}
