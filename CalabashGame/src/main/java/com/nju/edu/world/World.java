package com.nju.edu.world;

import com.nju.edu.screen.GameScreen;
import com.nju.edu.sprite.GameObject;

/**
 * @author Zyi
 */
public class World {

    public static final int WIDTH = GameScreen.getWid() / 50;
    public static final int HEIGHT = GameScreen.getHei() / 50;

    private static World theWorld;

    public static World getWorld() {
        if (theWorld == null) {
            theWorld = new World();
        }
        return theWorld;
    }

    private Tile<GameObject>[][] tiles;
    private Tile<GameObject>[][] characters;

    @SuppressWarnings("unchecked")
    private World() {
        if (tiles == null) {
            tiles = new Tile[WIDTH][HEIGHT];
        }

        setMap();
    }

    /**
     * 设置地图
     */
    private void setMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                tiles[i][j] = new Tile<>(i, j);
                tiles[i][j].setThing(new Floor(this));
            }
        }
    }

    public void addGameObject(GameObject gameObject) {
        // 在世界上绘制人物
        int xPos = gameObject.getX();
        int yPos = gameObject.getY();

        this.characters[xPos][yPos] = new Tile<>(xPos, yPos);
        this.characters[xPos][yPos].setThing(gameObject);
    }

    public GameObject get(int x, int y) {
        return this.tiles[x][y].getThing();
    }

    public void put(GameObject t, int x, int y) {
        this.tiles[x][y].setThing(t);
    }
}
