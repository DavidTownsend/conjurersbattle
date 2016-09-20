package com.lol.conjurersbattle.Effect;

public class Effect {
    public enum EffectType {
        IMMUNITY, ATTACK_BUFF, CRIT_RATE, DEFENSE_BUFF, SPEED_BUFF, INVINCIBLE, SHIELD, HEAL, BOMB, BRAND, CONTINUOUS_DMG, ATTACK_DEBUFF, DEFENSE_DEBUFF,
        SPEED_DEBUFF, FREEZE, PROVOKE, SLEEP, SILENCE, STUN, DDITIONAL_ATTACK, ADDITIONAL_TURN, ALLY_ATTACK, CLEANSE,
        DECREASE_ATTACK_BAR, IGNORE_DEFENSE, INCREASE_ATB, INCREASE_COOLTIME
    }

    public enum ScalesWith {
        ATTACK, DEFENSE, LEVEL, CURRENT_HP, SPEED, MAX_HP
    }

    private double multiplier;
    private int duration;
    private ScalesWith scalesWith;
    private EffectType effectType;
    private boolean damageOpponent = true;
    private int chanceToApply;
    private boolean aoe;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ScalesWith getScalesWith() {
        return scalesWith;
    }

    public void setScalesWith(ScalesWith scalesWith) {
        this.scalesWith = scalesWith;
    }

    public boolean isDamageOpponent() {
        return damageOpponent;
    }

    public void setDamageOpponent(boolean damageOpponent) {
        this.damageOpponent = damageOpponent;
    }

    public int getChanceToApply() {
        return chanceToApply;
    }

    public void setChanceToApply(int chanceToApply) {
        this.chanceToApply = chanceToApply;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public boolean isAoe() {
        return aoe;
    }

    public void setAoe(boolean aoe) {
        this.aoe = aoe;
    }
}
