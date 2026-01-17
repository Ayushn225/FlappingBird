package GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;
    private int mid;

    public Bird(int x, int y, int width, int height){
        this.width = width;
        this.height = height;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 460);
        mid = y + 5;
    }

    public void update(float delta){
        velocity.add(acceleration.cpy().scl(delta));

        if(velocity.y >200){
            velocity.y = 200;
        }

        if(velocity.y<0){
            rotation -= 600*delta;
            if(rotation<-20) rotation = -20;
        }

        if(isFalling()){
            rotation += 480*delta;
            if(rotation>90) rotation = 90;
        }

        position.add(velocity.cpy().scl(delta));

        if(position.y < -13 ) {
            position.y = -13;
            velocity.y = 0;
        }

        if(position.y > mid*2-13){
            position.y = mid*2-13;
            velocity.y = -140;
        }
    }

    public boolean isFalling(){
        return velocity.y>110;
    }

    public boolean notFlap(){
        return velocity.y>70;
    }

    public void onClick(){
        velocity.y = -140;
    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public float getRotation(){
        return rotation;
    }
}
