package GameWorld;


import GameObjects.Bird;
import GameObjects.ScrollHandler;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

    private Bird bird;

    private ScrollHandler scroller;

    public GameWorld(int midPointY){
        bird = new Bird(33, midPointY-5, 17, 12);

        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        System.out.println("Game-World updating");
        bird.update(delta);

        scroller.update(delta);
    }

    public Bird getBird(){ return bird; }
    public ScrollHandler getScrollHandler() { return scroller;}

}
