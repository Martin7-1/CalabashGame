package com.nju.edu.skill;

/**
 * 给葫芦娃恢复血量
 * @author Zyi
 */
public class RecoverSkill implements Skill {

    private boolean haveSkill = false;

    @Override
    public boolean isHaveSkill() {
        return this.haveSkill;
    }

    @Override
    public void haveSkill() {
        this.haveSkill = true;
    }
}
