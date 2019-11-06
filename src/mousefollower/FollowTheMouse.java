package mousefollower;

import support.sedgewick.StdDraw;

import java.awt.*;

public class FollowTheMouse {

    public static double[] getMousePosition() {
        //FIXME code up this method according to the extension instructions
        int X = 0;
        int Y = 1;
        double xPosition = StdDraw.mouseX();
        double yPosition = StdDraw.mouseY();
        double[] mousePosition = new double[2];
        mousePosition[X] = xPosition;
        mousePosition[Y] = yPosition;
        return mousePosition;
    }

    public static void drawBall(double[] position, double radius){
        double x = position[0];
        double y = position[1];
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.clear();
        StdDraw.filledCircle(x, y, radius);

    }

    public static double[] changePosition(double[] position, double[] mousePosition, double speed){
        double distance = Math.sqrt((Math.pow(mousePosition[0]-position[0], 2) + Math.pow(mousePosition[1]-position[1], 2)));
        double newX = ((mousePosition[0]-position[0])*speed)*distance;
        double newY = ((mousePosition[1]-position[1])*speed)*distance;
        return new double[] {newX, newY};
    }

    public static void main(String[] args){
        double[] tester = new double[]{.5, .5};
        drawBall(tester, .1);
        while(true) {
            StdDraw.show(30);
            drawBall(tester, .1);
            double xTester = tester[0] + changePosition(tester, getMousePosition(), .1)[0];
            double yTester = tester[1] + changePosition(tester, getMousePosition(), .1)[1];
            tester[0] = xTester;
            tester[1] = yTester;
        }
    }
}