package com.nju.edu.sprite;

import com.nju.edu.screen.GameScreen;
import com.nju.edu.util.ReadImage;

import java.awt.image.BufferedImage;

/**
 * 爷爷类
 * @author Zyi
 */
public class GrandFather extends Sprite {

    public GrandFather(int x, int y) {
        super(x, y, 100, 100, ReadImage.GrandFather);
    }

    public void moveUp() {
        if (this.y - speed >= 0) {
            this.y -= speed;
        }
    }

    public void moveDown() {
        if (this.y + speed <= GameScreen.getHei() - 150) {
            this.y += speed;
        }
    }

    public void moveLeft() {
        if (this.x - speed >= 0) {
            this.x -= speed;
        }
    }

    public void moveRight() {
        if (this.x + speed <= GameScreen.getWid() - 150) {
            this.x += speed;
        }
    }

    /**
     * 给予葫芦娃一个技能
     */
    public void giveSkill() {

    }

}
