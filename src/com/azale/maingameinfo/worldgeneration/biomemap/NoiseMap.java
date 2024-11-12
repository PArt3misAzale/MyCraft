package com.azale.maingameinfo.worldgeneration.biomemap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.pow;

public class NoiseMap {

    int seed;

    BiomeTerrain[][] terrainA;
    BiomeTerrain[][] terrainB;

    int scale = 1;
    int mapWidth, mapHeight;

    String nameFile;

    SeedVariables sV;

    public NoiseMap(String name, int seedValue) {

        this.nameFile = name;

        this.seed = seedValue;
        this.sV = new SeedVariables(seed);

    }

    public void paint(){

        mapWidth = 16384;
        mapHeight = 16384;

        BufferedImage image = new BufferedImage(mapWidth , mapHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();

        // ISLANDS
        terrainA = new BiomeTerrain[mapHeight/4096][mapWidth/4096];

        // FIRST ZOOM
        terrainB = new BiomeTerrain[mapHeight/2048][mapWidth/2048];

        Random randomNum = new Random();

        int[] value = sV.getValue4X4();

        for (int y = 0; y < mapHeight/4096; y++) {

            for (int x = 0; x < mapWidth/4096; x++) {

                terrainA[y][x] = new BiomeTerrain();

            }

        }

        // First value
        if (value[0] < 3) {

            terrainA[0][value[0]].biome = 1;

        } else if (value[0] < 7) {

            terrainA[1][value[0] - 4].biome = 1;

        } else if (value[0] < 11) {

            terrainA[2][value[0] - 8].biome = 1;

        } else if (value[0] < 15) {

            terrainA[3][value[0] - 12].biome = 1;

        }
        // Second value
        if (value[1] < 3) {

            terrainA[3][value[1]].biome = 1;

        } else if (value[1] < 7) {

            terrainA[2][4 - value[1]].biome = 1;

        } else if (value[1] < 11) {

            terrainA[1][8 - value[1]].biome = 1;

        } else if (value[1] < 15) {

            terrainA[0][12 - value[1]].biome = 1;

        }
        // Third value
        if (value[2] < 3) {

            terrainA[0][value[2]].biome = 1;

        } else if (value[2] < 7) {

            terrainA[1][value[2] - 4].biome = 1;

        } else if (value[2] < 11) {

            terrainA[2][value[2] - 8].biome = 1;

        } else if (value[2] < 15) {

            terrainA[3][value[2] - 12].biome = 1;

        }

        for (int y = 0; y < 4 ; y++) {

            for (int x = 0; x < 4; x++) {

                drawP(terrainA, x, y, 4, 4, scale, g2);
                System.out.println(terrainA[y][x].biome);
                System.out.println(x + " X / Y " + y);

            }

        }

        try {

            ImageIO.write(image, "png", new File("rsc/game/maps/noisemap/noisemap_" + nameFile + "_4x4.png"));

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

/*
        // ZOOM
        for (int j = 0; j < mapHeight/2048; j++) {

            for (int i = 0; i < mapWidth/2048; i++) {

                terrainB[j][i] = new BiomeTerrain();

            }

        }

        for (int j = 0; j < mapHeight/4096; j++) {

            for (int i = 0; i < mapWidth/4096; i++) {

                terrainB[j][i].biome = terrainA[j][i].biome;
                terrainB[j][i+1].biome = terrainA[j][i].biome;
                terrainB[j+1][i].biome = terrainA[j][i].biome;
                terrainB[j+1][i+1].biome = terrainA[j][i].biome;

            }

        }

        // ADD ISLAND
        for (int y = 0; y < mapHeight/2048; y++) {

            for (int x = 0; x < mapWidth/2048; x++) {

                int value = randomNum.nextInt(10);

                if (value < 2) {

                    if (terrainB[y][x].biome == 1) {

                        terrainB[y][x].biome = 0;

                    } else if (terrainB[y][x].biome == 0) {

                        if (x > 0 && x < mapWidth/2048-1 && y > 0 && y < mapHeight/2048-1) {

                            if (terrainB[y][x + 1].biome == 1 || terrainB[y][x - 1].biome == 1 || terrainB[y + 1][x].biome == 1 || terrainB[y - 1][x].biome == 1 || terrainB[y + 1][x + 1].biome == 1 || terrainB[y - 1][x - 1].biome == 1 || terrainB[y - 1][x + 1].biome == 1 || terrainB[y + 1][x - 1].biome == 1) {

                                terrainB[y][x].biome = 1;

                            }

                        } else if (x == 0 && y == 0) {

                            if (terrainB[y][x + 1].biome == 1 || terrainB[y + 1][x].biome == 1 || terrainB[y + 1][x + 1].biome == 1) {

                                terrainB[y][x].biome = 1;

                            }

                        } else if (x == mapWidth/2048-1 && y == mapHeight/2048-1) {

                            if (terrainB[y][x - 1].biome == 1 || terrainB[y - 1][x].biome == 1 || terrainB[y - 1][x - 1].biome == 1) {

                                terrainB[y][x].biome = 1;

                            }

                        } else if (x == 0 && y != 0) {

                            if (terrainB[y][x + 1].biome == 1 || terrainB[y + 1][x].biome == 1 || terrainB[y - 1][x].biome == 1|| terrainB[y + 1][x + 1].biome == 1 || terrainB[y - 1][x + 1].biome == 1) {

                                terrainB[y][x].biome = 1;

                            }

                        } else if (x != 0 && y == 0) {

                            if (terrainB[y + 1][x].biome == 1 || terrainB[y][x + 1].biome == 1 || terrainB[y][x - 1].biome == 1|| terrainB[y + 1][x + 1].biome == 1 || terrainB[y + 1][x - 1].biome == 1) {

                                terrainB[y][x].biome = 1;

                            }

                        } else if (x == mapWidth/2048-1 && y != mapHeight/2048-1) {

                            if (terrainB[y + 1][x].biome == 1 || terrainB[y - 1][x].biome == 1 || terrainB[y][x - 1].biome == 1|| terrainB[y + 1][x - 1].biome == 1 || terrainB[y - 1][x - 1].biome == 1) {

                                terrainB[y][x].biome = 1;

                            }

                        } else if (x != mapWidth/2048-1 && y == mapHeight/2048-1) {

                            if (terrainB[y][x + 1].biome == 1 || terrainB[y][x - 1].biome == 1 || terrainB[y - 1][x].biome == 1|| terrainB[y - 1][x + 1].biome == 1 || terrainB[y - 1][x - 1].biome == 1) {

                                terrainB[y][x].biome = 1;

                            }

                        }

                    }

                }

                drawP(terrainB, x, y,2048, 2048, 4096, g2);

                System.out.println(x + " X / Y " + y);

            }

        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                System.out.println(terrainB[j][i].biome);

            }

        }

        try {

            ImageIO.write(image, "png", new File("rsc/game/maps/noisemap/noisemap_" + nameFile + "_final.png"));

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

         */

    }

    public void drawP(BiomeTerrain[][] terrain, int x, int y, int width, int height, int scale, Graphics2D g2){

        if (terrain[y][x].biome == 0) {

            g2.setColor(Color.BLUE);
            System.out.println("Biome = Ocean");

        } else if (terrain[y][x].biome == 1) {

            g2.setColor(Color.GREEN);
            System.out.println("Biome = Land");

        }

        g2.fillRect(x * scale, y * scale, width, height);

    }

}
