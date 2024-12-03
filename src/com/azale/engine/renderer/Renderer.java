package com.azale.engine.renderer;

import com.azale.engine.GameContainer;
import com.azale.engine.gfx.Image;
import com.azale.engine.gfx.ImageTile;
import com.azale.engine.gfx.threedimensional.Dot3D;
import com.azale.engine.gfx.threedimensional.Vector3D;
import com.azale.engine.gfx.twodimensional.Dot2D;
import com.azale.engine.gfx.twodimensional.objects.Triangle2D;

import java.awt.image.DataBufferInt;

public class Renderer {

    private int pW, pH;
    private int[] p;
    private GameContainer gc;

    // private Font_6P font_standard_6p = Font_6P.STANDARD;
    // private Font_14P font_standard_14p = Font_14P.STANDARD;

    public Renderer(GameContainer gc) {

        pW = gc.getWidth();
        pH = gc.getHeight();

        p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();

        this.gc = gc;

    }

    public void clear() {

        for (int i =0; i < p.length; i++) {

            p[i] = 0;

        }

    }

    public void setPixel(int x, int y, int value) {

        if (x < 0 || x >= pW || y < 0 || y >= pH || value == 0xffff00ff ) {

            return;

        }

        p[x + y * pW] = value;

    }

    public void drawImage(Image image, int offX, int offY) {

        // DON'T RENDER CODE
        if (offX < -image.getW()) return;
        if (offY < -image.getH()) return;

        if (offX >= pW) return;
        if (offY >= pH) return;

        //
        int newX = 0;
        int newY = 0;
        int newWidth = image.getW();
        int newHeight = image.getH();

        // CLIPPING CODE
        if (newX + offX < 0) {

            newX -= offX;

        }

        if (newY + offY < 0) {

            newY -= offY;

        }

        if (newWidth + offX > pW) {

            newWidth -= newWidth + offX - pW;

        }

        if (newHeight + offY > pH) {

            newHeight -= newHeight + offY - pH;

        }

        // RENDER IMAGE
        for (newY = 0; newY < newHeight; newY++) {

            for (newX = 0; newX < newWidth; newX ++) {

                setPixel(newX + offX, newY + offY, image.getP()[newX + newY * image.getW()]);

            }

        }

    }

    /*

    public void drawText6P(String text, int offX, int offY, int color) {

        text = text.toUpperCase();
        int offset = 0;

        for (int i = 0; i < text.length(); i ++) {

            int unicode = text.codePointAt(i) - 32;

            for (int y = 0; y < font_standard_6p.getFontImage().getH(); y++) {

                for (int x = 0; x < font_standard_6p.getWidths()[unicode]; x++) {

                    if (font_standard_6p.getFontImage().getP()[(x + font_standard_6p.getOffsets()[unicode]) + y * font_standard_6p.getFontImage().getW()] == 0xffffffff) {

                        setPixel(x + offX + offset, y + offY, color);

                    }

                }

            }

            offset += font_standard_6p.getWidths()[unicode];

        }

    }

     */

    /*

    public void drawText14P(String text, int offX, int offY, int color) {

        int offset = 0;

        for (int i = 0; i < text.length(); i ++) {

            int unicode = text.codePointAt(i) - 32;

            for (int y = 0; y < font_standard_14p.getFontImage().getH(); y++) {

                for (int x = 0; x < font_standard_14p.getWidths()[unicode]; x++) {

                    if (font_standard_14p.getFontImage().getP()[(x + font_standard_14p.getOffsets()[unicode]) + y * font_standard_14p.getFontImage().getW()] == 0xffffffff) {

                        setPixel(x + offX + offset, y + offY, color);

                    }

                }

            }

            offset += font_standard_14p.getWidths()[unicode];

        }

    }

     */

