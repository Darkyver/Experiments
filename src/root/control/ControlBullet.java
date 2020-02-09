package root.control;

import root.model.Bullet;
import root.model.Model;
import root.utils.Observer;
import root.view.ViewBullet;

import java.awt.*;
import java.util.ArrayList;

public class ControlBullet {


    private static ArrayList<Bullet> bullets = new ArrayList<>();;

    private ViewBullet viewBullet;

    public ControlBullet(ViewBullet viewBullet) {

        this.viewBullet = viewBullet;
    }



    public static void pushBullet(Bullet b){
        bullets.add(b);
        Observer.addModel(b);
    }

    public static Model getCollision(Model m){
        for (Model m2 :
                bullets) {
            if (m.intersects(m2)){
                return m2;
            }
        }

        return null;
    }


    public void update(){

        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            b.update();
            if(b.isAway() | b.isImpacted()){
                bullets.remove(b);
            }
        }


    }

    public void render(Graphics2D g){
        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            viewBullet.render(g, b);
        }
    }

    public static int getCount(){
        return bullets.size();
    }
}
