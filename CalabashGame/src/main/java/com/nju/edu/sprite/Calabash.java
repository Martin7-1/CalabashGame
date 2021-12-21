package com.nju.edu.sprite;

import com.nju.edu.bullet.CalabashBullet;
import com.nju.edu.screen.GameScreen;
import com.nju.edu.skill.Skill;
import com.nju.edu.util.ReadImage;
import com.nju.edu.world.World;

/**
 * @author Zyi
 */
public class Calabash extends Sprite {

    private static Calabash CALABASH;

    public static Calabash getInstance() {
        if (CALABASH == null) {
            CALABASH = new Calabash(World.getWorld(), 10, 32);
        }
        return CALABASH;
    }

    public Skill skill;
    private boolean isFirstUse = true;
    /**
     * 葫芦娃的血量
     */
    public int HP = 100;
    private int fireInterval = 120;

    private Calabash(World world, int x, int y) {
        super(world, 100, 100, ReadImage.Calabash);
        setX(x);
        setY(y);
        world.put(this, getX(), getY());
        this.speed = 10;
    }

    private Calabash(World world, int x, int y, int speed) {
        super(world, 100, 100, ReadImage.Calabash);
        setX(x);
        setY(y);
        world.put(this, getX(), getY());
        this.speed = speed;
    }

    public void moveUp() {
        if (getY() - speed >= 0) {
            setY(getY() - speed);
            world.put(this, getX(), getY());
        }
    }

    public void moveDown() {
        if (getY() + speed <= GameScreen.getHei() - 150) {
            setY(getY() + speed);
            world.put(this, getX(), getY());
        }
    }

    public void moveLeft() {
        if (getX() - speed >= 0) {
            setX(getX() - speed);
            world.put(this, getX(), getY());
        }
    }

    public void moveRight() {
        if (getX() + speed <= GameScreen.getWid() - 150) {
            setX(getX() + speed);
            world.put(this, getX(), getY());
        }
    }

    public CalabashBullet calabashFire() {
        CalabashBullet bullet = new CalabashBullet(world, getX() + width, getY() + height / 2);
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

    public void recover() {
        if (this.HP + 10 > 100) {
            this.HP = 100;
        } else {
            this.HP += 10;
        }
    }

    public void resetHP() {
        this.HP = 100;
    }

    public boolean haveSkill() {
        return this.skill != null;
    }

    public void useSkill() {
        System.out.println("Use skill: " + this.skill.getName());
        this.skill.start();
    }

    public boolean isFirstUse() {
        return this.isFirstUse;
    }

    public void setFirstUse() {
        isFirstUse = !isFirstUse;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Skill getCurSkill() {
        // 获得当前拥有的技能
        return this.skill;
    }

    public void speedUp(boolean haveSkill) {
        if (haveSkill) {
            // 加速
            this.speed += 5;
        }
    }

    private void speedDown() {
        this.speed -= 5;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void clearSkillImpact() {
        // 根据当前技能来清空技能效果
        if (this.skill != null) {
            if ("MoveSkill".equals(this.skill.getName()) && this.speed == 15) {
                speedDown();
            } else if ("CDSkill".equals(this.skill.getName()) && this.fireInterval == 80) {
                this.fireInterval = 120;
            } else {
                // nothing to do, recover do not need to reset
            }
        }
    }

    public int getFireInterval() {
        return this.fireInterval;
    }

    public void setFireInterval(int fireInterval) {
        this.fireInterval = fireInterval;
    }
}
