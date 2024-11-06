package com.azale.tests;

import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Vector3D;
import com.azale.engine.gfx.threedimensional.objects.Triangle;

public class Triangle2D extends Triangle {

    public Triangle2D(Dot3D dot0, Dot3D dot1, Dot3D dot2) {

        dots[0] = dot0;
        dots[1] = dot1;
        dots[2] = dot2;

        lines[0] = new Vector3D(dot0, dot1);
        lines[1] = new Vector3D(dot1, dot2);
        lines[2] = new Vector3D(dot2, dot0);

    }

    public int getVectorEquation2D(Vector3D vect, int x) {

        int fY;

        fY = (int)(( (vect.getDot(1).getY() - vect.getDot(0).getY()) / (vect.getDot(1).getX() - vect.getDot(0).getX()) ) * (x - vect.getDot(0).getX()) + vect.getDot(0).getY()) ;

        return fY;

    }

    public int getMaxX() {

        int maxX;

        if ( dots[0].getX() > dots[1].getX() && dots[0].getX() > dots[2].getX()) {

            maxX = (int)dots[0].getX();

        } else if ( dots[0].getX() < dots[1].getX() && dots[1].getX() > dots[2].getX()) {

            maxX = (int)dots[1].getX();

        } else {

            maxX = (int)dots[2].getX();

        }

        return maxX;

    }

    public int getMaxY() {

        int maxY;

        if ( dots[0].getY() > dots[1].getY() && dots[0].getY() > dots[2].getY()) {

            maxY = (int)dots[0].getY();

        } else if ( dots[0].getY() < dots[1].getY() && dots[1].getY() > dots[2].getY()) {

            maxY = (int)dots[1].getY();

        } else {

            maxY = (int)dots[2].getY();

        }

        return maxY;

    }

}
