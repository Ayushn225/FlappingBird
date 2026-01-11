package io.github.flapping_bird;


import Screens.GameScreen;
import com.badlogic.gdx.Game;

public class FBGame extends Game {

    public void create(){
        System.out.println("FBGame created!");
        setScreen(new GameScreen());
    }

}
