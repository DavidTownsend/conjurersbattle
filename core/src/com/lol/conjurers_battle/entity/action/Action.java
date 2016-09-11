package com.lol.conjurers_battle.entity.action;

public interface Action {

    void update(float dt);
    void finish();
    boolean done();

}
