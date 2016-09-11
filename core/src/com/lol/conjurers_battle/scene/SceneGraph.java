package com.lol.conjurers_battle.scene;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class SceneGraph extends SceneNode {

    private ModelBatch modelBatch;
    private Environment environment;
    private Camera camera;

    public SceneGraph() {
        modelBatch = new ModelBatch();
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void render(RenderCallback callback) {
        modelBatch.begin(camera);
        for(SceneNode child : children) {
            child.render(new RenderCallback() {
                @Override
                public void render(ModelInstance model) {
                    modelBatch.render(model, environment);
                }
            });
        }
        modelBatch.end();
    }

    @Override
    public void update(float dt) {
        for(SceneNode child: children) {
            child.update(dt);
        }
    }

    @Override
    public void dispose() {
        for(SceneNode child: children) {
            child.dispose();
        }
        modelBatch.dispose();
    }

}
