package com.lol.conjurersbattle.engines;

import com.lol.conjurersbattle.monster.Monster;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * Created by Schimm on 9/10/2016.
 */
public class EnemyPicker {

    public int selectEnemy(Monster attacker, List<Monster> enemies) throws Exception {
        if (CollectionUtils.isEmpty(enemies)) {
            throw new Exception();
        }

        if (enemies.size() == 1) {
            return enemies.get(0).getId();
        }

        Monster enemyToAttack = enemies.get(0);

        // Intentionally skipping the first enemy because we put the first enemy in enemyToAttack already
        for (int i = 1; i < enemies.size(); i++) {
            Monster enemy = enemies.get(i);
            if (enemy.hasLowHealth()) {
                if (!enemyToAttack.hasLowHealth()) {
                    enemyToAttack = enemy;
                    continue;
                }
                if (attacker.hasElementalAdvantage(enemy.getElement())) {
                    if (!attacker.hasElementalAdvantage(enemyToAttack.getElement())) {
                        enemyToAttack = enemy;
                        continue;
                    }
                }
                if (attacker.hasNeutralElement(enemy.getElement())) {
                    if (!attacker.hasElementalAdvantage(enemy.getElement()) &&
                            !attacker.hasNeutralElement(enemyToAttack.getElement())) {
                        enemyToAttack = enemy;
                        continue;
                    }
                }
            }

            if (attacker.hasElementalAdvantage(enemy.getElement())) {
                if (!attacker.hasElementalAdvantage(enemyToAttack.getElement())) {
                    enemyToAttack = enemy;
                    continue;
                }
            }
            if (attacker.hasNeutralElement(enemy.getElement())) {
                if (!attacker.hasElementalAdvantage(enemy.getElement()) &&
                        !attacker.hasNeutralElement(enemyToAttack.getElement())) {
                    enemyToAttack = enemy;
                    continue;
                }
            }
        }

        return enemyToAttack.getId();
    }
}
