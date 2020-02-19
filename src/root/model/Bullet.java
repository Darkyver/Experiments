package root.model;

import root.main.MainFrame;

import java.awt.*;

public class Bullet extends Model {


    protected double damage;
    protected double speed = 8;
    private double dx;
    private double dy;

    private boolean impacted;
    private long timeCreate;



    public Bullet(double damage, double x, double y, double angle) {
        this.damage = damage;
        setCoord(x, y);
        setAngle(angle);
        impacted = false;

        dx = Math.cos(Math.toRadians(angle)) * speed;
        dy =  Math.sin(Math.toRadians(angle)) * speed;
        timeCreate = System.currentTimeMillis();
    }

    public long getTimeCreate() {
        return timeCreate;
    }

    public void update(){
        x += dx;
        y -= dy;
    }

    public boolean isAway(){
        return !intersects(new Rectangle(0,0, MainFrame.WIDTH, MainFrame.HEIGHT));
    }

    public boolean isImpacted(){
        return impacted;
    }

    public void setImpacted(boolean impacted) {
        this.impacted = impacted;
    }

    public double getDamage() {
        return damage;
    }
}
