package com.lol.conjurersbattle.monster;

import com.lol.conjurersbattle.common.Element;
import com.lol.conjurersbattle.engines.FightingEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MonsterCreater {
    public List<Monster> createMonsterList() {
        SkillCreator skillCreator = new SkillCreator();
        List<Monster> monsters = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Monster monsterOne = new Monster(getRandomNumber(1000), getRandomNumber(500), getRandomNumber(100), getRandomNumber(10000), getRandomElement());
            monsterOne.setSkill1(skillCreator.createWindyCutSkill());
            monsterOne.setSkill2(skillCreator.createTwisterSkill());
            monsterOne.setSkill3(skillCreator.createForceField());
            monsters.add(monsterOne);
        }

        return monsters;
    }

    private Integer getRandomNumber(Integer number) {
        Double range = (FightingEngine.maxMultiplier - FightingEngine.minMultiplier) * number;
        return (int) (Math.random() * range) + number;
    }

    private Element getRandomElement() {
        List<Element.ElementType> elements = Collections.unmodifiableList(Arrays.asList(Element.ElementType.values()));
        Random random = new Random();
        Element.ElementType elementType = elements.get(random.nextInt(elements.size()));
        Element element = new Element();
        element.setElementType(elementType);
        return element;
    }
}
