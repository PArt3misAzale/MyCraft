package com.azale.engine.gfx.threedimensional.objects;

import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Object3D;
import com.azale.engine.gfx.threedimensional.Vertex3D;

public class Cube3D extends Object3D {

    public Vertex3D[] faces = new Vertex3D[8];
    public Dot3D[] dots = new Dot3D[8];
    public int width, height = 1;

}
