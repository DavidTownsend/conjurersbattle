package com.lol.conjurersbattle.monster;

import com.lol.conjurersbattle.Effect.Effect;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    private List<Effect> effects = new ArrayList<>();
    private int cooldownMax;
    private int cooldownCurrent;

    public boolean isAvailable() {
        if (cooldownCurrent == 0) {
            return true;
        }
        return false;
    }

    public void addEffect(Effect effect){
        effects.add(effect);
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    public int getCooldownMax() {
        return cooldownMax;
    }

    public void setCooldownMax(int cooldownMax) {
        this.cooldownMax = cooldownMax;
    }

    public int getCooldownCurrent() {
        return cooldownCurrent;
    }

    public void setCooldownCurrent(int cooldownCurrent) {
        this.cooldownCurrent = cooldownCurrent;
    }
}
