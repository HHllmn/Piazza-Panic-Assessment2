package io.tests;

import Sprites.Chef;
import Sprites.InteractiveTileObject;
import Tools.WorldContactListener;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

@RunWith(GdxTestRunner.class
)
public class WorldContactListenerTests {
    @Test
    public void beginContactTest(){
        Chef chef1 = mock(Chef.class);
        Chef chef2 = mock(Chef.class);

        Fixture chefFixture1 = mock(Fixture.class);
        Fixture chefFixture2 = mock(Fixture.class);
        when(chefFixture1.getUserData()).thenReturn(chef1);
        when(chefFixture2.getUserData()).thenReturn(chef2);
        InteractiveTileObject tileObject = mock(InteractiveTileObject.class);

        Fixture objectFixture1 = mock(Fixture.class);
        Fixture objectFixture2 = mock(Fixture.class);

        Contact contact = mock(Contact.class);
        when(contact.getFixtureA()).thenReturn(chefFixture1);
        when(contact.getFixtureB()).thenReturn(chefFixture2);

        Contact conctact2 = mock(Contact.class);
        when(contact.getFixtureA()).thenReturn(chefFixture1);


        WorldContactListener listener = new WorldContactListener();
        listener.beginContact(contact);

        verify(chef1, times(1)).chefsColliding();
        verify(chef2, times(1)).chefsColliding();

        verify(chef1, never()).setTouchingTile((Fixture) any());
        verify(chef2, never()).setTouchingTile((Fixture) any());
    }

    @Test
    public void endContactTest(){
        Fixture chefFixture = mock(Fixture.class);
        Fixture objectFixture = mock(Fixture.class);

        Chef chef = mock(Chef.class);
        when(chefFixture.getUserData()).thenReturn(chef);

        InteractiveTileObject interactiveObject = mock(InteractiveTileObject.class);
        when(objectFixture.getUserData()).thenReturn(interactiveObject);

        Contact contact = mock(Contact.class);
        when(contact.getFixtureA()).thenReturn(chefFixture);
        when(contact.getFixtureB()).thenReturn(objectFixture);

        WorldContactListener listener = new WorldContactListener();
        listener.endContact(contact);

        verify(chef,times(1)).setTouchingTile(null);
    }

    //This is just making sure that the postSolve method throws no exceptions
    @Test
    public void postSolveTest(){
        Contact contact = mock(Contact.class);
        ContactImpulse contactimpulse = mock(ContactImpulse.class);
        WorldContactListener listner = new WorldContactListener();
        listner.postSolve(contact,contactimpulse);
        Assert.assertTrue(true);
    }
    //This test is just making sure that preSolve throws no exceptions
    @Test
    public void preSolveTest(){
        Contact contact = mock(Contact.class);
        Manifold oldManifold = mock(Manifold.class);
        WorldContactListener listener = new WorldContactListener();
        listener.preSolve(contact, oldManifold);
        Assert.assertTrue(true);
    }
}
