package root.utils;

import root.main.MainFrame;

import java.awt.*;

public class ControlWindow {

    private static int centerX;
    private static int centerY;
    private static int width = MainFrame.WIDTH;
    private static int height = MainFrame.HEIGHT;

    private static double scale = 1.0;
    private static double incValueScale = 0.01;

    private static boolean fixCamera = false;


    /**
     * @param x - x from MAP coordinate system
     * @param y - y from MAP coordinate system
     * @return real coordinate in window
     */
    public static Point toWindowCoordinate(double x, double y){
        double newX =  (x - centerX)*scale + width/2f;
        double newY =  (y - centerY)*scale + height/2f;
        Point p = new Point();
        p.setLocation(newX, newY);
        return p;
    }

    public static double toScale(double origScale){
        return origScale * scale;
    }

    /**
     * @param x - x from window coordinate system
     * @param y - y from window coordinate system
     * @return real coordinate in MAP
     */
    public static Point toMapCoordinate(double x, double y){
        double newX = (x - width/2f) / scale + centerX;
        double newY = (y - height/2f) /scale + centerY;
        Point p = new Point();
        p.setLocation(newX, newY);
        return p;
    }

    public double getDistanceToCenter(double x, double y){
        return Math.sqrt( Math.pow((centerX - x), 2)+Math.pow((centerY - y), 2));
    }


    public static void setCenterWindow() {
        setCenterWindow(0, 0);
    }

    /**
     * @param x
     * @param y - preferred coordinate new center window in MAP coordinate system
     */
    public static void setCenterWindow(double x, double y){
        centerX = (int) (x);
        centerY = (int) (y);
    }

    public static int getCenterX() {
        return centerX;
    }

    public static int getCenterY() {
        return centerY;
    }

    public static void incScale(){
        scale += incValueScale;
    }
    public static void decScale(){
        scale -= incValueScale;
    }
}
