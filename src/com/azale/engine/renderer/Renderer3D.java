package com.azale.engine.renderer;

import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Vector3D;
import com.azale.engine.gfx.threedimensional.objects.Cube3D;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Renderer3D {

    public double FOV;

    public void rotateCubeAroundZ(Cube3D obj, double theta){

        // ROTATION VARIABLES
        double[] rotationX = new double[3];
        rotationX[0] = cos(theta);
        rotationX[1] = -sin(theta);
        rotationX[2] = 0;

        double[] rotationY = new double[3];
        rotationY[0] = sin(theta);
        rotationY[1] = cos(theta);
        rotationY[2] = 0;

        double[] rotationZ = new double[3];
        rotationZ[0] = 0;
        rotationZ[1] = 0;
        rotationZ[2] = 1;

        // COORDINATES
        double[] objX = new double[8];
        objX[0] = obj.getLine(0).getDot(1).getX();
        objX[1] = obj.getLine(1).getDot(1).getX();
        objX[2] = obj.getLine(2).getDot(1).getX();
        objX[3] = obj.getLine(3).getDot(1).getX();
        objX[4] = obj.getLine(4).getDot(1).getX();
        objX[5] = obj.getLine(5).getDot(1).getX();
        objX[6] = obj.getLine(6).getDot(1).getX();
        objX[7] = obj.getLine(7).getDot(1).getX();

        double[] objY = new double[8];
        objY[0] = obj.getLine(0).getDot(1).getY();
        objY[1] = obj.getLine(1).getDot(1).getY();
        objY[2] = obj.getLine(2).getDot(1).getY();
        objY[3] = obj.getLine(3).getDot(1).getY();
        objY[4] = obj.getLine(4).getDot(1).getY();
        objY[5] = obj.getLine(5).getDot(1).getY();
        objY[6] = obj.getLine(6).getDot(1).getY();
        objY[7] = obj.getLine(7).getDot(1).getY();

        // NEW COORDINATES
        double[] objNewX = new double[8];
        objNewX[0] = objX[0] * rotationX[0] + objY[0] * rotationX[1];
        objNewX[1] = objX[1] * rotationX[0] + objY[1] * rotationX[1];
        objNewX[2] = objX[2] * rotationX[0] + objY[2] * rotationX[1];
        objNewX[3] = objX[3] * rotationX[0] + objY[3] * rotationX[1];
        objNewX[4] = objX[4] * rotationX[0] + objY[4] * rotationX[1];
        objNewX[5] = objX[5] * rotationX[0] + objY[5] * rotationX[1];
        objNewX[6] = objX[6] * rotationX[0] + objY[6] * rotationX[1];
        objNewX[7] = objX[7] * rotationX[0] + objY[7] * rotationX[1];

        double[] objNewY = new double[8];
        objNewY[0] = objX[0] * rotationY[0] + objY[0] * rotationY[1];
        objNewY[1] = objX[1] * rotationY[0] + objY[1] * rotationY[1];
        objNewY[2] = objX[2] * rotationY[0] + objY[2] * rotationY[1];
        objNewY[3] = objX[3] * rotationY[0] + objY[3] * rotationY[1];
        objNewY[4] = objX[4] * rotationY[0] + objY[4] * rotationY[1];
        objNewY[5] = objX[5] * rotationY[0] + objY[5] * rotationY[1];
        objNewY[6] = objX[6] * rotationY[0] + objY[6] * rotationY[1];

        obj.setLines(new Vector3D[]{new Vector3D(obj.getLine(0).getDot(0), new Dot3D(objNewX[0], objNewY[0], obj.getLine(0).getDot(1).getZ())),
                new Vector3D(obj.getLine(1).getDot(0), new Dot3D(objNewX[0], objNewY[0], obj.getLine(1).getDot(1).getZ())),
                new Vector3D(obj.getLine(2).getDot(0), new Dot3D(objNewX[0], objNewY[0], obj.getLine(2).getDot(1).getZ())),
                new Vector3D(obj.getLine(3).getDot(0), new Dot3D(objNewX[0], objNewY[0], obj.getLine(3).getDot(1).getZ())),
                new Vector3D(obj.getLine(4).getDot(0), new Dot3D(objNewX[0], objNewY[0], obj.getLine(4).getDot(1).getZ())),
                new Vector3D(obj.getLine(5).getDot(0), new Dot3D(objNewX[0], objNewY[0], obj.getLine(5).getDot(1).getZ())),
                new Vector3D(obj.getLine(6).getDot(0), new Dot3D(objNewX[0], objNewY[0], obj.getLine(6).getDot(1).getZ())),
                new Vector3D(obj.getLine(7).getDot(0), new Dot3D(objNewX[0], objNewY[0], obj.getLine(7).getDot(1).getZ()))});

    }

    public void rotateCubeAroundY(Cube3D obj, double theta){

        double[] rotationX = new double[3];
        rotationX[0] = cos(theta);
        rotationX[1] = 0;
        rotationX[2] = sin(theta);

        double[] rotationY = new double[3];
        rotationY[0] = 0;
        rotationY[1] = 1;
        rotationY[2] = 0;

        double[] rotationZ = new double[3];
        rotationZ[0] = -sin(theta);
        rotationZ[1] = 0;
        rotationZ[2] = cos(theta);

    }

    public void rotateCubeAroundX(Cube3D obj, double theta){

        double[] rotationX = new double[3];
        rotationX[0] = 0;
        rotationX[1] = 0;
        rotationX[2] = 1;

        double[] rotationY = new double[3];
        rotationY[0] = cos(theta);
        rotationY[1] = -sin(theta);
        rotationY[2] = 0;

        double[] rotationZ = new double[3];
        rotationZ[0] = sin(theta);
        rotationZ[1] = cos(theta);
        rotationZ[2] = 0;

    }

}
