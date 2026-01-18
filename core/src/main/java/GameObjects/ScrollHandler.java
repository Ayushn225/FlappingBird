package GameObjects;

import FBHelper.AssetLoader;
import GameWorld.GameWorld;

public class ScrollHandler {
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;

    public static final int SCROLL_SPEED = -59;
    public static final int PIPE_GAP = 49;

    private GameWorld myWorld;

    public ScrollHandler(float yPos, GameWorld gameWorld){
        myWorld = gameWorld;

        frontGrass = new Grass(0, yPos, 143, 11, SCROLL_SPEED);
        backGrass = new Grass(frontGrass.getTailX(), yPos, 143, 11, SCROLL_SPEED);

        pipe1 = new Pipe(210, 0, 22, 60, SCROLL_SPEED, yPos);
        pipe2 = new Pipe(pipe1.getTailX() + PIPE_GAP, 0, 22, 70, SCROLL_SPEED, yPos);
        pipe3 = new Pipe(pipe2.getTailX() + PIPE_GAP, 0, 22, 60, SCROLL_SPEED, yPos);
    }

    public void update(float delta){
        frontGrass.update(delta);
        backGrass.update(delta);
        pipe1.update(delta);
        pipe2.update(delta);
        pipe3.update(delta);

        if(pipe1.getIsScrolledLeft()){
            pipe1.reset(pipe3.getTailX()+ PIPE_GAP);
        }
        if(pipe2.getIsScrolledLeft()){
            pipe2.reset(pipe1.getTailX()+ PIPE_GAP);
        }
        if(pipe3.getIsScrolledLeft()){
            pipe3.reset(pipe2.getTailX()+ PIPE_GAP);
        }

        if(frontGrass.getIsScrolledLeft()){
            frontGrass.reset(backGrass.getTailX());
        }
        if(backGrass.getIsScrolledLeft()){
            backGrass.reset(frontGrass.getTailX());
        }
    }

    public void stop(){
        frontGrass.stop();
        backGrass.stop();
        pipe1.stop();
        pipe2.stop();
        pipe3.stop();
    }

    public boolean collides(Bird bird){
        if(!pipe1.isScored() && pipe1.getX() + (pipe1.getWidth()/2.0f) < bird.getX() + bird.getWidth()){
            myWorld.addScore(1);
            pipe1.setIsScore(true);
            AssetLoader.coin.play();
        }else if(!pipe2.isScored() && pipe2.getX() + (pipe2.getWidth()/2.0f) < bird.getX() + bird.getWidth()) {
            myWorld.addScore(1);
            pipe2.setIsScore(true);
            AssetLoader.coin.play();
        }else if(!pipe3.isScored() && pipe3.getX() + (pipe3.getWidth()/2.0f) < bird.getX() + bird.getWidth()) {
            myWorld.addScore(1);
            pipe3.setIsScore(true);
            AssetLoader.coin.play();
        }
        return(pipe1.collides(bird) || pipe2.collides(bird) || pipe3.collides(bird));
    }

    public void onRestart(){
        frontGrass.onRestart(0, SCROLL_SPEED);
        backGrass.onRestart(frontGrass.getTailX(), SCROLL_SPEED);
        pipe1.onRestart(210, SCROLL_SPEED);
        pipe2.onRestart(pipe1.getTailX() + PIPE_GAP, SCROLL_SPEED);
        pipe3.onRestart(pipe2.getTailX() + PIPE_GAP, SCROLL_SPEED);
    }

    public Grass getFrontGrass(){ return frontGrass; }
    public Grass getBackGrass(){ return backGrass; }
    public Pipe getPipe1(){ return pipe1; }
    public Pipe getPipe2(){ return pipe2; }
    public Pipe getPipe3(){ return pipe3; }
}
