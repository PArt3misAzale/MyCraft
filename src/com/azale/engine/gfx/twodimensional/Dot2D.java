package com.azale.engine.gfx.twodimensional;

public class Dot2D {

    double x, y, w;

    public Dot2D(double givenX, double givenY) {

        x = givenX;
        y = givenY;
        w = 1;

    }

    public void consoleOut() {

        System.out.println("( " + getX() + " , " + getY() + " )");

    }

    public Dot2D resize(int scale) {

        this.x = this.x * scale;
        this.y = this.y * scale;

        return this;

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

    public void setX(double x) {

        this.x = x;

    }

    public void setY(double y) {

        this.y = y;

    }
}
