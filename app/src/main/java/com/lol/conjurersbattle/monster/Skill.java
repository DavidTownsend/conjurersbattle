package com.lol.conjurersbattle.monster;

/**
 * Created by Schimm on 9/10/2016.
 */
public class Skill {
    public enum SkillType {
        ATTACK, HEAL, BUFF, DEBUFF, ATTACK_DEBUFF, BUFF_ATTACK, ATTACK_HEAL, HEAL_DEBUFF
    }

    public enum StatType {
        HP, DEFENSE, ATTACK, SPEED
    }

    double dmgMultiplier;
    StatType dmgStat;
    double healMultiplier;
    StatType healStat;
    SkillType skillType;
    Integer cooldownMax;
    Integer cooldownCurrent;

    public Skill (SkillType skillType, double dmgMultiplier, StatType dmgStat,
                  double healMultiplier, StatType healStat) {
        this.skillType = skillType;
        this.dmgMultiplier = dmgMultiplier;
        this.dmgStat = dmgStat;
        this.healMultiplier = healMultiplier;
        this.healStat = healStat;
    }

    public boolean isHeal() {
        if (skillType == SkillType.HEAL || skillType == SkillType.ATTACK_HEAL ||
                skillType == SkillType.HEAL_DEBUFF) {
            return true;
        }
        return false;
    }

    public boolean isAvailable() {
        if (cooldownCurrent == 0) {
            return true;
        }
        return false;
    }

    public double getDmgMultiplier() {
        return dmgMultiplier;
    }

    public void setDmgMultiplier(double dmgMultiplier) {
        this.dmgMultiplier = dmgMultiplier;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public StatType getDmgStat() {
        return dmgStat;
    }

    public void setDmgStat(StatType dmgStat) {
        this.dmgStat = dmgStat;
    }

    public double getHealMultiplier() {
        return healMultiplier;
    }

    public void setHealMultiplier(double healMultiplier) {
        this.healMultiplier = healMultiplier;
    }

    public StatType getHealStat() {
        return healStat;
    }

    public void setHealStat(StatType healStat) {
        this.healStat = healStat;
    }

    public Integer getCooldownMax() {
        return cooldownMax;
    }

    public void setCooldownMax(Integer cooldownMax) {
        this.cooldownMax = cooldownMax;
    }

    public Integer getCooldownCurrent() {
        return cooldownCurrent;
    }

    public void setCooldownCurrent(Integer cooldownCurrent) {
        this.cooldownCurrent = cooldownCurrent;
    }
}
