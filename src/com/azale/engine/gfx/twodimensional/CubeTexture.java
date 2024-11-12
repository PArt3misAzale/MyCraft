package com.azale.engine.gfx.twodimensional;

import com.azale.engine.gfx.Image;

public class CubeTexture {

    Image[] textures = new Image[6];

    public CubeTexture(Image[] textures, int textureType) {

        if ( textureType == 0 ) { // all

            for (int i = 0; i < 6; i++) {

                this.textures[i] = textures[0];

            }

        } else if ( textureType == 1 ) { // faces + top/bottom

            for (int i = 0; i < 4; i++) {

                this.textures[i] = textures[0];

            }

            for (int i = 4; i < 6; i++) {

                this.textures[i] = textures[1];

            }

        } else if ( textureType == 3 ) { // faces + top + bottom

            for (int i = 0; i < 4; i++) {

                this.textures[i] = textures[0];

            }

            for (int i = 4; i < 6; i++) {

                this.textures[i] = textures[1];

            }

        } else if ( textureType == 4 ) { // face1 + face2 + face3 + face4 + top + bottom

            for (int i = 0; i < 6; i++) {

                this.textures[i] = textures[i];

            }

        }

    }

}
