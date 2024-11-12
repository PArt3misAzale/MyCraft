package com.azale.maingameinfo.game.objects.blocks;

import com.azale.engine.gfx.twodimensional.CubeTexture;
import com.azale.engine.gfx.threedimensional.objects.Cube3D;
import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Vector3D;

public class DirtBlock extends Cube3D {

    CubeTexture textures;

    Dot3D originDot;

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

    public DirtBlock(Dot3D originDot,
                     double width,
                     double height,
                     double depth,
                     CubeTexture textures) {

        this.width = width;
        this.height = height;
        this.depth = depth;

        this.originDot = originDot;

        this.dots[0] = originDot;
        this.dots[1] = new Dot3D(originDot.getX() + this.width, originDot.getY(), originDot.getZ());
        this.dots[2] = new Dot3D(originDot.getX() + this.width, originDot.getY() + this.height, originDot.getZ());
        this.dots[3] = new Dot3D(originDot.getX(), originDot.getY() + height, originDot.getZ());
        this.dots[4] = new Dot3D(originDot.getX(), originDot.getY(), originDot.getZ() + this.depth);
        this.dots[5] = new Dot3D(originDot.getX() + this.width , originDot.getY(), originDot.getZ() + this.depth);;
        this.dots[6] = new Dot3D(originDot.getX() + this.width, originDot.getY() + this.height, originDot.getZ() + this.depth);;
        this.dots[7] = new Dot3D(originDot.getX(), originDot.getY() + this.height, originDot.getZ() + this.depth);;

        // XY
        this.vectors[0] = new Vector3D(dots[0], dots[1]);
        this.vectors[1] = new Vector3D(dots[1], dots[2]);
        this.vectors[2] = new Vector3D(dots[2], dots[3]);
        this.vectors[3] = new Vector3D(dots[3], dots[0]);

        // ZY
        this.vectors[4] = new Vector3D(dots[0], dots[4]);
        this.vectors[5] = new Vector3D(dots[1], dots[5]);
        this.vectors[6] = new Vector3D(dots[2], dots[6]);
        this.vectors[7] = new Vector3D(dots[3], dots[7]);

        // ZX
        this.vectors[8] = new Vector3D(dots[4], dots[5]);
        this.vectors[9] = new Vector3D(dots[5], dots[6]);
        this.vectors[10] = new Vector3D(dots[6], dots[7]);
        this.vectors[11] = new Vector3D(dots[7], dots[4]);

        this.textures = textures;

    }

}
