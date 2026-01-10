package io.github.flapping_bird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/** First screen of the application. Displayed after the application is created. */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    public GameScreen(){
        System.out.println("Game Screen Attached !!");

        world = new GameWorld();
        renderer = new GameRenderer(world);
    }

    @Override
    public void show() {
        System.out.println("Game-screen show called");
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
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
