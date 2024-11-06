package com.azale.engine.gfx.threedimensional;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vector3D {

    public double length;
    public double[] vector = new double[3];
    public double x, y, z;

    public Dot3D firstDot;
    public Dot3D secondDot;

    /**
     * EXEMPLES
     * <p>If {@code dot1} = (1,2,3) and {@code dot2} = (4,5,6) :
     *
     * <p>{@code vector[0]} = 4 - 1 = 3
     * <p>{@code vector[1]} = 5 - 2 = 3
     * <p>{@code vector[1]} = 6 - 3 = 3
     * <p>{@code vector} = [3,3,3]
     *
     * <p>VARIABLES
     * <p>Length of the {@link Vector3D} : {@code length}
     *
     * <p>PARAMETERS
     * @param dot1
     * @param dot2
     */

    public Vector3D(Dot3D dot1, Dot3D dot2) {

        firstDot = dot1;
        secondDot = dot2;

        vector[0] = dot2.getX() - dot1.getX();
        vector[1] = dot2.getY() - dot1.getY();
        vector[2] = dot2.getZ() - dot1.getZ();

        length = sqrt( pow( vector[0], 2) + pow( vector[1], 2) + pow( vector[2], 2) );

    }

    public Dot3D getDot(int dot) {

        Dot3D returnVariable = null;

        if (dot == 0) {

            returnVariable = firstDot;

        } else if (dot == 1) {

            returnVariable = secondDot;

        }

        return returnVariable;

    }

    /*

    GETTERS AND SETTERS

     */

    /**
     * @return {@code length}
     */
    public double getLength() {

        return length;

    }
}
