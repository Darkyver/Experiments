package root.view;

import root.model.Bullet;

import java.awt.*;

public class ViewBullet {



    public void render(Graphics2D g, Bullet b){
        g.setColor(Color.BLACK);
        int x = (int) b.getX();
        int y = (int) b.getY();
        int width = (int) b.getWidth();
        int height = (int) b.getHeight();

        g.fillOval(x - width/2,y - height/2,width,height);


    }
}
