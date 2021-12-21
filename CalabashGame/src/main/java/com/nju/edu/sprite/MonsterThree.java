package com.nju.edu.sprite;

import com.nju.edu.bullet.MonsterBullet;
import com.nju.edu.util.ReadImage;
import com.nju.edu.world.World;

/**
 * @author Zyi
 */
public class MonsterThree extends Sprite implements Monster {

    public MonsterThree(World world, int x, int y) {
        super(world, 150, 150, ReadImage.MonsterThree);
        setX(x);
        setY(y);
        world.put(this, getX(), getY());
        this.speed = 2;
    }

    public MonsterThree(World world, int x, int y, int speed) {
        super(world, 50, 50, ReadImage.MonsterThree);
        setX(x);
        setY(y);
        world.put(this, getX(), getY());
        this.speed = speed;
    }

    @Override
    public void move(long time) {
        // 游戏的怪物都是从左边向右边走的
        // monsterThree的设定就是越走越快
        transferX(-speed);
        if (time % 6000 == 0) {
            speed++;
        }
    }

    @Override
    public MonsterBullet monsterFire() {
        MonsterBullet bullet = new MonsterBullet(world, getX(), getY() + height / 2);

        return bullet;
    }
}
