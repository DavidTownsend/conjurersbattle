package com.lol.conjurers_battle.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.utils.Timer;

public abstract class Scene {

    private static final float TIMER_RESOLUTION = 1000.0f;

    protected Environment environment;
    protected PerspectiveCamera camera;

    protected SceneGraph sceneGraph;

    protected CameraInputController camController;

    protected Timer timer;

    private boolean paused = false;

    protected abstract void dispose();
    protected abstract void init();
    protected abstract void update(float dt);

    public void _init() {
        timer = new Timer();

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(camController);

        sceneGraph = new SceneGraph();
        sceneGraph.setCamera(camera);
        sceneGraph.setEnvironment(environment);

        init();
    }

    public void _render() {
        camController.update();

        if(!paused) {
            float dt = Gdx.graphics.getDeltaTime();
            update(dt);
            sceneGraph.update(dt);
        }

        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        sceneGraph.render(null);
    }

    public void _dispose() {
        sceneGraph.dispose();
        dispose();
    }

    public void _pause() {
        paused = true;
    }

    public void _resume() {
        paused = false;
    }

}
