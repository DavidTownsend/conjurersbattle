package com.lol.conjurersbattle.engines;

import com.lol.conjurersbattle.monster.Monster;

public class FightingEngine {
    Double maxMultiplier = 1.2;
    Double minMultiplier = .8;

    Integer calculateAttackDamage(Monster attackMonster, Monster defendingMonster) {
        Integer attackDamage = 0;
        Integer attack = attackRange(attackMonster.getAttack());
        attackDamage = attack * (1000 / 3 * defendingMonster.getDefence());
        return attackDamage;
    }

    Integer attackRange(Integer attack) {
        Double range = maxMultiplier - minMultiplier + 1;
        return (int) (Math.random() * range) + attack;
    }
}
