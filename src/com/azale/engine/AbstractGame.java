package com.azale.engine;

import com.azale.engine.renderer.Renderer;

public abstract class AbstractGame {

    public abstract void update(GameContainer gc, float dt);

    public abstract void render(GameContainer gc, Renderer r);

}
