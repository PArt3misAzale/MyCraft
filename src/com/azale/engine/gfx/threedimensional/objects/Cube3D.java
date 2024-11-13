package com.azale.engine.gfx.threedimensional.objects;

import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Object3D;
import com.azale.engine.gfx.threedimensional.Vector3D;

public class Cube3D extends Object3D {

    public Vector3D[] vectors = new Vector3D[12];;
    public Dot3D[] dots = new Dot3D[8];
    public double width, height, depth = 1;

    /*

    GETTERS AND SETTERS

     */

    public Vector3D getLine(int i) {

        return vectors[i];

    }

    public Vector3D[] getLines() {

        return vectors;

    }

    public void setLines(Vector3D[] lines) {

        this.vectors = lines;

    }

    public Dot3D[] getDots() {

        return dots;

    }

    public Dot3D getDot(int i) {

        return dots[i];

    }
}
