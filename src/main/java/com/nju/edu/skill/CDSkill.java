package com.nju.edu.skill;

/**
 * 发射子弹间隔时间为0的技能
 * @author Zyi
 */
public class CDSkill implements Skill{

    private boolean haveSkill = false;
    private final String skillName = "CDSkill";

    @Override
    public boolean isHaveSkill() {
        return haveSkill;
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
