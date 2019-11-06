package bouncingballs;

import support.cse131.ArgsProcessor;
import support.sedgewick.StdDraw;

import java.awt.*;

public class bouncybouncy {
    public static void main(String[] args) {

        ArgsProcessor ap = new ArgsProcessor(args);
        int numBalls = ap.nextInt("How many balls?");
        int numIterations = ap.nextInt("How many iterations?");

        int X = 0;
        int Y = 1;
        int xDirection = 2;
        int yDirection = 3;
        double xLocation = 0;
        double yLocation = 0;
        double xVelocity = 0;
        double yVelocity = 0;
        double[][] location = new double[numBalls][4];

        for(int i = 0; i<location.length; ++i) {
            xVelocity = 10*(((Math.random()*0.0025)-(Math.random()*0.00125)));
            yVelocity = 10*(((Math.random()*0.0025)-(Math.random()*0.00125)));
            xLocation = Math.random();
            yLocation = Math.random();
            location[i][X] = xLocation;
            location[i][Y] = yLocation;
            location[i][xDirection] = xVelocity;
            location[i][yDirection] = yVelocity;
        }

        for(int j = 0; j<numIterations; ++j){
            StdDraw.pause(30);
            StdDraw.clear();
            for(int i = 0; i<numBalls; ++i){
                for(int k = i+1; k<numBalls; ++k){
//                    if(k==i){ }
//                    else{
                        double x1 = location[i][X];
                        double y1 = location[i][Y];
                        double x2 = location[k][X];
                        double y2 = location[k][Y];
                        double xDifference = Math.pow((x2 - x1), 2.0);
                        double yDifference = Math.pow((y2 - y1), 2.0);
                        double totDistance = Math.sqrt(xDifference + yDifference);
                        if (totDistance>0.02) {
                        }
                        else {
                            location[i][xDirection] = -1*location[i][xDirection];
                            location[i][yDirection] = -1*location[i][yDirection];
                        }
//                    }
                }
                double newX = location[i][X] + location[i][xDirection];
                double newY = location[i][Y] + location[i][yDirection];
                if(newX > 0 && newX < 1 && newY > 0 && newY < 1) {
                    location[i][X] = newX;
                    location[i][Y] = newY;
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.filledCircle(location[i][X], location[i][Y], 0.01);
                }

                else {
                    location[i][xDirection] = -1 * location[i][xDirection];
                    location[i][yDirection] = -1 * location[i][yDirection];
                    location[i][X] = location[i][X] + location[i][xDirection];
                    location[i][Y] = location[i][Y] + location[i][yDirection];
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.filledCircle(location[i][X], location[i][Y], 0.01);
                }
            }
        }
    }
}
