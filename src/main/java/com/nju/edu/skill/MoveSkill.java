package com.nju.edu.skill;

/**
 * 加快葫芦娃的移动能力
 * @author Zyi
 */
public class MoveSkill implements Skill {

    private boolean haveSkill = false;
    private final String skillName = "MoveSkill";

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
