package com.azale.engine.gfx.threedimensional.objects;

import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Object3D;
import com.azale.engine.gfx.threedimensional.Vector3D;

public class Camera extends Object3D {

    public Dot3D position;
    public Vector3D direction = new Vector3D(new Dot3D(0, 0, 0), new Dot3D(0, 0, 1));

    public Camera(Dot3D position) {

        this.position = position;

    }

    /*

    GETTERS AND SETTERS

     */

    /**
     * @return {@code direction}
     */
    public Vector3D getDirection() {

        return direction;

    }

    /**
     * @param direction
     */
    public void setDirection(Vector3D direction) {

        this.direction = direction;

    }

    /**
     * @return {@code position}
     */
    public Dot3D getPosition() {

        return position;

    }

    /**
     * @param position
     */
    public void setPosition(Dot3D position) {

        this.position = position;

    }
}
