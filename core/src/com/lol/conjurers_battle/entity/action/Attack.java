package com.lol.conjurers_battle.entity.action;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import com.lol.conjurers_battle.entity.Entity;
import com.lol.conjurers_battle.math.FastMath;

public class Attack implements Action {

    private static final float ATTACK_LENGTH = 1.0f;

    private Entity attacker;

    private Vector3 start;
    private Vector3 end;

    private float elapsed = 0;

    private boolean done = false;

    public Attack(Entity attacker, Entity victim) {
        this.attacker = attacker;
        start = attacker.getPosition();
        end = victim.getPosition();
    }

    @Override
    public void update(float dt) {
        elapsed += dt;
        if (elapsed >= ATTACK_LENGTH) {
            done = true;
            this.attacker.setPosition(start);
        }
        if (!done) {
            Vector3 move = FastMath.interpolateLinear(elapsed/ATTACK_LENGTH, start, end);
            attacker.setPosition(move);
        }
    }

    @Override
    public void finish() {
        this.attacker.setPosition(start);
    }

    @Override
    public boolean done() {
        return done;
    }
}