    public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY) {

        // DON'T RENDER CODE
        if (offX < -image.getTileW()) return;
        if (offY < -image.getTileH()) return;

        if (offX >= pW) return;
        if (offY >= pH) return;

        //
        int newX = 0;
        int newY = 0;
        int newWidth = image.getTileW();
        int newHeight = image.getTileH();

        // CLIPPING CODE
        if (newX + offX < 0) {

            newX -= offX;

        }

        if (newY + offY < 0) {

            newY -= offY;

        }

        if (newWidth + offX > pW) {

            newWidth -= newWidth + offX - pW;

        }

        if (newHeight + offY > pH) {

            newHeight -= newHeight + offY - pH;

        }

        // RENDER IMAGE
        for (newY = 0; newY < newHeight; newY++) {

            for (newX = 0; newX < newWidth; newX ++) {

                setPixel(newX + offX, newY + offY, image.getP()[(newX + tileX * image.getTileW()) + (newY + tileY * image.getTileH()) * image.getW()]);

            }

        }

    }

    public void drawRect(int offX, int offY, int width, int height, int color) {

        // RENDER
        for (int y = 0; y <= height; y ++) {

            setPixel(offX, y + offY, color);
            setPixel(offX + width, y + offY, color);

        }

        for (int x = 0; x <= width; x++) {

            setPixel(x + offX, offY, color);
            setPixel(x + offX, offY + height, color);

        }

    }

    public void drawFillRect(int offX, int offY, int width, int height, int color) {

        // DON'T RENDER CODE
        if (offX < -width) return;
        if (offY < -height) return;

        if (offX >= pW) return;
        if (offY >= pH) return;

        //
        int newX = 0;
        int newY = 0;
        int newWidth = width;
        int newHeight = height;

        // CLIPPING CODE
        if (newX + offX < 0) {

            newX -= offX;

        }

        if (newY + offY < 0) {

            newY -= offY;

        }

        if (newWidth + offX > pW) {

            newWidth -= newWidth + offX - pW;

        }

        if (newHeight + offY > pH) {

            newHeight -= newHeight + offY - pH;

        }

        // RENDER
        for (int y = newY; y <= newHeight; y ++) {

            for (int x = newX; x <= newWidth; x++) {

                setPixel(x + offX, y + offY, color);

            }

        }

    }

    public void drawTriangle(Triangle2D triangle, int offX, int offY, int color){

        for (int x = (int) triangle.dots[0].getX(); x <= (int) triangle.dots[1].getX(); x++) {

            setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[0], triangle.dots[1]), x), color);

        }

        for (int x = (int) triangle.dots[2].getX(); x <= (int) triangle.dots[1].getX(); x++) {

            setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[1], triangle.dots[2]), x), color);

        }

        for (int x = (int) triangle.dots[2].getX(); x <= (int) triangle.dots[0].getX(); x++) {

            setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[2], triangle.dots[0]), x), color);

        }

    }

    private int intersection(int x0, int y0, int x1, int y1, int y) {
        if (y0 == y1) {return Integer.MAX_VALUE;}

        int xIntersect = x0 + (y - y0) * (x1 - x0) / (y1 - y0);
        return xIntersect;
    }

    public void drawFillTriangle(Triangle2D triangle, int offX, int offY, int color){

        // CHATGPT METHOD
        int minX = (int) Math.min(triangle.dots[0].getX(), Math.min(triangle.dots[1].getX(), triangle.dots[2].getX()));
        int maxX = (int) Math.max(triangle.dots[0].getX(), Math.max(triangle.dots[1].getX(), triangle.dots[2].getX()));
        int minY = (int) Math.min(triangle.dots[0].getY(), Math.min(triangle.dots[1].getY(), triangle.dots[2].getY()));
        int maxY = (int) Math.max(triangle.dots[0].getY(), Math.max(triangle.dots[1].getY(), triangle.dots[2].getY()));

        for (int y = minY; y <= maxY; y++) {

            // calculate intersections
            int[] intersectX = new int[3];
            int count = 0;

            intersectX[count++] = intersection((int) triangle.dots[0].getX(), (int) triangle.dots[0].getY(), (int) triangle.dots[1].getX(), (int) triangle.dots[1].getY(), y);
            intersectX[count++] = intersection((int) triangle.dots[1].getX(), (int) triangle.dots[1].getY(), (int) triangle.dots[2].getX(), (int) triangle.dots[2].getY(), y);
            intersectX[count++] = intersection((int) triangle.dots[2].getX(), (int) triangle.dots[2].getY(), (int) triangle.dots[0].getX(), (int) triangle.dots[0].getY(), y);

            // sort intersections
            java.util.Arrays.sort(intersectX);

            System.out.println(intersectX[0]);

            for (int x = intersectX[0]; x <= intersectX[1]; x++) {

                setPixel(x, y, color);

            }

        }

        // PROF METHOD
        /*
        for (int x = 0; x < gc.getWidth(); x++) {

            if (triangle.dots[0].getY() < triangle.getVectorEquation2D(new Vector3D(triangle.dots[1], triangle.dots[2]), x)
                    && triangle.dots[1].getY() > triangle.getVectorEquation2D(new Vector3D(triangle.dots[2], triangle.dots[0]), x)
                    && triangle.dots[2].getY() > triangle.getVectorEquation2D(new Vector3D(triangle.dots[0], triangle.dots[1]), x)) {

                System.out.println("DOT 0 Y est inf à la droite (DOT 1, DOT 2)");
                System.out.println("DOT 1 Y est sup à la droite (DOT 2, DOT 0)");
                System.out.println("DOT 2 Y est sup à la droite (DOT 0, DOT 1)");
                System.out.println("\n");

                triangle.dots[0].consoleOut();
                triangle.dots[1].consoleOut();
                triangle.dots[2].consoleOut();

                for (int t = 0; t < 1000; t++){

                    setPixel((int) (offX + (triangle.dots[0].getX() +(triangle.dots[1].getX() - triangle.dots[0].getX()) * t/1000)), (int) (offY + (triangle.dots[0].getY() +(triangle.dots[1].getY() - triangle.dots[0].getY()) * t/1000)), color);
                    setPixel((int) (offX + (triangle.dots[1].getX() +(triangle.dots[2].getX() - triangle.dots[1].getX()) * t/1000)), (int) (offY + (triangle.dots[1].getY() +(triangle.dots[2].getY() - triangle.dots[1].getY()) * t/1000)), color);
                    setPixel((int) (offX + (triangle.dots[2].getX() +(triangle.dots[0].getX() - triangle.dots[2].getX()) * t/1000)), (int) (offY + (triangle.dots[2].getY() +(triangle.dots[0].getY() - triangle.dots[2].getY()) * t/1000)), color);

                } */

                /*
                setPixel(offX + x, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[0], triangle.dots[1]), x), color);
                setPixel(offX + x, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[1], triangle.dots[2]), x), color);
                setPixel(offX + x, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[2], triangle.dots[0]), x), color);

            }

        }


        // SOLUTION 1 FOR TRIANGLES ( not the best in terms of optimizations : may be slow with tables)
        // Get all the y for the three sides of the triangle
        // Set the table
        // Set 1 if side of the triangle ( = pixel filled )
        int[] d = new int[gc.getHeight * gc.getWidth];
        // Side : dot0 / dot1
        for (int x = (int) triangle.dots[0].getX(); x <= (int) triangle.dots[1].getX(); x++) {

            // Get Y and place it in the table
             d[x + triangle.getEquation2D(new Vector3D(triangle.dot[0], triangle.dot[1], x)] = 1;
            
        }

        // Side : dot1 / dot2
        for (int x = (int) triangle.dots[1].getX(); x <= (int) triangle.dots[2].getX(); x++) {

            // Get Y and place it in the table
             d[x + triangle.getEquation2D(new Vector3D(triangle.dot[1], triangle.dot[2], x)] = 1;
            
        }

        // Side : dot2 / dot0
        for (int x = (int) triangle.dots[2].getX(); x <= (int) triangle.dots[0].getX(); x++) {

            // Get Y and place it in the table
             d[x + triangle.getEquation2D(new Vector3D(triangle.dot[2], triangle.dot[0], x)] = 1;
            
        }

        // Fill the triangle table with 1 for filled
        boolean inTriangle = false;
        for (int i = 0; i < gc.getHeight * gc.getWdith; i++) {
            
            if (d[i] == 1 && inTriangle == false && (i != triangle.dots[0].getX() + (gc.getHeight * triangle.dots[0].getY()) || i != triangle.dots[1].getX() + (gc.getHeight * triangle.dots[1].getY()) || i != triangle.dots[2].getX() + (gc.getHeight * triangle.dots[2].getY())) { inTriangle = true; }
            elif (d[i] == 1 && inTriangle == true) { inTriangle = false; }

            if (d[i] == 0 && inTriangle == true) {
                d[i] = 1;
            }
                
        }

        for (int y = 0; y < gc.getHeight; y++) {

            for (int x = 0; x < gc.getWidth; x++) {

                if (d[x + y * gc.getHeight] == 1) {

                    setPixel(x, y, color)

                }       

            }

        }
        

// ------------------------------------------------------------------------------------------------------------------------------- //

        for (int i = (int) (triangle.dots[2].getX() - triangle.dots[0].getX()); i > 0; i--)
            if (!inverted) {

                for (int x = (int) triangle.dots[0].getX(); x <= (int) triangle.dots[1].getX(); x++) {

                    setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[0], triangle.dots[1]), x), color);

                }

                for (int x = (int) triangle.dots[2].getX(); x <= (int) triangle.dots[1].getX(); x++) {

                    setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[1], triangle.dots[2]), x), color);

                }

                for (int x = (int) triangle.dots[2].getX(); x <= (int) triangle.dots[0].getX(); x++) {

                    setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[2], triangle.dots[0]), x), color);

                }

            } else if (inverted) {

                for (int x = (int) triangle.dots[0].getX(); x <= (int) triangle.dots[1].getX(); x++) {

                    setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[0], triangle.dots[1]), x), color);

                }

            for (int x = (int) triangle.dots[2].getX(); x <= (int) triangle.dots[1].getX(); x++) {

                setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[1], triangle.dots[2]), x), color);

            }


            for (int x = (int) triangle.dots[2].getX(); x <= (int) triangle.dots[0].getX(); x++) {

                setPixel(x + offX, offY - triangle.getVectorEquation2D(new Vector3D(triangle.dots[0], triangle.dots[0]), x), color);

            }

             */

            }
        /*
        if (!inverted) {

            int maxX = (int)(triangle.dots[2].getX() - 133);

            for (int i = (int)(triangle.dots[2].getX() - triangle.dots[0].getX()); i > 0; i--) {
                for (int x = (int) triangle.dots[0].getX(); x <= (int) triangle.dots[1].getX(); x++) {
                    if (x < maxX) {
                        setPixel(x + offX + i, offY + i + triangle.getVectorEquation2D(new Vector3D(triangle.dots[0], new Dot3D(triangle.dots[1].getX() - i, triangle.dots[1].getY(), 0)), x), color);
                    }
                }

                //for (int x = (int) triangle.dots[0].getX(); x <= (int) triangle.dots[1].getX(); x++) {
                    //setPixel(x + offX + i, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[2], new Dot3D(triangle.dots[0].getX()-i, triangle.dots[1].getY(), 0)), x), color);
                //}


            }

        }

            setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[0], triangle.dots[1]), x), color);

        }

        for (int x = (int)triangle.dots[2].getX(); x <= (int)triangle.dots[1].getX(); x++) {

            setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[1], triangle.dots[2]), x), color);

        }

        for (int x = (int)triangle.dots[2].getX(); x <= (int)triangle.dots[0].getX(); x++) {

            setPixel(x + offX, offY + triangle.getVectorEquation2D(new Vector3D(triangle.dots[2], triangle.dots[0]), x), color);

        }

        for (int y = 0; y < triangle.getMaxY(); y++) {

            for (int x = 0; x < triangle.getMaxY(); x++) {

                if (y > triangle.getVectorEquation2D(new Vector3D(triangle.dots[0], triangle.dots[1]), x) && y > triangle.getVectorEquation2D(new Vector3D(triangle.dots[2], triangle.dots[0]), x) && y < triangle.getVectorEquation2D(new Vector3D(triangle.dots[2], triangle.dots[1]), x) && !inverted) {

                    if (x > triangle.dots[0].getX()) {

                        setPixel(x + offX, y + offY, color);

                    }

                } else if (y > triangle.getVectorEquation2D(new Vector3D(triangle.dots[0], triangle.dots[1]), x) && y > triangle.getVectorEquation2D(new Vector3D(triangle.dots[2], triangle.dots[0]), x) && y < triangle.getVectorEquation2D(new Vector3D(triangle.dots[2], triangle.dots[1]), x) && inverted) {

                    setPixel(x + offX, y + offY, color);


                }

            }

        }

         */


    // 3D TO 2D :
    public void draw2DCube(Dot2D[] dots) {

        int scale = 200;

        dots[0].resize(scale);
        dots[1].resize(scale);
        dots[2].resize(scale);
        dots[3].resize(scale);
        dots[4].resize(scale);
        dots[5].resize(scale);
        dots[6].resize(scale);
        dots[7].resize(scale);

        dots[0].consoleOut();
        dots[1].consoleOut();
        dots[2].consoleOut();
        dots[3].consoleOut();
        dots[4].consoleOut();
        dots[5].consoleOut();
        dots[6].consoleOut();
        dots[7].consoleOut();

        drawFillTriangle(new Triangle2D(new Dot3D(0,0,0),new Dot3D(100,350,0), new Dot3D(266,366,0)), 100, 100, 0xffffffff);

        //drawFillTriangle(new Triangle2D(new Dot3D(200,350,0),new Dot3D(100,350,0), new Dot3D(266,366,0)), 100, 100, 0xff0000ff);
        //drawFillTriangle(new Triangle2D(new Dot3D(dots[0].getX(), dots[0].getY() , 0), new Dot3D(dots[1].getX(), dots[1].getY() , 0), new Dot3D(dots[2].getX(), dots[2].getY() , 0)), (int)(gc.getWidth()/2 + dots[0].getX()), (int)(gc.getHeight()/2 - dots[0].getY()), 0xff00ff00, false);
        //drawFillTriangle(new Triangle2D(new Dot3D(dots[0].getX(), dots[0].getY() , 0), new Dot3D(dots[1].getX(), dots[1].getY() , 0), new Dot3D(dots[2].getX(), dots[2].getY() , 0)), (int)(gc.getWidth()/2 + dots[0].getX()), (int)(gc.getHeight()/2 - dots[0].getY()), 0xffffffff, true);


        //drawFillTriangle(new Triangle2D(new Dot3D(dots[7].getX() , dots[7].getY() , 0), new Dot3D(dots[2].getX(), dots[2].getY() , 0), new Dot3D(dots[6].getX(), dots[6].getY() , 0)), (int) (gc.getWidth()/2 - dots[7].getX()), (int) (gc.getHeight()/2 - dots[7].getX()), 0xffff0000);
        //drawFillTriangle(new Triangle2D(new Dot3D(dots[6].getX(), dots[6].getY() , 0), new Dot3D(dots[7].getX() , dots[7].getY() , 0), new Dot3D(dots[2].getX(), dots[2].getY() , 0)), (int) (gc.getWidth()/2 - dots[2].getX()), (int) (gc.getHeight()/2 - dots[7].getX() - 133), 0xffffff00);
    }

}
