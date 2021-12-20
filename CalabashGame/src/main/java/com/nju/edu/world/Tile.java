package com.nju.edu.world;

import com.nju.edu.sprite.GameObject;

/**
 * @author Zyi
 */
public class Tile<T extends GameObject> {

    private T thing;
    private int xPos;
    private int yPos;

    public T getThing() {
        return thing;
    }

    public void setThing(T thing) {
        this.thing = thing;
        this.thing.setTile(this);
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Tile() {
        this.xPos = -1;
        this.yPos = -1;
    }

    public Tile(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
