package com.lol.conjurersbattle.engines;

import com.lol.conjurersbattle.monster.Monster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Schimms on 9/10/2016.
 */
public class EnemyPicker {
    private final int WATERTYPE = 1;
    private final int FIRETYPE = 2;
    private final int WINDTYPE = 3;

    public void selectEnemy(List<Monster> enemies) {
        List possibleEnemies = new ArrayList<Monster>();
        for (Monster m : enemies) {
            if (m.getElement() == WATERTYPE) {
                possibleEnemies.add(m);
            }
        }

        Math.random();
    }
}
