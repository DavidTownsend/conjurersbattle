package com.lol.conjurersbattle.engines;

import com.lol.conjurersbattle.Effect.Effect;
import com.lol.conjurersbattle.monster.Skill;
import com.lol.conjurersbattle.monster.Monster;

import java.util.List;
import java.util.Random;

public class FightingEngine {
    public static final Double maxMultiplier = 1.2;
    public static final Double minMultiplier = .8;

    public Integer calculateAttackDamage(Integer attackDamage, Integer defendingDefense, Double skillMultiplier) {
        Integer calculatedDamage = 0;
        attackDamage = (int) (attackDamage * skillMultiplier);
        Integer attack = attackRange(attackDamage);
        calculatedDamage = (int) (attack * 1000.0 / (3.0 * defendingDefense));
        return calculatedDamage;
    }

    private Integer attackRange(Integer attack) {
        Double range = (maxMultiplier - minMultiplier) * attack;
        return (int) (Math.random() * range) + attack;
    }

    public void doSkill(Monster attackingMonster, Skill skillPicked, List<Monster> allies, List<Monster> enemies) throws Exception {
        EnemyPicker enemyPicker = new EnemyPicker();
        Monster defendingMonster = enemyPicker.selectEnemy(attackingMonster, enemies);
        doEffect(attackingMonster.getSkill1().getEffects().get(0), attackingMonster, defendingMonster, allies, enemies);
        doEffect(attackingMonster.getSkill2().getEffects().get(0), attackingMonster, defendingMonster, allies, enemies);
        doEffect(attackingMonster.getSkill2().getEffects().get(1), attackingMonster, defendingMonster, allies, enemies);
        doEffect(attackingMonster.getSkill3().getEffects().get(0), attackingMonster, defendingMonster, allies, enemies);
    }

    public void doEffect(Effect effect, Monster attackingMonster, Monster targetMonster, List<Monster> allies, List<Monster> enemies) {
        Effect.BeneficialEffect beneficialEffect = effect.getBeneficialEffect();
        Effect.HarmfulEffect harmfulEffect = effect.getHarmfulEffect();
        Effect.OtherEffect otherEffect = effect.getOtherEffect();

        if (beneficialEffect != null) {
            if (beneficialEffect == Effect.BeneficialEffect.HEAL) {
                if (otherEffect != null && otherEffect == Effect.OtherEffect.AOE) {
                    for (Monster monster : allies){
                        if(effect.getScalesWith() == Effect.ScalesWith.MAX_HP){
                            Integer healedAmount = (int) (monster.getMaxHp() * (Double.valueOf(effect.getMultiplier()) / 100.0 ));
                            Integer healedToHp = monster.getCurrentHp() + healedAmount;
                            monster.setCurrentHp(healedToHp > monster.getMaxHp() ? monster.getMaxHp() : healedToHp);
                        }
                    }
                } else {
                    //HEAL Target Monster
                }
            }
            if (beneficialEffect == Effect.BeneficialEffect.SHIELD) {
                if (otherEffect != null && otherEffect == Effect.OtherEffect.AOE) {

                    //AOE SHIELD TEAM
                    Integer level = 40;
                    if(effect.getScalesWith() == Effect.ScalesWith.LEVEL){
                        level = attackingMonster.getLevel();
                    }


                    Effect effectMonster = new Effect();
                    effectMonster.setDuration(effect.getDuration());
                    // need to set amount
                    // effectMonster.
                    for (Monster monster : allies){
                        monster.addEffect(effectMonster);
                    }
                } else {
                    //SHIELD target monster
                }
            }
        }

        if (harmfulEffect != null) {
            if (otherEffect != null) {

            } else {
                if (harmfulEffect == Effect.HarmfulEffect.CONTINUOUS_DMG) {
                    if (successfulToApply(effect.getChanceToApply())) {
                        //Apply Effect to Defending Monster
                    }
                }
            }
        }


        if (effect.isDamageOpponent()) {
            if (otherEffect != null) {
                if (otherEffect == Effect.OtherEffect.AOE) {
                    //DO AOE DAMGE
                } else {
                    //DO SINGLE target damage
                }
            }
            //DO Single Target Damage
        }
    }

    private boolean successfulToApply(int chance) {
        boolean successful = false;

        Random random = new Random();
        if (random.nextInt(100) <= chance) {
            successful = true;
        }

        return successful;
    }
}
