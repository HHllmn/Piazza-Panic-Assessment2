package io.tests;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.team13.piazzapanic.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;

@RunWith(GdxTestRunner.class)
public class HUDTests {
    @Test
    public void updateScoreTest(){
        SpriteBatch batch = mock(SpriteBatch.class);
        HUD hud = new HUD(batch);
        hud.money = 0;
        hud.scenarioComplete = true;
        hud.updateScore(false, 100);
        Assert.assertEquals(0, (int) hud.money);

        hud.scenarioComplete = false;
        hud.money = 0;
        hud.worldTimerM = 0;
        hud.updateScore(false, 121);
        Assert.assertEquals(100, (int) hud.money);

        hud.money = 0;
        hud.worldTimerM = 2;
        hud.updateScore(false, 119);
        Assert.assertEquals(95, (int) hud.money);

        hud.updateScore(false, 121);
        Assert.assertEquals(195, (int) hud.money);

        hud.worldTimerM = 100;
        hud.updateScore(false, 120);
        Assert.assertEquals(195, (int) hud.money);

        HUD hud2 = new HUD(batch);
        hud2.scenarioComplete = true;
        hud2.updateScore(true,120);
        Assert.assertEquals(Color.GREEN, hud2.moneyLabel.getColor());
        Assert.assertEquals("", hud2.moneyLabel.getText().toString());
        Assert.assertNull(hud2.moneyLabelLT.getParent());
        Assert.assertNull(hud2.moneyLabel.getParent());
        Assert.assertNotNull(hud2.table.getParent());
        Assert.assertTrue(hud2.scenarioComplete);
    }
    @Test
    public void purchaseUnlockTest(){
        SpriteBatch batch = mock(SpriteBatch.class);
        HUD hud = new HUD(batch);
        hud.money = 0;
        boolean result1 = hud.purchaseUnlock();
        Assert.assertFalse(result1);
        Assert.assertEquals(0, (int) hud.money);

        hud.money = 100;
        boolean result2 = hud.purchaseUnlock();
        Assert.assertTrue(result2);
        Assert.assertEquals(50, (int) hud.money);
    }
    @Test
    public void updateReputationTest(){
        SpriteBatch batch = mock(SpriteBatch.class);
        HUD hud = new HUD(batch);
        hud.reputationLabel = mock(Label.class);
        hud.reputationLabelT = mock(Label.class);

        Integer reputationNum1 = 0;
        hud.updateReputation(reputationNum1);
        Assert.assertNull(hud.reputationLabel.getParent());
        Assert.assertNull(hud.reputationLabelT.getParent());
        Assert.assertNotNull(hud.table.getParent());

        Integer reputationNum2 = 100;
        hud.updateReputation(reputationNum2);
        Assert.assertNull(hud.reputationLabel.getParent());
        Assert.assertNull(hud.reputationLabelT.getParent());
        Assert.assertNotNull(hud.table.getParent());
    }
    @Test
    public void updateTimeTest(){
        SpriteBatch batch = mock(SpriteBatch.class);
        HUD hud = new HUD(batch);
        hud.reputationLabel = mock(Label.class);
        hud.reputationLabelT = mock(Label.class);
        PlayScreen.endlessOver = true;
        hud.updateTime(false);

        Assert.assertEquals(Color.BLACK, hud.timeLabel.getColor());
        Assert.assertEquals(Color.RED, hud.timeLabelT.getColor());
        Assert.assertEquals("TIME: 0:0 MONEY: 0", hud.timeLabel.getText().toString());
        Assert.assertEquals("GAME OVER", hud.timeLabelT.getText().toString());

        Assert.assertNull(hud.moneyLabel.getParent());
        Assert.assertNull(hud.moneyLabelLT.getParent());
        Assert.assertNull(hud.orderNumL.getParent());
        Assert.assertNull(hud.reputationLabel.getParent());
        Assert.assertNull(hud.reputationLabelT.getParent());
    }
}
