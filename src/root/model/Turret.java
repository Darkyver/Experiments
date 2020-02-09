package root.model;

public class Turret extends BreakableObject {

    protected double attackDamage;

    private double defaultAngle;
    private double turnGun = 360;
    private int turnD = 1;

    public Turret(int healthPoint, double attackDamage, double angle) {
        super(healthPoint);
        this.attackDamage = attackDamage;
        setAngle(angle);
        defaultAngle = angle;
    }

    public Turret(int x, int y, int healthPoint, double attackDamage, double angle) {
        this(healthPoint, attackDamage, angle);
        setCoord(x, y);
    }


    public Bullet fire(){
        Bullet bullet = new Bullet(attackDamage, x, y, angle);
        bullet.setSize(7,7);
        return bullet;
    }

    public void update(){
        angle += turnD;

        if(angle > defaultAngle + turnGun/2 || angle < defaultAngle - turnGun /2){
            turnD = -turnD;
        }
    }






}
