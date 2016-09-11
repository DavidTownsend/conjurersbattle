package com.lol.conjurers_battle.entity;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.lol.conjurers_battle.scene.RenderCallback;
import com.lol.conjurers_battle.scene.SceneNode;

public abstract class Entity extends SceneNode {

    private Model model;
    private ModelInstance instance;

    protected abstract Model build();

    public void init() {
        model = build();
        instance = new ModelInstance(model);
    }

    public void render(RenderCallback renderCallback) {
        instance.transform.set(position, rotation, scale);
        renderCallback.render(instance);
    }

    public void dispose() {
        model.dispose();
    }

    public void update(float dt) { /* don't force children to update */ }

}
