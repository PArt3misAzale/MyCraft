package com.azale.maingameinfo.worldgeneration.biomemap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class NoiseMap {

    TerrainAltitude[][] terrain;

    int scale = 1;
    int mapWidth, mapHeight;

    String nameFile;

    public NoiseMap(String name) {

        nameFile = name;

    }

    public void paint(){


        mapWidth = 512 / scale;
        mapHeight = 512 / scale;

        BufferedImage image = new BufferedImage(mapWidth * 4, mapHeight * 4, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        g2.fillRect(0, 0, mapWidth, mapHeight);

        terrain = new TerrainAltitude[mapHeight + 2][mapWidth + 2];

        Random randomNum = new Random();

        for (int j = 0; j < mapHeight + 2; j ++) {

            for (int i = 0; i < mapWidth + 2; i++) {

                terrain[j][i] = new TerrainAltitude();
                terrain[j][i].altitude = - 5;

            }

        }

        for (int i = 0; i < 10 ; i++) {
            for (int y = 1; y < mapHeight - 1; y++) {

                for (int x = 1; x < mapWidth - 1; x++) {

                    terrain[y][x].altitude = 2 * noiseAltitude(terrain, x, y);
                    terrain[y][x].color = calcColor(terrain, x, y);
                    drawAltitude(terrain, g2, x , y );

                    System.out.println(i+1);

                }

            }

        }

        try {

            ImageIO.write(image, "png", new File("noisemap" + nameFile + ".png"));

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public Color calcColor(TerrainAltitude[][] terrain, int x, int y) {

        terrain[y][x].color = Color.WHITE;

        if (terrain[y][x].altitude < 0) {

            if (terrain[y][x].altitude < -1) {

                if (terrain[y][x].altitude < -2) {

                    if (terrain[y][x].altitude < -3){

                        if (terrain[y][x].altitude < -4) {

                            if (terrain[y][x].altitude == -5) {

                                terrain[y][x].color = Color.BLACK;

                            }

                        } else {

                            terrain[y][x].color = Color.BLUE;

                        }

                    } else {

                        terrain[y][x].color = Color.DARK_GRAY;

                    }

                } else {

                    terrain[y][x].color = Color.GRAY;

                }

            } else {

                terrain[y][x].color = Color.LIGHT_GRAY;

            }

        } else if (terrain[y][x].altitude > 0) {

            if (terrain[y][x].altitude > 1) {

                if (terrain[y][x].altitude > 2) {

                    if (terrain[y][x].altitude > 3) {

                        if (terrain[y][x].altitude > 4) {

                            if (terrain[y][x].altitude == 5) {

                                terrain[y][x].color = Color.MAGENTA;

                            } else {

                                terrain[y][x].color = Color.RED;

                            }

                        } else {

                            terrain[y][x].color = Color.ORANGE;

                        }

                    } else {

                        terrain[y][x].color = Color.YELLOW;

                    }

                } else {

                    terrain[y][x].color = Color.GREEN;

                }

            }

        }

        return terrain[y][x].color;

    }

    public void drawAltitude(TerrainAltitude[][] terrain, Graphics2D g2, int x, int y) {

        g2.setColor(terrain[y][x].color);
        g2.fillRect(x * 4, y * 4, scale * 4, scale * 4);

    }

    public float noiseAltitude(TerrainAltitude[][] terrain, int x, int y) {

        System.out.println(x + " X / Y " + y);

        float value = 0;

        Random randomNum = new Random();

        if (x > 0 && x < mapWidth && y > 0 && y < mapHeight) {

            if (terrain[y][x - 1].altitude >= -5
                    && terrain[y][x + 1].altitude >= -5
                    && terrain[y - 1][x].altitude >= -5
                    && terrain[y + 1][x].altitude >= -5

                    && terrain[y][x - 1].altitude < -4
                    && terrain[y][x + 1].altitude < -4
                    && terrain[y - 1][x].altitude < -4
                    && terrain[y + 1][x].altitude < -4) {

                value = randomNum.nextFloat(2) - 5;

            } else if (terrain[y][x - 1].altitude >= -4
                    && terrain[y][x + 1].altitude >= -4
                    && terrain[y - 1][x].altitude >= -4
                    && terrain[y + 1][x].altitude >= -4

                    && terrain[y][x - 1].altitude < -3
                    && terrain[y][x + 1].altitude < -3
                    && terrain[y - 1][x].altitude < -3
                    && terrain[y + 1][x].altitude < -3) {

                value = randomNum.nextFloat(2) - 4;

            } else if (terrain[y][x - 1].altitude >= -3
                    && terrain[y][x + 1].altitude >= -3
                    && terrain[y - 1][x].altitude >= -3
                    && terrain[y + 1][x].altitude >= -3

                    && terrain[y][x - 1].altitude < -2
                    && terrain[y][x + 1].altitude < -2
                    && terrain[y - 1][x].altitude < -2
                    && terrain[y + 1][x].altitude < -2) {

                value = randomNum.nextFloat(2) - 3;

            } else if (terrain[y][x - 1].altitude >= -2
                    && terrain[y][x + 1].altitude >= -2
                    && terrain[y - 1][x].altitude >= -2
                    && terrain[y + 1][x].altitude >= -2

                    && terrain[y][x - 1].altitude < -1
                    && terrain[y][x + 1].altitude < -1
                    && terrain[y - 1][x].altitude < -1
                    && terrain[y + 1][x].altitude < -1) {

                value = randomNum.nextFloat(2) - 2;

            } else if (terrain[y][x - 1].altitude >= -1
                    && terrain[y][x + 1].altitude >= -1
                    && terrain[y - 1][x].altitude >= -1
                    && terrain[y + 1][x].altitude >= -1

                    && terrain[y][x - 1].altitude < 0
                    && terrain[y][x + 1].altitude < 0
                    && terrain[y - 1][x].altitude < 0
                    && terrain[y + 1][x].altitude < 0) {

                value = randomNum.nextFloat(2) - 1;

            } else if (terrain[y][x - 1].altitude >= 0
                    && terrain[y][x + 1].altitude >= 0
                    && terrain[y - 1][x].altitude >= 0
                    && terrain[y + 1][x].altitude >= 0

                    && terrain[y][x - 1].altitude < 1
                    && terrain[y][x + 1].altitude < 1
                    && terrain[y - 1][x].altitude < 1
                    && terrain[y + 1][x].altitude < 1) {

                value = randomNum.nextFloat(2);

            } else if (terrain[y][x - 1].altitude >= 1
                    && terrain[y][x + 1].altitude >= 1
                    && terrain[y - 1][x].altitude >= 1
                    && terrain[y + 1][x].altitude >= 1

                    && terrain[y][x - 1].altitude < 2
                    && terrain[y][x + 1].altitude < 2
                    && terrain[y - 1][x].altitude < 2
                    && terrain[y + 1][x].altitude < 2) {

                value = randomNum.nextFloat(2) + 1;

            } else if (terrain[y][x - 1].altitude >= 2
                    && terrain[y][x + 1].altitude >= 2
                    && terrain[y - 1][x].altitude >= 2
                    && terrain[y + 1][x].altitude >= 2

                    && terrain[y][x - 1].altitude < 3
                    && terrain[y][x + 1].altitude < 3
                    && terrain[y - 1][x].altitude < 3
                    && terrain[y + 1][x].altitude < 3) {

                value = randomNum.nextFloat(2) + 2;

            } else if (terrain[y][x - 1].altitude >= 3
                    && terrain[y][x + 1].altitude >= 3
                    && terrain[y - 1][x].altitude >= 3
                    && terrain[y + 1][x].altitude >= 3

                    && terrain[y][x - 1].altitude < 4
                    && terrain[y][x + 1].altitude < 4
                    && terrain[y - 1][x].altitude < 4
                    && terrain[y + 1][x].altitude < 4) {

                value = randomNum.nextFloat(2) + 3;

            } else if (terrain[y][x - 1].altitude >= 4
                    && terrain[y][x + 1].altitude >= 4
                    && terrain[y - 1][x].altitude >= 4
                    && terrain[y + 1][x].altitude >= 4

                    && terrain[y][x - 1].altitude < 5
                    && terrain[y][x + 1].altitude < 5
                    && terrain[y - 1][x].altitude < 5
                    && terrain[y + 1][x].altitude < 5) {

                value = randomNum.nextFloat(2) + 4;

            }

        }
        else if (x == 0 || y == 0 || x == mapWidth - 1 || y == mapHeight -1) {

            value = randomNum.nextFloat(10) - 5;

        }
        /*
        else if ((x == mapWidth - 1 || y == mapHeight - 1) && (x != 0 || y != 0)) {

            if (terrain[y][x - 1].altitude >= -5
                    && terrain[y - 1][x].altitude >= -5

                    && terrain[y][x - 1].altitude < -4
                    && terrain[y - 1][x].altitude < -4) {

                value = randomNum.nextFloat(2) - 5;

            } else if (terrain[y][x - 1].altitude >= -4
                    && terrain[y - 1][x].altitude >= -4

                    && terrain[y][x - 1].altitude < -3
                    && terrain[y - 1][x].altitude < -3) {

                value = randomNum.nextFloat(2) - 4;

            } else if (terrain[y][x - 1].altitude >= -3
                    && terrain[y - 1][x].altitude >= -3

                    && terrain[y][x - 1].altitude < -2
                    && terrain[y - 1][x].altitude < -2) {

                value = randomNum.nextFloat(2) - 3;

            } else if (terrain[y][x - 1].altitude >= -2
                    && terrain[y - 1][x].altitude >= -2

                    && terrain[y][x - 1].altitude < -1
                    && terrain[y - 1][x].altitude < -1) {

                value = randomNum.nextFloat(2) - 2;

            } else if (terrain[y][x - 1].altitude >= -1
                    && terrain[y - 1][x].altitude >= -1

                    && terrain[y][x - 1].altitude < 0
                    && terrain[y - 1][x].altitude < 0) {

                value = randomNum.nextFloat(2) - 1;

            } else if (terrain[y][x - 1].altitude >= 0
                    && terrain[y - 1][x].altitude >= 0

                    && terrain[y][x - 1].altitude < 1
                    && terrain[y - 1][x].altitude < 1) {

                value = randomNum.nextFloat(2);

            } else if (terrain[y][x - 1].altitude >= 1
                    && terrain[y - 1][x].altitude >= 1

                    && terrain[y][x - 1].altitude < 2
                    && terrain[y - 1][x].altitude < 2) {

                value = randomNum.nextFloat(2) + 1;

            } else if (terrain[y][x - 1].altitude >= 2
                    && terrain[y - 1][x].altitude >= 2

                    && terrain[y][x - 1].altitude < 3
                    && terrain[y - 1][x].altitude < 3) {

                value = randomNum.nextFloat(2) + 2;

            } else if (terrain[y][x - 1].altitude >= 3
                    && terrain[y - 1][x].altitude >= 3

                    && terrain[y][x - 1].altitude < 4
                    && terrain[y - 1][x].altitude < 4) {

                value = randomNum.nextFloat(2) + 3;

            } else if (terrain[y][x - 1].altitude >= 4
                    && terrain[y - 1][x].altitude >= 4

                    && terrain[y][x - 1].altitude < 5
                    && terrain[y - 1][x].altitude < 5) {

                value = randomNum.nextFloat(2) + 4;

            }

        }
        else if ((x == 0 || y == 0) && (x != mapWidth || y != mapHeight)) {

            if (terrain[y][x + 1].altitude >= -5
                    && terrain[y + 1][x].altitude >= -5

                    && terrain[y][x + 1].altitude < -4
                    && terrain[y + 1][x].altitude < -4){

                value = randomNum.nextFloat(2) - 5;

            } else if (terrain[y][x + 1].altitude >= -4
                    && terrain[y + 1][x].altitude >= -4

                    && terrain[y][x + 1].altitude < -3
                    && terrain[y + 1][x].altitude < -3){

                value = randomNum.nextFloat(2) - 4;

            } else if (terrain[y][x + 1].altitude >= -3
                    && terrain[y + 1][x].altitude >= -3

                    && terrain[y][x + 1].altitude < -2
                    && terrain[y + 1][x].altitude < -2){

                value = randomNum.nextFloat(2) - 3;

            } else if (terrain[y][x + 1].altitude >= -2
                    && terrain[y + 1][x].altitude >= -2

                    && terrain[y][x + 1].altitude < -1
                    && terrain[y + 1][x].altitude < -1){

                value = randomNum.nextFloat(2) - 2;

            } else if (terrain[y][x + 1].altitude >= -1
                    && terrain[y + 1][x].altitude >= -1

                    && terrain[y][x + 1].altitude < 0
                    && terrain[y + 1][x].altitude < 0){

                value = randomNum.nextFloat(2) - 1;

            } else if (terrain[y][x + 1].altitude >= 0
                    && terrain[y + 1][x].altitude >= 0

                    && terrain[y][x + 1].altitude < 1
                    && terrain[y + 1][x].altitude < 1){

                value = randomNum.nextFloat(2);

            } else if (terrain[y][x + 1].altitude >= 1
                    && terrain[y + 1][x].altitude >= 1

                    && terrain[y][x + 1].altitude < 2
                    && terrain[y + 1][x].altitude < 2){

                value = randomNum.nextFloat(2) + 1;

            } else if (terrain[y][x + 1].altitude >= 2
                    && terrain[y + 1][x].altitude >= 2

                    && terrain[y][x + 1].altitude < 3
                    && terrain[y + 1][x].altitude < 3){

                value = randomNum.nextFloat(2) + 2;

            } else if (terrain[y][x + 1].altitude >= 3
                    && terrain[y + 1][x].altitude >= 3

                    && terrain[y][x + 1].altitude < 4
                    && terrain[y + 1][x].altitude < 4){

                value = randomNum.nextFloat(2) + 3;

            } else if (terrain[y][x + 1].altitude >= 4
                    && terrain[y + 1][x].altitude >= 4

                    && terrain[y][x + 1].altitude < 5
                    && terrain[y + 1][x].altitude < 5){

                value = randomNum.nextFloat(2) + 3;

            }

        }

             */
        return value;

    }

}
