package io.github.flapping_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/** First screen of the application. Displayed after the application is created. */
public class GameScreen implements Screen {
    public GameScreen(){
        System.out.println("Game Screen Attached !!");
    }

    @Override
    public void show() {
        System.out.println("Game-screen show called");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("Game-Screen resizing");
    }

    @Override
    public void pause() {
        System.out.println("Game-Screen pause");
    }

    @Override
    public void resume() {
        System.out.println("Game-Screen resume");
    }

    @Override
    public void hide() {
        System.out.println("Game-Screen hide");
    }

    @Override
    public void dispose() {
    }
}
