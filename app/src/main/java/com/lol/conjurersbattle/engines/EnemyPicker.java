package com.lol.conjurersbattle.engines;

import com.lol.conjurersbattle.monster.Monster;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Schimms on 9/10/2016.
 */
public class EnemyPicker {

    public int selectEnemy(Monster attacker, List<Monster> enemies) throws Exception {
        List<Monster> advantageEnemies = new ArrayList<>();
        List<Monster> neutralEnemies = new ArrayList<>();
        List<Monster> disadvantageEnemies = new ArrayList<>();
        for (Monster enemy : enemies) {
            if (attacker.hasElementalAdvantage(enemy.getElement())) {
                advantageEnemies.add(enemy);
            } else if (attacker.hasNeutralElement(enemy.getElement())) {
                neutralEnemies.add(enemy);
            } else if (attacker.hasDisadvantageElement(enemy.getElement())) {
                disadvantageEnemies.add(enemy);
            }
        }

        if (CollectionUtils.isNotEmpty(advantageEnemies)) {
            Random rand = new Random();

            return rand.nextInt(advantageEnemies.size()) + 1;
        }

        if (CollectionUtils.isNotEmpty(advantageEnemies)) {
            Random rand = new Random();

            return rand.nextInt(advantageEnemies.size()) + 1;
        }

        if (CollectionUtils.isNotEmpty(advantageEnemies)) {
            Random rand = new Random();

            return rand.nextInt(advantageEnemies.size()) + 1;
        }

        throw new Exception();
    }
}
