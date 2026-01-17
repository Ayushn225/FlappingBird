package GameObjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Pipe extends Scrollable {
    private Random r;
    private float groundY;
    private Rectangle skullUp, skullDown, barUp, barDown;
    private static final int VERTICAL_GAP = 45;
    private static final int SKULL_WIDTH = 24;
    private static final int SKULL_HEIGHT = 14;

    private boolean isScored = false;

    public Pipe(float x, float y, int width, int height, float scrollSpeed, float groundY){
        super(x, y, width, height, scrollSpeed);
        this.width = width;
        this.height = height;
        r = new Random();
        this.groundY = groundY;

        skullUp = new Rectangle();
        skullDown = new Rectangle();
        barUp = new Rectangle();
        barDown = new Rectangle();

    }

    @Override
    public void reset(float newX){
        super.reset(newX);
        height = r.nextInt(90) + 15;
        isScored = false;
    }

    @Override
    public void update(float delta){
        super.update(delta);
        barUp.set(this.position.x, this.position.y, this.width, this.height);
        barDown.set(position.x, position.y + height + VERTICAL_GAP, width, groundY - (position.y + height + VERTICAL_GAP));

        // This shift is equivalent to: (SKULL_WIDTH - width) / 2
        skullUp.set(position.x - (SKULL_WIDTH - width) / 2, position.y + height- SKULL_HEIGHT, SKULL_WIDTH, SKULL_HEIGHT);
        skullDown.set(position.x - (SKULL_WIDTH - width) / 2, barDown.y, SKULL_WIDTH, SKULL_HEIGHT);
    }

    public boolean collides(Bird bird){
        if(position.x<bird.getX() + bird.getWidth()){
            return (
                    (Intersector.overlaps(bird.getBoundingCircle(), barUp))||
                    (Intersector.overlaps(bird.getBoundingCircle(), barDown))||
                    (Intersector.overlaps(bird.getBoundingCircle(), skullUp))||
                    (Intersector.overlaps(bird.getBoundingCircle(), skullDown))
            );
        }
        return false;
    }

    public void setIsScore(boolean score){
        isScored = score;
    }

    public boolean isScored(){
        return isScored;
    }

    public Rectangle getBarDown() {
        return barDown;
    }

    public Rectangle getBarUp() {
        return barUp;
    }

    public Rectangle getSkullUp() {
        return skullUp;
    }

    public Rectangle getSkullDown() {
        return skullDown;
    }
}
