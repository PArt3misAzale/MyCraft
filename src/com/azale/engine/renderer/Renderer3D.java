package com.azale.engine.renderer;

import com.azale.engine.gfx.threedimensional.objects.Cube3D;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Renderer3D {

    public double FOV;

    public void rotateCubeAroundZ(Cube3D obj, double theta){

        double[] rotationX = new double[3];
        rotationX[0] = cos(theta);
        rotationX[1] = -sin(theta);
        rotationX[2] = 0;

        double[] rotationY = new double[3];
        rotationY[0] = sin(theta);
        rotationY[0] = cos(theta);
        rotationY[0] = 0;



    }

}
