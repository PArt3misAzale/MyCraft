package com.azale.maingameinfo.game.objects.blocks;

import com.azale.engine.gfx.twodimensional.CubeTexture;
import com.azale.engine.gfx.threedimensional.objects.Cube3D;
import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Vector3D;

public class DirtBlock extends Cube3D {

    CubeTexture textures;

    Dot3D originDot;

    /**
     * <p>- Dimensions of the {@link DirtBlock} :
     * <p>Width = {@code width}
     * <p>Height = {@code height}
     *
     * <p>PARAMETERS
     * @param originDot
     * @param width
     * @param height
     * @param textures
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
