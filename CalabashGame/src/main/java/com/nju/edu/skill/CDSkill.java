package com.nju.edu.skill;

import com.nju.edu.sprite.Calabash;

import java.io.Serializable;

/**
 * 发射子弹间隔时间为0的技能
 * @author Zyi
 */
public class CDSkill implements Skill, Serializable {

    private static final long serialVersionUID = 7123129952830057508L;

    private boolean haveSkill = false;
    private final SkillName name = SkillName.CD_SKILL;
    private Calabash calabash = Calabash.getInstance();

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
        calabash.setFireInterval(80);
    }

    @Override
    public SkillName getName() {
        return this.name;
    }
}
