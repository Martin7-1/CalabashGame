package com.nju.edu.skill;

import com.nju.edu.screen.GameScreen;
import com.nju.edu.sprite.Calabash;

import java.io.Serializable;

/**
 * 给葫芦娃恢复血量
 * @author Zyi
 */
public class RecoverSkill implements Skill, Serializable {

    private static final long serialVersionUID = -2234164833341386048L;
    private boolean haveSkill = false;
    private final SkillName name = SkillName.RECOVER_SKILL;

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
        calabash.recover();
    }

    @Override
    public SkillName getName() {
        return this.name;
    }
}
