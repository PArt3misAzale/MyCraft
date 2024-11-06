package com.azale.engine.games;

import com.azale.engine.AbstractGame;
import com.azale.engine.GameContainer;
import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.renderer.Renderer;
import com.azale.tests.Triangle2D;

public class GameManager extends AbstractGame {

    public GameManager() {


    }


    @Override
    public void update(GameContainer gc, float dt) {


    }

    @Override
    public void render(GameContainer gc, Renderer r) {

        gc.renderer.drawRect(100, 100, 40, 40, 0xffffffff);
        gc.renderer.drawTriangle(new Triangle2D(new Dot3D(20, 0, 0), new Dot3D(40, 40,0), new Dot3D(0, 40, 0)), 100, 100, 0xffff0000);

        gc.renderer.drawRect(200, 100, 40, 40, 0xffffffff);
        gc.renderer.drawFillTriangle(new Triangle2D(new Dot3D(20, 0, 0), new Dot3D(40, 40,0), new Dot3D(0, 40, 0)), 200, 100, 0xffff0000);

    }

    public static void main(String[] args) {

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();

    }
}
