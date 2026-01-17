package GameWorld;


import FBHelper.AssetLoader;
import GameObjects.Bird;
import GameObjects.ScrollHandler;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

    private Bird bird;
    private boolean isAlive = true;
    private ScrollHandler scroller;

    public GameWorld(int midPointY){
        bird = new Bird(33, midPointY-5, 17, 12);

        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        System.out.println("Game-World updating");
        bird.update(delta);
        scroller.update(delta);
        if(isAlive && scroller.collides(bird)){
            scroller.stop();
            AssetLoader.dead.play();
            isAlive = false;
        }
    }

    public Bird getBird(){ return bird; }
    public ScrollHandler getScrollHandler() { return scroller;}

}
