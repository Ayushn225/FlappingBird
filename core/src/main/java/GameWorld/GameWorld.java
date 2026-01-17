package GameWorld;


import FBHelper.AssetLoader;
import GameObjects.Bird;
import GameObjects.ScrollHandler;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

    private Bird bird;
    private boolean isAlive = true;
    private ScrollHandler scroller;
    private Rectangle ground;

    private int Score = 0;

    public GameWorld(int midPointY){
        bird = new Bird(33, midPointY-5, 17, 12);

        scroller = new ScrollHandler(midPointY + 66, this);

        ground = new Rectangle(0, midPointY + 66, 137, 11);
    }

    public void update(float delta) {
        System.out.println("Game-World updating");
        bird.update(delta);
        scroller.update(delta);
        if(isAlive && (scroller.collides(bird)||(Intersector.overlaps(bird.getBoundingCircle(), ground)))){
            scroller.stop();
            AssetLoader.dead.play();
            isAlive = false;
            bird.die();
            bird.deaccelerate();
        }
    }

    public int getScore() { return Score; }

    public void addScore(int increament) {
        Score += increament;
    }

    public Bird getBird(){ return bird; }
    public ScrollHandler getScrollHandler() { return scroller;}

}
