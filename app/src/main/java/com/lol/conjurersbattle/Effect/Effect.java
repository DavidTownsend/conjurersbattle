package com.lol.conjurersbattle.Effect;

public class Effect {
    public enum BeneficialEffect {
        IMMUNITY, ATTACK, CRIT_RATE, DEFENSE, SPEED, INVINCIBLE, SHIELD, HEAL
    }

    public enum HarmfulEffect {
        BOMB, BRAND, CONTINUOUS_DMG, ATTACK, DEFENSE, SPEED, FREEZE, PROVOKE, SLEEP, SILENCE, STUN
    }

    public enum OtherEffect {
        ADDITIONAL_ATTACK, ADDITIONAL_TURN, ALLY_ATTACK, AOE, CLEANSE, DECREASE_ATTACK_BAR, IGNORE_DEFENSE, INCREASE_ATB, INCREASE_COOLTIME
    }

    public enum ScalesWith {
        ATTACK, DEFENSE, LEVEL, CURRENT_HP, SPEED, MAX_HP
    }

    private double multiplier;
    private int duration;
    private ScalesWith scalesWith;
    private BeneficialEffect beneficialEffect;
    private HarmfulEffect harmfulEffect;
    private OtherEffect otherEffect;
    private boolean damageOpponent = true;
    private int chanceToApply;

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

    public BeneficialEffect getBeneficialEffect() {
        return beneficialEffect;
    }

    public void setBeneficialEffect(BeneficialEffect beneficialEffect) {
        this.beneficialEffect = beneficialEffect;
    }

    public HarmfulEffect getHarmfulEffect() {
        return harmfulEffect;
    }

    public void setHarmfulEffect(HarmfulEffect harmfulEffect) {
        this.harmfulEffect = harmfulEffect;
    }

    public OtherEffect getOtherEffect() {
        return otherEffect;
    }

    public void setOtherEffect(OtherEffect otherEffect) {
        this.otherEffect = otherEffect;
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
}
