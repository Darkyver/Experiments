package root.model;


public class BreakableObject extends Model  {

    protected int healthPoint;

    public BreakableObject(double x, double y, double angle, double width, double height, int healthPoint) {
        super(x, y, angle, width, height);
        this.healthPoint = healthPoint;
    }

    public BreakableObject(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public void takeDamage(int damage){
        healthPoint -= damage;
    }


    public int getHealthPoint() {
        return healthPoint;
    }
}
