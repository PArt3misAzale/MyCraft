package com.azale.engine.games;

import com.azale.engine.AbstractGame;
import com.azale.engine.GameContainer;
import com.azale.engine.gfx.Image;
import com.azale.engine.gfx.twodimensional.CubeTexture;
import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.objects.Camera;
import com.azale.engine.gfx.twodimensional.Dot2D;
import com.azale.engine.renderer.Renderer;
import com.azale.engine.renderer.Renderer3D;
import com.azale.maingameinfo.game.objects.blocks.DirtBlock;

public class GameManager extends AbstractGame {

    private Renderer3D renderer3D;
    private Camera camera;
    double FOV = 2;

    Image[] dirtImages;
    CubeTexture dirtTexture;

    DirtBlock DIRT_BLOCK = new DirtBlock(new Dot3D(1, 1, 3), 1, 1, 1, dirtTexture);
    Dot2D[] dirtBlockDots;

    public GameManager() {

        camera = new Camera(new Dot3D(0, 1.5, 0));
        renderer3D = new Renderer3D(camera, FOV);

    }


    @Override
    public void update(GameContainer gc, float dt) {

        dirtImages = new Image[1];
        dirtImages[0] = new Image("resources/game/textures/Blocks/DirtBlock.png");

        dirtTexture = new CubeTexture(dirtImages, 0);

        dirtBlockDots = new Dot2D[8];
        dirtBlockDots = renderer3D.transformCube3DIn2D(DIRT_BLOCK);

        System.out.println("Fps : " + gc.fps);

    }

    @Override
    public void render(GameContainer gc, Renderer r) {

        gc.renderer.draw2DCube(dirtBlockDots);

        /*
        gc.renderer.drawRect(100, 100, 40, 40, 0xffffffff);
        gc.renderer.drawTriangle(new Triangle2D(new Dot3D(20, 0, 0), new Dot3D(40, 40,0), new Dot3D(0, 40, 0)), 100, 100, 0xffff0000);

        gc.renderer.drawRect(200, 100, 40, 40, 0xffffffff);
        gc.renderer.drawFillTriangle(new Triangle2D(new Dot3D(20, 0, 0), new Dot3D(40, 40,0), new Dot3D(0, 40, 0)), 200, 100, 0xffff0000);
         */

    }

    public static void main(String[] args) {

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();

    }
}
