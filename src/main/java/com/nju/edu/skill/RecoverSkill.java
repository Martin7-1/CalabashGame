package com.nju.edu.skill;

/**
 * 给葫芦娃恢复血量
 * @author Zyi
 */
public class RecoverSkill implements Skill {

    private boolean haveSkill = false;
    private final String skillName = "RecoverSkill";

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
        // TODO
    }

    public String getSkillName() {
        return this.skillName;
    }
}
