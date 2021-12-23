package com.nju.edu.screen;

import com.nju.edu.control.GameController;
import com.nju.edu.util.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zyi
 */
public class GameScreen extends JFrame {
    private static final GameScreen GAME_SCREEN = new GameScreen("Calabash Game", 30, Color.WHITE);

    public static GameScreen getInstance() {
        return GAME_SCREEN;
    }
    private static final int WIDTH = 1080;
    private static final int HEIGHT = 680;
    private GameController gameController;

    private final String windowTitle;
    private final Color bgColor;

    public GameScreen(String windowTitle, int fps, Color bgColor) {
        this.windowTitle = windowTitle;
        this.fps = fps;
        gameController = new GameController(fps);
        this.bgColor = bgColor;

        createScreen();
        this.gameController.setFocusable(true);
        this.gameController.requestFocus();
        this.add(gameController, BorderLayout.CENTER);
    }

    /**
     * frame per second
     */
    private int fps;

    private void createScreen() {
        setSize(WIDTH, HEIGHT);
        setTitle(this.windowTitle);
        setLocationRelativeTo(null);
        // setIconImage()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public void exit() {
        System.exit(1);
    }

    public int getFps() {
        return this.fps;
    }

    public static int getWid() {
        return WIDTH;
    }

    public static int getHei() {
        return HEIGHT;
    }

    /**
     * 设置新的fps
     * @param fps 新的fps
     * @return true if the fps has been set successfully, false otherwise
     */
    public Boolean setFps(int fps) {
        if (fps <= 0) {
            // 防御式编程
            return false;
        } else {
            this.fps = fps;
        }

        return true;
    }

}
