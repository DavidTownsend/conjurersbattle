package com.lol.conjurersbattle.engines;

import com.lol.conjurersbattle.monster.Monster;
import com.lol.conjurersbattle.monster.MonsterCreater;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainEngine {

    //@Inject
    //private MonsterCreater mMonsterCreater;

    public void startTurn() throws Exception {
        MonsterCreater monsterCreater = new MonsterCreater();
        TurnOrderEngine turnOrderEngine = new TurnOrderEngine();
        EnemyPicker enemyPicker = new EnemyPicker();
        FightingEngine fightingEngine = new FightingEngine();
        SkillPicker skillPicker = new SkillPicker();

        List<Monster> myTeam = monsterCreater.createMonsterList();
        List<Monster> enemyTeam = monsterCreater.createMonsterList();
        List<Monster> allMonsters = addBothListsTogether(myTeam, enemyTeam);

        Monster attackMonster = turnOrderEngine.increaseTurnUntilMonsterAttack(allMonsters);
        //Skill skill = skillPicker.pickSkill(attackMonster, myTeam, enemyTeam);

        fightingEngine.doSkill(attackMonster, attackMonster.getSkill1(), myTeam, enemyTeam);
    }

    private List<Monster> addBothListsTogether(List<Monster> myTeam, List<Monster> enemyTeam) {
        List<Monster> allMonsters = new ArrayList<>();

        int id = 0;
        for (int i = 0; i < 4; i++) {
            Monster monster = myTeam.get(i);
            monster.setId(id);
            allMonsters.add(monster);
            id++;
        }

        for (int i = 0; i < 4; i++) {
            Monster monster = enemyTeam.get(i);
            monster.setId(id);
            allMonsters.add(monster);
            id++;
        }

        return allMonsters;
    }
}
