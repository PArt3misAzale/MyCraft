package com.azale.engine.gfx.threedimensional.objects;

import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Object3D;
import com.azale.engine.gfx.threedimensional.Vector3D;

public class Cube3D extends Object3D {

    public Vector3D[] lines = new Vector3D[8];
    public Dot3D[] dots = new Dot3D[8];
    public double width, height = 1;

    /*

    GETTERS AND SETTERS

     */

    public Vector3D getLine(int i) {

        return lines[i];

    }

    public Vector3D[] getLines() {

        return lines;

    }

    public void setLines(Vector3D[] lines) {

        this.lines = lines;

    }
}
