package com.azale.engine.gfx.twodimensional.objects;

import com.azale.engine.gfx.threedimensional.objects.Cube3D;
import com.azale.engine.gfx.twodimensional.Dot2D;
import com.azale.engine.gfx.twodimensional.Object2D;

public class Cube2D extends Object2D {

    Dot2D[] dots = new Dot2D[8];

    public Cube2D(Cube3D cube, String depth) {

        if (depth == "x") {



        } else if (depth == "y") {



        } else if (depth == "z") {

            dots[0] = new Dot2D(cube.getLine(0).getDot(0).getX(), cube.getLine(0).getDot(0).getY());
            dots[1] = new Dot2D(cube.getLine(1).getDot(0).getX(), cube.getLine(1).getDot(0).getY());
            dots[2] = new Dot2D(cube.getLine(2).getDot(0).getX(), cube.getLine(2).getDot(0).getY());
            dots[3] = new Dot2D(cube.getLine(3).getDot(0).getX(), cube.getLine(3).getDot(0).getY());

        }

    }

}
