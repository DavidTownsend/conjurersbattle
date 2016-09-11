package com.lol.conjurersbattle.engines;

import com.lol.conjurersbattle.monster.Monster;

public class FightingEngine {
    public static final Double maxMultiplier = 1.2;
    public static final Double minMultiplier = .8;

    public Integer calculateAttackDamage(Monster attackMonster, Monster defendingMonster) {
        Integer attackDamage = 0;
        Integer attack = attackRange(attackMonster.getAttack());
        attackDamage = attack * (1000 / (3 * defendingMonster.getDefence()));
        return attackDamage;
    }

    private Integer attackRange(Integer attack) {
        Double range = maxMultiplier - minMultiplier + 1;
        return (int) (Math.random() * range) + attack;
    }
}
