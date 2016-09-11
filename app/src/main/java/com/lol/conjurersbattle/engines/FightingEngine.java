package com.lol.conjurersbattle.engines;

public class FightingEngine {
    public static final Double maxMultiplier = 1.2;
    public static final Double minMultiplier = .8;

    public Integer calculateAttackDamage(Integer attackDamage, Integer defendingDefense) {
        Integer calculatedDamage = 0;
        Integer attack = attackRange(attackDamage);
        calculatedDamage = (int) (attack * 1000.0 / (3.0 * defendingDefense));
        return calculatedDamage;
    }

    private Integer attackRange(Integer attack) {
        Double range = (maxMultiplier - minMultiplier) * attack;
        return (int) (Math.random() * range) + attack;
    }
}
