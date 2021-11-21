package com.nju.edu.sprite;

import com.nju.edu.bullet.CalabashBullet;
import com.nju.edu.screen.GameScreen;
import com.nju.edu.util.ReadImage;

/**
 * @author Zyi
 */
public class Calabash extends Sprite {

    public Calabash(int x, int y) {
        super(x, y, 100, 100, ReadImage.Calabash);
        this.speed = 10;
    }

    private Calabash(int x, int y, int speed) {
        super(x, y, 100, 100, ReadImage.Calabash);
        this.speed = speed;
    }

    /**
     * 葫芦娃的血量
     */
    public int HP = 100;

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

    public CalabashBullet calabashFire() {
        CalabashBullet bullet = new CalabashBullet(this.x + width, this.y + height / 2);
        return bullet;
    }

    /**
     * 获得当前Calabash的血量
     * @return 血量
     */
    public int getHP() {
        return this.HP;
    }

    /**
     * 受到伤害减少血量
     * @param damage 伤害
     */
    public void decreaseHP(int damage) {
        this.HP -= damage;
    }

    public void resetHP() {
        this.HP = 100;
    }
}
