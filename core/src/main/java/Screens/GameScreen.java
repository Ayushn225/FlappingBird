package Screens;

import FBHelper.InputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import GameWorld.GameRenderer;
import GameWorld.GameWorld;

/** First screen of the application. Displayed after the application is created. */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime = 0;

    public GameScreen(){
        System.out.println("Game Screen Attached !!");

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float gameWidth = 136f;
        float gameHeight = (screenHeight/(screenWidth/gameWidth));
        int midPointY = (int)(gameHeight/2);

        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world, gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(world));
    }

    @Override
    public void show() {
        System.out.println("Game-screen show called");
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
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
