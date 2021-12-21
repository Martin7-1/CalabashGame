package com.nju.edu.sprite;

import com.nju.edu.bullet.MonsterBullet;
import com.nju.edu.screen.GameScreen;
import com.nju.edu.util.ReadImage;
import com.nju.edu.world.World;

/**
 * @author Zyi
 */
public class MonsterTwo extends Sprite implements Monster {

    private boolean isGoAhead = true;

    public MonsterTwo(World world, int x, int y) {
        super(world, 150, 150, ReadImage.MonsterTwo);
        setX(x);
        setY(y);
        world.put(this, x, y);
        this.speed = 1;
    }

    public MonsterTwo(World world, int x, int y, int speed) {
        super(world, 40, 40, ReadImage.MonsterTwo);
        setX(x);
        setY(y);
        world.put(this, x, y);
        this.speed = speed;
    }

    @Override
    public void move(long time) {
        // MonsterTwo的设定是会上下移动
        transferX(-speed);
        if (isGoAhead) {
            if (getY() + speed <= GameScreen.getHei() / 50 - 2) {
                transferY(speed);
            } else {
                isGoAhead = false;
                transferY(-speed);
            }
        } else {
            if (getY() - speed >= 0) {
                transferY(-speed);
            } else {
                isGoAhead = true;
                transferY(speed);
            }
        }
    }

    @Override
    public MonsterBullet monsterFire() {
        MonsterBullet bullet = new MonsterBullet(world, getX(), getY() + height / 2);

        return bullet;
    }


}
