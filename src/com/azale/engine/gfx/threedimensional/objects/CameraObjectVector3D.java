package com.azale.engine.gfx.threedimensional.objects;

import com.azale.engine.gfx.threedimensional.Vector3D;

public class CameraObjectVector3D {

    Camera camera;
    Cube3D cube;

    public Vector3D vectors[] = new Vector3D[8];

    public CameraObjectVector3D(Camera camera, Cube3D cube) {

        this.camera = camera;
        this.cube = cube;

        initializeVectors();

    }

    public void initializeVectors() {

        for (int i = 0; i < 8; i++) {

            if ( i < 4 ) {

                vectors[i] = camera.position.subtractDots(cube.getLine(i).getDot(0)).invert();

            } else {

                vectors[i] = camera.position.subtractDots(cube.getLine(i).getDot(1)).invert();

            }

        }

    }

    /*

    GETTERS AND SETTERS

     */

    /**
     *
     * @return {@code vectors}
     */
    public Vector3D[] getVectors() {

        return vectors;

    }

    /**
     *
     * @param i
     * @return {@code vectors[i]}
     */
    public Vector3D getVector(int i) {

        return vectors[i];

    }
}
