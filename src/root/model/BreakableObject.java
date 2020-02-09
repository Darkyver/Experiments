package root.model;


public class BreakableObject extends Model  {

    protected int healthPoint;

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
