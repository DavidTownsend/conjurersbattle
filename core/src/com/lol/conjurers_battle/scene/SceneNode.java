package com.lol.conjurers_battle.scene;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.List;

public abstract class SceneNode {


    protected Vector3 position = new Vector3();
    protected Quaternion rotation = new Quaternion();
    protected Vector3 scale = new Vector3(1.0f, 1.0f, 1.0f);

    protected List<SceneNode> children = new ArrayList<SceneNode>();

    public abstract void render(RenderCallback renderCallback);
    public abstract void update(float dt);
    public abstract void dispose();

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Vector3 getScale() {
        return scale;
    }

    public void setScale(Vector3 scale) {
        this.scale = scale;
    }

    public Quaternion getRotation() {
        return rotation;
    }

    public void setRotation(Quaternion rotation) {
        this.rotation = rotation;
    }

    public void add(SceneNode node) {
        children.add(node);
    }

}
