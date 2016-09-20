package com.lol.conjurersbattle.monster;

import com.lol.conjurersbattle.Effect.Effect;

public class SkillCreator {
    public Skill createWindyCutSkill() {
        Skill skill = new Skill();
        Effect effect = new Effect();
        effect.setEffectType(Effect.EffectType.CONTINUOUS_DMG);
        effect.setScalesWith(Effect.ScalesWith.ATTACK);
        effect.setMultiplier(3.7);
        effect.setDamageOpponent(true);
        effect.setChanceToApply(30);
        skill.addEffect(effect);
        skill.setCooldownCurrent(0);
        skill.setCooldownMax(0);
        return skill;
    }

    public Skill createTwisterSkill() {

        Skill skill = new Skill();
        Effect effect = new Effect();
        effect.setAoe(true);
        effect.setScalesWith(Effect.ScalesWith.ATTACK);
        effect.setMultiplier(2.6);
        effect.setDamageOpponent(true);
        skill.addEffect(effect);

        Effect effect2 = new Effect();
        effect2.setEffectType(Effect.EffectType.HEAL);
        effect2.setAoe(true);
        effect2.setScalesWith(Effect.ScalesWith.MAX_HP);
        effect2.setMultiplier(10);
        effect2.setDamageOpponent(false);
        skill.addEffect(effect2);
        skill.setCooldownCurrent(0);
        skill.setCooldownMax(3);
        return skill;
    }

    public Skill createForceField() {
        Skill skill = new Skill();
        Effect effect = new Effect();
        effect.setEffectType(Effect.EffectType.SHIELD);
        effect.setAoe(true);
        effect.setScalesWith(Effect.ScalesWith.LEVEL);
        effect.setMultiplier(75);
        effect.setDamageOpponent(false);
        skill.addEffect(effect);
        skill.setCooldownCurrent(0);
        skill.setCooldownMax(5);

        return skill;
    }
}
