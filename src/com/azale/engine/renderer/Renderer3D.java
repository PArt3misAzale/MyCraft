package com.azale.engine.renderer;

import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.objects.Camera;
import com.azale.engine.gfx.threedimensional.objects.Cube3D;
import com.azale.engine.gfx.twodimensional.Dot2D;

public class Renderer3D {

    public double defaultFov;
    public double FOV;

    Camera camera;

    public Renderer3D(Camera camera, double defaultFov) {

        this.defaultFov = defaultFov;
        this.camera = camera;

    }

    public Dot2D[] transformCube3DIn2D(Cube3D cube) {

        // line 2D :
        Dot2D[] dots = new Dot2D[8];

        for (int i = 0; i < 8; i++) {

            dots[i] = new Dot2D(0,0);
            dots[i].setY(LineEquationY(camera.getPosition(), cube.getDot(i), defaultFov));
            dots[i].setX(LineEquationX(camera.getPosition(), cube.getDot(i), defaultFov));

            dots[i].consoleOut();

        }

        return dots;

    }

    public double LineEquationY(Dot3D c, Dot3D m, double x) {

        return ( ( c.getY() - m.getY() ) / ( c.getZ() - m.getZ() ) ) * x + ( ( m.getY() * c.getZ() - c.getY() * m.getZ() ) / ( c.getZ() - m.getZ() ) );

    }

    public double LineEquationX(Dot3D c, Dot3D m, double x) {

        return ( ( c.getX() - m.getX() ) / ( c.getZ() - m.getZ() ) ) * x + ( ( m.getX() * c.getZ() - c.getX() * m.getZ() ) / ( c.getZ() - m.getZ() ) );

    }

}
