package com.lol.conjurersbattle.monster;

import com.lol.conjurersbattle.Effect.Effect;
import com.lol.conjurersbattle.common.Element;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private Integer id;
    private Integer level;
    private Integer attack;
    private Integer defense;
    private Integer speed;
    private Integer currentHp;
    private Integer maxHp;
    private Element element;
    private Integer attackTurnSpeed;
    private Skill skill1;
    private Skill skill2;
    private Skill skill3;
    private List<Effect> effects = new ArrayList<>();
    private String name;

    public Monster(Integer attack, Integer defense, Integer speed, Integer maxHp, Element element) {
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.element = element;
        this.attackTurnSpeed = 0;
    }

    public boolean hasLowHealth() {
        if (currentHpPercent() < .3) {
            return true;
        }

        return false;
    }

    public double currentHpPercent() {
        return currentHp / maxHp;
    }

    public void addEffect(Effect effect){
        effects.add(effect);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getdefense() {
        return defense;
    }

    public void setdefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Integer getAttackTurnSpeed() {
        return attackTurnSpeed;
    }

    public void setAttackTurnSpeed(Integer attackTurnSpeed) {
        this.attackTurnSpeed = attackTurnSpeed;
    }

    public Integer getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(Integer currentHp) {
        this.currentHp = currentHp;
    }

    public Integer getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
    }

    public Skill getSkill3() {
        return skill3;
    }

    public void setSkill3(Skill skill3) {
        this.skill3 = skill3;
    }

    public Skill getSkill1() {
        return skill1;
    }

    public void setSkill1(Skill skill1) {
        this.skill1 = skill1;
    }

    public Skill getSkill2() {
        return skill2;
    }

    public void setSkill2(Skill skill2) {
        this.skill2 = skill2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
