package io.github.flapping_bird;


import FBHelper.AssetLoader;
import Screens.GameScreen;
import com.badlogic.gdx.Game;

public class FBGame extends Game {

    public void create(){
        System.out.println("FBGame created!");
        AssetLoader.load();
        setScreen(new GameScreen());

    }

    @Override
    public void dispose(){
        super.dispose();
        AssetLoader.dispose();
    }

}
