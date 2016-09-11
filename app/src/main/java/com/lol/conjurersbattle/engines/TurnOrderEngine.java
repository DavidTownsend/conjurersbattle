package com.lol.conjurersbattle.engines;

import com.lol.conjurersbattle.monster.Monster;

import java.util.List;

public class TurnOrderEngine {
    private Monster calculateFastestMonster(List<Monster> monsters) {
        Monster fastestMonster = new Monster();

        for (Monster monster : monsters) {
            if (fastestMonster.getAttackTurnSpeed() != null) {
                if (monster.getAttackTurnSpeed() > fastestMonster.getAttackTurnSpeed()) {
                    fastestMonster = monster;
                }
            } else {
                fastestMonster = monster;
            }
        }

        return fastestMonster;
    }

    private void increaseTurn(List<Monster> monsters) {
        for (Monster monster : monsters) {
            Integer attackTurnSpeed = 0;
            attackTurnSpeed += monster.getAttackTurnSpeed() / 100 + 10;
            monster.setAttackTurnSpeed(attackTurnSpeed);
        }
    }

    private Monster monsterToGo(List<Monster> monsters) {
        Monster monster = calculateFastestMonster(monsters);
        if (monster.getAttackTurnSpeed() > 100) {
            return monster;
        }

        return null;
    }

    public Monster increaseTurnUntilMonsterAttack(List<Monster> monsters) {
        Monster monsterToGo = null;

        do {
            monsterToGo = monsterToGo(monsters);
            if (monsterToGo != null) {
                increaseTurn(monsters);
            }
        } while (monsterToGo.equals(null));

        return monsterToGo;
    }
}
