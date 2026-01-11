package GameWorld;


import GameObjects.Bird;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

    private Rectangle rect;
    private Bird bird;

    public GameWorld(int midPointY){
        bird = new Bird(33, midPointY-5, 17, 12);
        rect = new Rectangle(bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
    }

    public void update(float delta){
        System.out.println("Game-World updating");
        bird.update(delta);
        rect.x = bird.getX();
        rect.y = bird.getY();
    }

    public Rectangle getRect(){
        return rect;
    }

    public Bird getBird(){
        return bird;
    }

}
