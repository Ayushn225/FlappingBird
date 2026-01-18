package GameWorld;


import FBHelper.AssetLoader;
import GameObjects.Bird;
import GameObjects.ScrollHandler;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

    private Bird bird;
    private ScrollHandler scroller;
    private Rectangle ground;
    private int midPointY;

    private int Score = 0;

    public enum GameState{
        READY, RUNNING, GAMEOVER, HIGHSCORE
    }

    private GameState currentState;

    public GameWorld(int midPointY){

        currentState = GameState.READY;

        this.midPointY = midPointY;
        bird = new Bird(33, midPointY-5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66, this);
        ground = new Rectangle(0, midPointY + 66, 137, 11);

    }

    public void update(float delta) {

        switch(currentState){
            case READY:
                updateReady(delta);
                break;
            case RUNNING:
                updateRunning(delta);
                break;
            default:
                break;
        }
    }

    public void updateRunning(float delta) {
        if (delta > .15f) {
            delta = .15f;
        }

        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && bird.getIsAlive()) {
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
            if (Score > AssetLoader.getHighScore()) {
                AssetLoader.setHighScore(Score);
                currentState = GameState.HIGHSCORE;
            } else {
                currentState = GameState.GAMEOVER;
            }
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.deaccelerate();
            if (Score > AssetLoader.getHighScore()) {
                AssetLoader.setHighScore(Score);
                currentState = GameState.HIGHSCORE;
            } else {
                currentState = GameState.GAMEOVER;
            }
        }
    }

    private void updateReady(float delta){ }

    public void restart(){
        currentState = GameState.READY;
        Score = 0;
        bird.onRestart(midPointY - 5);
        scroller.onRestart();
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public boolean isGameOver(){
        return currentState == GameState.GAMEOVER;
    }

    public boolean isReady(){
        return currentState == GameState.READY;
    }

    public boolean isHighScore(){
        return currentState == GameState.HIGHSCORE;
    }

    public int getScore() { return Score; }

    public void addScore(int increament) {
        Score += increament;
    }

    public Bird getBird(){ return bird; }
    public ScrollHandler getScrollHandler() { return scroller;}

}
