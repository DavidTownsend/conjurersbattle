package com.lol.conjurersbattle.engines;

import com.lol.conjurersbattle.monster.Monster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Schimms on 9/10/2016.
 */
public class EnemyPicker {

    public void selectEnemy(Monster attacker, List<Monster> enemies) throws Exception {
        List possibleEnemies = new ArrayList<Monster>();
        for (Monster enemy : enemies) {
            if (attacker.hasElementalAdvantage(enemy.getElement())) {
                possibleEnemies.add(enemy);
            }
        }

        Math.random();
    }
}
