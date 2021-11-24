package com.nju.edu.skill;

import com.nju.edu.sprite.Calabash;

/**
 * 加快葫芦娃的移动能力
 * @author Zyi
 */
public class MoveSkill implements Skill {

    private boolean haveSkill = false;
    private final String skillName = "MoveSkill";
    private Calabash calabash = Calabash.getInstance();

    @Override
    public boolean isHaveSkill() {
        return this.haveSkill;
    }

    @Override
    public void haveSkill() {
        this.haveSkill = true;
    }

    @Override
    public void start() {
        // 加快移动速度
        this.calabash.speedUp(true);
    }

    @Override
    public String getName() {
        return this.skillName;
    }
}
