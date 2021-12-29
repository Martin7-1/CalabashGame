package com.nju.edu.game;

import com.nju.edu.control.GameController;
import com.nju.edu.screen.GameScreen;

import java.awt.*;

/**
 * @author Zyi
 */
public class Game {

    public static void start() {
        GameScreen gameScreen = new GameScreen("Calabash Game", Color.WHITE);
        GameController gameController = new GameController(30);
        gameScreen.add(gameController);
        gameController.start();
        gameController.requestFocus();
    }
}
