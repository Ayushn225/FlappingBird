package FBHelper;

import GameObjects.Bird;
import GameWorld.GameWorld;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {

    private Bird myBird;
    GameWorld myWorld;

    public InputHandler(GameWorld world){
        myBird = world.getBird();
        myWorld = world;
    }

    @Override
    public boolean touchDown(int ScreenX, int ScreenY, int pointer, int button){
        if(myWorld.isReady()){
            myWorld.start();
        }

        myBird.onClick();

        if(myWorld.isGameOver() || myWorld.isHighScore()){
            myWorld.restart();
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode){
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }


}
