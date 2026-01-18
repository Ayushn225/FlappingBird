package GameObjects;

import FBHelper.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;

    private Circle boundingCircle = new Circle();

    private boolean isAlive = true;

    public Bird(int x, int y, int width, int height){
        this.width = width;
        this.height = height;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 460);
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

        if(isFalling() || !isAlive){
            rotation += 480*delta;
            if(rotation>90) rotation = 90;
        }

        position.add(velocity.cpy().scl(delta));

        if(position.y < -13 ) {
            position.y = -13;
            velocity.y = 0;
        }


        boundingCircle.set(position.x + 9, position.y + 6, 6.5f);
    }

    public boolean getIsAlive(){ return isAlive; }

    public boolean isFalling(){
        return velocity.y>110;
    }

    public boolean notFlap(){
        return velocity.y>70;
    }

    public void onClick(){
        if(isAlive){
            AssetLoader.flap.play();
            velocity.y = -140;
        }
    }

    public void die(){
        isAlive = false;
        velocity.y = 0;
    }

    public void deaccelerate(){
        acceleration.y = 0;
    }

    public void onRestart(int y){
        rotation = 0;
        velocity.y = 0;
        velocity.x = 0;
        position.y = y;
        acceleration.x = 0;
        acceleration.y = 460;
        isAlive = true;
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

    public Circle getBoundingCircle(){ return boundingCircle; }
}
