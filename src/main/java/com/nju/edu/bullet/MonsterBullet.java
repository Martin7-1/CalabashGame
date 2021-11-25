package com.nju.edu.bullet;

import com.nju.edu.sprite.Sprite;
import com.nju.edu.util.ReadImage;

/**
 * @author Zyi
 */
public class MonsterBullet extends Sprite {

    private final int interval = 20;
    private int speed;

    public MonsterBullet(int x, int y) {
        super(x, y, 26, 26, ReadImage.MonsterBullet);
        this.speed = 8;
    }

    @Override
    public void move(long time) {
        // 每隔一段时间移动
        if (time % this.interval == 0) {
            this.x -= speed;
        }
    }
}
