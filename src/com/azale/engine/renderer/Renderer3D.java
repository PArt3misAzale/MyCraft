package com.azale.engine.renderer;

import com.azale.engine.gfx.threedimensional.Vector3D;
import com.azale.engine.gfx.threedimensional.objects.Camera;
import com.azale.engine.gfx.threedimensional.objects.CameraObjectVector3D;
import com.azale.engine.gfx.threedimensional.objects.Cube3D;
import com.azale.engine.gfx.twodimensional.objects.Cube2D;

public class Renderer3D {

    public double defaultFov;
    public double FOV;

    Camera camera;

    CameraObjectVector3D cameraObjectVector3D;

    public Renderer3D(Camera camera, double defaultFov) {

        this.defaultFov = defaultFov;
        this.camera = camera;

    }

    public void transformCube3DIn2D(Cube3D cube) {

        // get the vectors of the object's dots and camera :
        cameraObjectVector3D = new CameraObjectVector3D(camera, cube);
        Vector3D[] cameraVectors = cameraObjectVector3D.getVectors();

        for (int i = 0; i < 8; i ++) {

            System.out.println("Camera vector " + i + " : " + cameraVectors[i].consoleOut()); // working

        }

        Vector3D[] cubeLines = getCubeLines(cameraVectors, cube);

        for (int i = 0; i < 12 ; i++) {

            System.out.println("Cube lines " + i + " : " + cubeLines[i].consoleOut());

        }

        // Camera work :
        Cube2D cube2D = new Cube2D(cube, "z");

        //SquareToDraw std = new SquareToDraw();

    }

    public Vector3D[] getCubeLines(Vector3D[] cameraVectors, Cube3D cube) {

        Vector3D[] vectors = new Vector3D[12];

        // XY
        vectors[0] = cameraVectors[0].substract(cameraVectors[1]);
        vectors[1] = cameraVectors[1].substract(cameraVectors[2]);
        vectors[2] = cameraVectors[2].substract(cameraVectors[3]).invert();
        vectors[3] = cameraVectors[3].substract(cameraVectors[0]).invert();

        // YZ
        vectors[4] = cameraVectors[0].substract(cameraVectors[4]);
        vectors[5] = cameraVectors[1].substract(cameraVectors[5]);
        vectors[6] = cameraVectors[2].substract(cameraVectors[6]);
        vectors[7] = cameraVectors[3].substract(cameraVectors[7]);

        // ZX
        vectors[8] = cameraVectors[4].substract(cameraVectors[5]);
        vectors[9] = cameraVectors[5].substract(cameraVectors[6]);
        vectors[10] = cameraVectors[6].substract(cameraVectors[7]).invert();
        vectors[11] = cameraVectors[7].substract(cameraVectors[4]).invert();

        return vectors;

    }

}
