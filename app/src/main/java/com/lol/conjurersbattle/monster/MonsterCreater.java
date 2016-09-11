package com.lol.conjurersbattle.monster;

import com.lol.conjurersbattle.engines.FightingEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by davidtownsend on 9/10/16.
 */
public class MonsterCreater {
    public List<Monster> createMonsterList() {
        List<Monster> monsters = new ArrayList<Monster>();
        for (int i = 1; i <= 4; i++) {
            Monster monsterOne = new Monster(getRandomNumber(1000), getRandomNumber(500), getRandomNumber(100), getRandomNumber(10000), getRandomElement());
            monsters.add(monsterOne);
        }

        return monsters;
    }

    private Integer getRandomNumber(Integer number) {
        Double range = FightingEngine.maxMultiplier - FightingEngine.minMultiplier + 1;
        return (int) (Math.random() * range) + number;
    }

    private Integer getRandomElement() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
}
