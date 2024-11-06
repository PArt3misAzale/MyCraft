package com.azale.maingameinfo.game.objects.blocks;

import com.azale.engine.gfx.threedimensional.objects.Cube3D;
import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Vector3D;

public class DirtBlock extends Cube3D {

    Vector3D vertex0;
    Vector3D vertex1;
    Vector3D vertex2;
    Vector3D vertex3;
    Vector3D vertex4;
    Vector3D vertex5;
    Vector3D vertex6;
    Vector3D vertex7;

    /**
     * EXEMPLES
     * <p>If {@link DirtBlock} is at (0,0,0)
     *
     * <p>- {@link Dot3D} of the {@link DirtBlock} :
     * <p>Dot 0 : (0,0,0)
     * <p>Dot 1 : (1,0,0)
     * <p>Dot 2 : (0,1,0)
     * <p>Dot 3 : (1,1,0)
     * <p>Dot 4 : (0,0,1)
     * <p>Dot 5 : (1,0,1)
     * <p>Dot 6 : (0,1,1)
     * <p>Dot 7 : (1,1,1)
     *
     * <p>VARIBALES
     * <p>- {@link Vector3D} of the {@link DirtBlock} :
     * <p>Vertex 0 : ({@code dot0}, {@code dot1})
     * <p>Vertex 1 : ({@code dot2}, {@code dot3})
     * <p>Vertex 2 : ({@code dot4}, {@code dot5})
     * <p>Vertex 3 : ({@code dot6}, {@code dot7})
     * <p>Vertex 4 : ({@code dot0}, {@code dot2})
     * <p>Vertex 5 : ({@code dot1}, {@code dot3})
     * <p>Vertex 6 : ({@code dot4}, {@code dot6})
     * <p>Vertex 7 : ({@code dot5}, {@code dot7})
     *
     * <p>- Dimensions of the {@link DirtBlock} :
     * <p>Width = {@code width}
     * <p>Height = {@code height}
     *
     * <p>PARAMETERS
     * @param dot0
     * @param dot1
     * @param dot2
     * @param dot3
     * @param dot4
     * @param dot5
     * @param dot6
     * @param dot7
     * @param givenWidth
     * @param givenHeight
     */

    public DirtBlock(Dot3D dot0,
                     Dot3D dot1,
                     Dot3D dot2,
                     Dot3D dot3,
                     Dot3D dot4,
                     Dot3D dot5,
                     Dot3D dot6,
                     Dot3D dot7,
                     double givenWidth,
                     double givenHeight) {

        dots[0] = dot0;
        dots[1] = dot1;
        dots[2] = dot2;
        dots[3] = dot3;
        dots[4] = dot4;
        dots[5] = dot5;
        dots[6] = dot6;
        dots[7] = dot7;

        vertex0 = new Vector3D(dot0, dot1);
        vertex1 = new Vector3D(dot2, dot3);
        vertex2 = new Vector3D(dot4, dot5);
        vertex3 = new Vector3D(dot6, dot7);
        vertex4 = new Vector3D(dot0, dot2);
        vertex5 = new Vector3D(dot1, dot3);
        vertex6 = new Vector3D(dot4, dot6);
        vertex7 = new Vector3D(dot5, dot7);

        faces[0] = vertex0;
        faces[1] = vertex1;
        faces[2] = vertex2;
        faces[3] = vertex3;
        faces[4] = vertex4;
        faces[5] = vertex5;
        faces[6] = vertex6;
        faces[7] = vertex7;

        width = givenWidth;
        height = givenHeight;

    }

}
