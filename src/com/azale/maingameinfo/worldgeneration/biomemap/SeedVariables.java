package com.azale.maingameinfo.worldgeneration.biomemap;

import static java.lang.Math.*;

public class SeedVariables {

    private int seed;

    public SeedVariables(int seedValue) {

        seed = seedValue;

        System.out.println(seed);

    }

    public int[] getValue4X4() {

        double[] values = new double[3];
        int[] finalValues = new int[3];

        // function : (x - (8 * seed + sin( seed * PI ) + 4 * sin ( PI / 16 ))) * (x - ( 2 * seed + cos( seed * PI ) + 4 * cos( PI / 16 ))) * ( x - ( 4 * seed + cos( seed * 2 * PI ) + 4 * sin( PI / 16 ))) :

        values[2] = 8 * seed + sin( seed * PI ) + 4 * sin( PI / 16 );
        values[0] = 2 * seed + cos( seed * PI ) + 4 * cos( PI / 16 );
        values[1] = 4 * seed + cos( seed * 2 * PI ) + 4 * sin( PI / 16 );

        System.out.println("Root 0 : " + values[0]);
        System.out.println("Root 1 : " + values[1]);
        System.out.println("Root 2 : " + values[2]);

        int valueMax = 0;

        System.out.println("Seed : " + seed + "  ||  Values[2] : " + values[2] + "  ||  ValueMax : " + valueMax);

        int scale = 1;

        if (seed >= 100) {

            scale = 10000;

        } else if (seed >= 10) {

            scale = 1000;

        } else if (seed >= 1) {

            scale = 100;

        }

        if (seed != 0) {

            finalValues[0] = (int) ((values[0] / scale) * 16);
            finalValues[1] = (int) ((values[1] / scale) * 16);
            finalValues[2] = (int) ((values[2] / scale) * 16);

        } else {

            finalValues[0] = 0;
            finalValues[1] = 0;
            finalValues[2] = 0;

        }

        System.out.println("Root 0 : " + finalValues[0]);
        System.out.println("Root 1 : " + finalValues[1]);
        System.out.println("Root 2 : " + finalValues[2]);

        return finalValues;
    }

}
