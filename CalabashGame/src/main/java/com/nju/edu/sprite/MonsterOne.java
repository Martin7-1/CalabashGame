package com.nju.edu.sprite;

import com.nju.edu.bullet.MonsterBullet;
import com.nju.edu.util.ReadImage;
import com.nju.edu.world.World;

/**
 * @author Zyi
 */
public class MonsterOne extends Sprite implements Monster {

    public MonsterOne(World world, int x, int y) {
        super(world, 100, 100, ReadImage.MonsterOne);
        setX(x);
        setY(y);
        world.put(this, getX(), getY());
        this.speed = 6;
    }

    public MonsterOne(World world, int x, int y, int speed) {
        super(world, 40, 40, ReadImage.MonsterOne);
        setX(x);
        setY(y);
        world.put(this, getX(), getY());
        this.speed = speed;
    }

    @Override
    public void move(long time) {
        // 游戏的怪物都是从左边向右边走的
        // monsterOne的设定就是很慢的朝左走
        setX(getX() - speed);
    }

    @Override
    public MonsterBullet monsterFire() {
        MonsterBullet bullet = new MonsterBullet(getX(), getY() + height / 2);

        return bullet;
    }
}
