package com.nju.edu.bullet;

import com.nju.edu.sprite.Sprite;
import com.nju.edu.util.ReadImage;
import com.nju.edu.world.World;

/**
 * @author Zyi
 */
public class MonsterBullet extends Sprite {

    private final int interval = 20;
    private int speed;

    public MonsterBullet(World world, int x, int y) {
        super(world, 10, 10, ReadImage.MonsterBullet);
        setX(x);
        setY(y);
        world.put(this, getX(), getY());
        this.speed = 8;
    }

    @Override
    public void move(long time) {
        // 每隔一段时间移动
        if (time % this.interval == 0) {
            transferX(-speed);
        }
    }
}
