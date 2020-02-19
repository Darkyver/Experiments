package root.view;

import root.model.Bullet;
import root.utils.ControlWindow;

import java.awt.*;

public class ViewBullet {



    public void render(Graphics2D g, Bullet b){
        g.setColor(Color.BLACK);

        Point p = ControlWindow.toWindowCoordinate(b.getX(),b.getY());
        int x = (int) p.getX();
        int y = (int) p.getY();
        int width = (int) b.getWidth();
        int height = (int) b.getHeight();

        g.fillOval(x - width/2,y - height/2,width,height);


    }
}
