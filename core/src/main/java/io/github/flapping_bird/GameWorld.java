package io.github.flapping_bird;


import com.badlogic.gdx.math.Rectangle;

public class GameWorld {
    private Rectangle rect = new Rectangle(0, 0, 17, 12);

    public GameWorld(){

    }

    public void update(float delta){
        System.out.println("Game-World updating");
        rect.x += 1;
        if(rect.x > 137){
            rect.x = 0;
        }
    }

    public Rectangle getRect(){
        return rect;
    }
}
