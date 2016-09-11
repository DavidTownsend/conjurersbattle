package com.lol.conjurers_battle.scene.battle;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Timer;
import com.lol.conjurers_battle.entity.Enemy;
import com.lol.conjurers_battle.entity.Minion;
import com.lol.conjurers_battle.entity.action.Attack;
import com.lol.conjurers_battle.scene.Scene;

import java.util.ArrayList;
import java.util.List;

public class BattleScene extends Scene {

    private static final int NUM_MINIONS = 4;
    private static final int NUM_ENEMIES = 4;

    private static final Vector3[] MINION_POSITIONS = new Vector3[] {
        new Vector3(-8, 0, 0),
        new Vector3(-10, 0, -2),
        new Vector3(-10, 0, 2),
        new Vector3(-12, 0, 0)
    };

    private List<Minion> minions = new ArrayList<Minion>(NUM_MINIONS);
    private List<Enemy> enemies = new ArrayList<Enemy>(NUM_ENEMIES);

    private Attack attack;
    private AttackTask attackTask;

    @Override
    public void init() {
        camera.position.set(-17f, 7f, 7f);
        camera.lookAt(0,0,0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

        for(int i = 0; i < NUM_MINIONS; i++) {
            Minion minion = new Minion();
            minion.init();
            minion.setPosition(MINION_POSITIONS[i]);
            minions.add(minion);
            sceneGraph.add(minion);
        }

        for(int i = 0; i < NUM_ENEMIES; i++) {
            Enemy enemy = new Enemy();
            enemy.init();
            enemy.setPosition(new Vector3(10, 0, i * 2 * ((i%2 == 0) ? 1 : -1)));
            enemies.add(enemy);
            sceneGraph.add(enemy);
        }

        attackTask = new AttackTask();
        timer.scheduleTask(attackTask, 1, 1);
    }

    @Override
    protected void update(float dt) {
        if(attack != null) attack.update(dt);
    }

    @Override
    public void dispose() {

    }

    class AttackTask extends Timer.Task {

        @Override
        public void run() {
            Minion minion = minions.get((int) (Math.random() * minions.size()));
            Enemy enemy = enemies.get((int) (Math.random() * enemies.size()));
            if (attack != null) attack.finish();
            if (Math.round(Math.random()) > 0) attack = new Attack(minion, enemy);
            else attack = new Attack(enemy, minion);
        }
    }

}
