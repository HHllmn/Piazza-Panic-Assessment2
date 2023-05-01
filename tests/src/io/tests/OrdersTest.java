package io.tests;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.team13.piazzapanic.Orders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;

@RunWith(GdxTestRunner.class)
public class OrdersTest {
    @Test
    public void ordersConstructorTest(){
        SpriteBatch batch = mock(SpriteBatch.class);
        Orders orders = new Orders(batch);
        Assert.assertNotNull(orders.stage);
        Assert.assertTrue(orders.stage.getActors().size > 0);
        Assert.assertTrue(orders.stage.getActors().first() instanceof Table);
    }
}
