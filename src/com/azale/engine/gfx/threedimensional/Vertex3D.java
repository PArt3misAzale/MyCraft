package com.azale.engine.gfx.threedimensional;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vertex3D {

    public double length;

    public Vertex3D(Dot3D dot1, Dot3D dot2) {

        length = sqrt( pow( (dot2.getX() - dot1.getX() ), 2) + pow( ( dot2.getY() - dot1.getY() ), 2) + pow( (dot2.getZ() + dot1.getZ()), 2 ));

    }

    /*

    GETTERS AND SETTERS

     */

    public double getLength() {

        return length;

    }
}
