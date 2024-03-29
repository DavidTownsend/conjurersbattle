package com.lol.conjurersbattle.engines;

import com.lol.conjurersbattle.monster.Monster;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * Created by Schimm on 9/10/2016.
 */
public class EnemyPicker {

    public Monster selectEnemy(Monster attacker, List<Monster> enemies) throws Exception {
        if (CollectionUtils.isEmpty(enemies)) {
            throw new Exception();
        }

        if (enemies.size() == 1) {
            return enemies.get(0);
        }

        Monster enemyToAttack = enemies.get(0);

        // Intentionally skipping the first enemy because we put the first enemy in enemyToAttack already
        for (Monster enemy : enemies) {
            if (enemy.getId() == enemyToAttack.getId()) {
                continue;
            }
            if (enemy.hasLowHealth()) {
                if (!enemyToAttack.hasLowHealth()) {
                    enemyToAttack = enemy;
                    continue;
                }
                if (attacker.getElement().hasElementalAdvantage(enemy.getElement().getElementType())) {
                    if (!attacker.getElement().hasElementalAdvantage(enemyToAttack.getElement().getElementType())) {
                        enemyToAttack = enemy;
                        continue;
                    }
                }
                if (attacker.getElement().hasNeutralElement(enemy.getElement().getElementType())) {
                    if (!attacker.getElement().hasElementalAdvantage(enemy.getElement().getElementType()) &&
                            !attacker.getElement().hasNeutralElement(enemyToAttack.getElement().getElementType())) {
                        enemyToAttack = enemy;
                        continue;
                    }
                }
            }

            if (attacker.getElement().hasElementalAdvantage(enemy.getElement().getElementType())) {
                if (!attacker.getElement().hasElementalAdvantage(enemyToAttack.getElement().getElementType())) {
                    enemyToAttack = enemy;
                    continue;
                }
            }
            if (attacker.getElement().hasNeutralElement(enemy.getElement().getElementType())) {
                if (!attacker.getElement().hasElementalAdvantage(enemy.getElement().getElementType()) &&
                        !attacker.getElement().hasNeutralElement(enemyToAttack.getElement().getElementType())) {
                    enemyToAttack = enemy;
                    continue;
                }
            }
        }

        return enemyToAttack;
    }
}
