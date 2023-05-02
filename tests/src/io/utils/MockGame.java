package io.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.team13.piazzapanic.HUD;
import com.team13.piazzapanic.MainGame;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

public class MockGame {
    public static HUD BaseScore(){
        SpriteBatch mockBatch = Mockito.mock(SpriteBatch.class);
        Stage mockStage = Mockito.mock(Stage.class);
        HUD screen = new HUD(mockBatch);
        return screen;
    }
    public static Shader SetShaders(){
        Shader mockShader = Mockito.mock(Shader.class);
        return mockShader;
    }
    public static MainGame createGame(){
        MainGame maingame = Mockito.mock(MainGame.class);
        Mockito.doCallRealMethod().when(maingame).create();
        SpriteBatch mockBatch = Mockito.mock(SpriteBatch.class);
        Whitebox.setInternalState(maingame, "batch", mockBatch);
        return maingame;
    }
    public static Texture mockTexture() {
        Texture texture = Mockito.mock(Texture.class);
        Mockito.when(texture.getWidth()).thenReturn(100);
        Mockito.when(texture.getHeight()).thenReturn(100);
        return texture;
    }
    public static Sprite mockSprite(Texture texture) {
        Sprite sprite = Mockito.mock(Sprite.class);
        Mockito.when(sprite.getTexture()).thenReturn(Mockito.mock(Texture.class));
        Mockito.when(sprite.getWidth()).thenReturn(10f);
        Mockito.when(sprite.getHeight()).thenReturn(10f);
        return sprite;
    }
    public static SpriteBatch mockSpriteBatch() {
        return Mockito.mock(SpriteBatch.class);


    }
}
