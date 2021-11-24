package com.nju.edu.skill;

/**
 * @author Zyi
 */
public interface Skill {

    /**
     * 判断当前是否拥有该技能
     * @return true if the calabash have the skill, false otherwise
     */
    boolean isHaveSkill();

    /**
     * 获得该技能
     */
    void haveSkill();
}
