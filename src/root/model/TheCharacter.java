package root.model;

import root.utils.ControlWindow;

public class TheCharacter extends BreakableObject {

    public static final int STOP = 0, UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4;

    private int direction;
    private double speed = 3;


    public TheCharacter(double x, double y, double angle, double width, double height, int healthPoint) {
        super(x, y, angle, width, height, healthPoint);
    }

    public TheCharacter(int healthPoint) {
        super(healthPoint);
    }




    public void update(){
        switch (direction){
            case UP:
                y -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
        }

        ControlWindow.setCenterWindow(x, y);

    }

    public void setDirection(int direction){
        if(direction >=0 & direction<5){
            this.direction = direction;
        }
    }

    public int getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
