package com.nju.edu.sprite;

import com.nju.edu.screen.GameScreen;
import com.nju.edu.skill.CDSkill;
import com.nju.edu.skill.MoveSkill;
import com.nju.edu.skill.RecoverSkill;
import com.nju.edu.skill.Skill;
import com.nju.edu.util.ReadImage;
import com.nju.edu.world.World;

import java.awt.image.BufferedImage;

/**
 * 爷爷类
 * @author Zyi
 */
public class GrandFather extends Sprite {

    private static final GrandFather GRAND_FATHER = new GrandFather(World.getWorld(), 0, 320);

    public static GrandFather getInstance() {
        return GRAND_FATHER;
    }

    private GrandFather(World world, int x, int y) {
        super(world, 100, 100, ReadImage.GrandFather);
        this.setX(x);
        this.setY(y);
        world.put(this, x, y);
    }

    /**
     * 给予技能的次数
     */
    private int giveTime = 0;
    private Calabash calabash = Calabash.getInstance();
    private int speed = calabash.getSpeed();

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

    /**
     * 给予葫芦娃一个技能
     */
    public void giveSkill() {
        // 循环给予
        if (giveTime % Skill.SKILL_AMOUNT == 0) {
            System.out.println("give move skill");
            this.calabash.setSkill(new MoveSkill());
        } else if (giveTime % Skill.SKILL_AMOUNT == 1) {
            System.out.println("give cd skill");
            this.calabash.setSkill(new CDSkill());
        } else if (giveTime % Skill.SKILL_AMOUNT == 2) {
            System.out.println("give recover skill");
            this.calabash.setSkill(new RecoverSkill());
        }
        this.giveTime++;
    }

    public void speedUp(boolean isSpeedUp) {
        if (isSpeedUp) {
            this.speed += 5;
        }
    }

    public void clearSkillImpact() {
        if (calabash.haveSkill()) {
            if ("MoveSkill".equals(calabash.getCurSkill().getName()) && this.speed == 15) {
                this.speed -= 5;
            }
        }
    }
}
