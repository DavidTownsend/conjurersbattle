package com.lol.conjurers_battle;

import com.badlogic.gdx.ApplicationListener;
import com.lol.conjurers_battle.scene.battle.BattleScene;
import com.lol.conjurers_battle.scene.Scene;

public class ConjurersBattleGame implements ApplicationListener {

    private Scene scene = new BattleScene();

    @Override
    public void create () {
        scene._init();
    }

    @Override
    public void render () {
        scene._render();
    }

    @Override
    public void dispose () {
        scene._dispose();
    }

    @Override
    public void resume () {
        scene._resume();
    }

    @Override
    public void resize (int width, int height) {
    }

    @Override
    public void pause () {
        scene._pause();
    }

}
