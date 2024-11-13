package com.azale.engine.gfx.threedimensional;

public class Dot3D {

    public double x, y, z, w;

    public Dot3D(double givenX, double givenY, double givenZ) {

        x = givenX;
        y = givenY;
        z = givenZ;
        w = 1;

    }

    public Vector3D subtractDots(Dot3D dot) {

        return new Vector3D(new Dot3D(0, 0, 0), new Dot3D(getX() - dot.getX(), getY() - dot.getY(), getZ() - dot.getZ()));

    }

    public void consoleOut() {

        System.out.println("( " + getX() + " , " + getY() + " , " + getZ() + " )");

    }

    /*

    GETTERS AND SETTERS

     */

    public double getX() {

        return x;
    }


    public double getY() {

        return y;

    }

    public double getZ() {

        return z;

    }

    public void setX(double x) {

        this.x = x;

    }

    public void setY(double y) {

        this.y = y;

    }

    public void setZ(double z) {

        this.z = z;

    }
}
