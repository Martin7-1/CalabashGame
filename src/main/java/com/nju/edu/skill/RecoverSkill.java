package com.nju.edu.skill;

import com.nju.edu.sprite.Calabash;

/**
 * 给葫芦娃恢复血量
 * @author Zyi
 */
public class RecoverSkill implements Skill {

    private boolean haveSkill = false;
    private final String skillName = "RecoverSkill";
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
        this.calabash.recover();
    }

    @Override
    public String getName() {
        return this.skillName;
    }
}
