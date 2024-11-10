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

    public NoiseMap(String name, int seedValue) {

        nameFile = name;

        seed = seedValue;

        /*
        try {

            InputStream is = getClass().getResourceAsStream("src/rsc/gameVariables/pi.txt");
            if (is == null) {

                System.out.println("The file pi.txt is nowhere to be found");

            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int i = 0; i < 100001; i++) {

                String line = br.readLine();

                String numbers[] = line.split("");

                seed = Integer.parseInt(numbers[seedValue]) * seedValue;

                if ( Integer.parseInt(numbers[seedValue]) == 0) {

                    seed += (int)(seedValue * pow(10, 2));

                }

            }

            System.out.println(seed);

        } catch (Exception e) {

            System.out.println("There is an error : " + Arrays.toString(e.getStackTrace()));

        }
         */

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

        for (int y = 0; y < mapHeight/4096; y++) {

            for (int x = 0; x < mapWidth/4096; x++) {

                terrainA[y][x] = new BiomeTerrain();

                int value = randomNum.nextInt(20);

                if (value < 2) {

                    terrainA[y][x].biome = 1;

                }

                drawP(terrainA, x, y,4096, 4096, 4096, g2);

                System.out.println(x + " X / Y " + y);

            }

        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                System.out.println(terrainA[j][i].biome);

            }

        }

        // SAVING
        try {

            ImageIO.write(image, "png", new File("noisemap_" + nameFile + "_4x4.png"));

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

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

            ImageIO.write(image, "png", new File("noisemap_" + nameFile + "_final.png"));

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public void drawP(BiomeTerrain[][] terrain, int x, int y, int width, int height, int scale, Graphics2D g2){

        if (terrain[y][x].biome == 0) {

            g2.setColor(Color.BLUE);

        } else if (terrain[y][x].biome == 1) {

            g2.setColor(Color.GREEN);

        }

        g2.fillRect(x * scale, y * scale, width, height);

    }

}
