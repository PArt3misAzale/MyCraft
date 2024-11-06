package com.azale.engine.gfx.threedimensional.objects;

import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Object3D;
import com.azale.engine.gfx.threedimensional.Line3D;

public class Cube3D extends Object3D {

    public Line3D[] faces = new Line3D[8];
    public Dot3D[] dots = new Dot3D[8];
    public double width, height = 1;

}
