package root.model;

import java.awt.*;
import java.io.Serializable;

public class Model implements Serializable {
    protected double x;
    protected double y;
    protected double angle;

    protected double width;
    protected double height;


    public Model(double x, double y, double angle, double width, double height) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.width = width;
        this.height = height;
    }

    public Model() {
        this(0,0,0,0,0);
    }

    public void setCoord(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setSize(double width, double height){
        this.width = width;
        this.height = height;
    }


    public boolean contain(double x, double y){
        return this.x - width/2 <= x && this.x + width/2 >= x
                && this.y - height/2 <= y && this.y + height/2 >= y;
    }

    public Rectangle getRectangle(){
        int x = (int) getX();
        int y = (int) getY();
        int width = (int) getWidth();
        int height = (int) getHeight();
        return new Rectangle(x - width/2,y - height/2, width, height);
    }

    public boolean intersects(Model m){
        return intersects(m.getRectangle());
    }

    public boolean intersects(Rectangle r){
        return getRectangle().intersects(r);
    }

    public void setSize(Dimension d){
        setSize(d.width,d.height);
    }




    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
