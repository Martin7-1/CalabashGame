package com.nju.edu.skill;

import com.nju.edu.sprite.Calabash;

import java.io.Serializable;

/**
 * 加快葫芦娃的移动能力
 * @author Zyi
 */
public class MoveSkill implements Skill, Serializable {

    private static final long serialVersionUID = 5395347668849596522L;
    private boolean haveSkill = false;
    private final SkillName name = SkillName.MOVE_SKILL;

    @Override
    public boolean isHaveSkill() {
        return this.haveSkill;
    }

    @Override
    public void haveSkill() {
        this.haveSkill = true;
    }

    @Override
    public void start(Calabash calabash) {
        // 加快移动速度
        calabash.speedUp(true);
    }

    @Override
    public SkillName getName() {
        return this.name;
    }
}
