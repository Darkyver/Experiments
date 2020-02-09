package root.view;

import root.model.Wall;

import java.awt.*;

public class ViewerWall {


    public void render(Graphics2D g, Wall wall){
        g.setColor(Color.GRAY);

        int x = (int) wall.getX();
        int y = (int) wall.getY();
        int width = (int) wall.getWidth();
        int height = (int) wall.getHeight();
        int pop = 3;

        g.fillRect(x - width/2,y - height/2,width,height);

        g.setColor(Color.black);
        g.drawRect(x - width/2,y - height/2,width,height);
        g.drawString(Integer.toString(wall.getHealthPoint()), x - width/2 + pop, y + height/2 - pop);


    }


}
