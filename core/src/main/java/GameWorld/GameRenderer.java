package GameWorld;

import FBHelper.AssetLoader;
import GameObjects.Bird;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import static com.badlogic.gdx.Gdx.gl;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;

    float gameHeight;
    int midPointY;

    Bird bird;

    public GameRenderer(GameWorld world, float gameHeight, int midPointY){
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        bird = myWorld.getBird();
    }

    public void render(float runTime){
        System.out.println("GameRenderer- render");
        Rectangle rect = myWorld.getRect();

        //to prevent flickering
        gl.glClearColor(0, 0, 0, 1f);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        //background
        shapeRenderer.setColor(55/255.0f, 80/255.0f, 100/255.0f, 1f);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        //grass
        shapeRenderer.setColor(111/255.0f, 186/255.0f, 45/255.0f, 1f);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        //dirt
        shapeRenderer.setColor(147/255.0f, 80/255.0f, 27/255.0f, 1f);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        shapeRenderer.end();

        batcher.begin();

        batcher.disableBlending();
        batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);

        batcher.enableBlending();
        batcher.draw(
            AssetLoader.birdAnimation.getKeyFrame(runTime),
            bird.getX(),
            bird.getY(),
            bird.getWidth(),
            bird.getHeight()
        );

        batcher.end();

    }
}
