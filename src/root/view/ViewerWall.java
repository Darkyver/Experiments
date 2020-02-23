package root.view;

import root.model.Wall;
import root.utils.ControlWindow;

import javax.swing.*;
import java.awt.*;

public class ViewerWall {
    private Image wallBlock;
    private boolean texturesLoadCompleted = true;


    public void render(Graphics2D g, Wall wall){
        ClassLoader cl = this.getClass().getClassLoader();
// создать изображения
        try {
            wallBlock  = new ImageIcon(cl.getResource("images/wall.png")).getImage();
        } catch (Exception e) {
            texturesLoadCompleted = false;
        }


        g.setColor(Color.GRAY);

        int pop = 3;
        Point p = ControlWindow.toWindowCoordinate(wall.getX(),wall.getY());
        int x = (int) p.getX();
        int y = (int) p.getY();
        int width = (int) ControlWindow.toScale(wall.getWidth());
        int height = (int) ControlWindow.toScale(wall.getHeight());


        if(texturesLoadCompleted){
            if(width<height){
                //вертикальная стена
                int count = height / width;
                double newHeight = height / (float) count;
                int xNow = x - width/2;
                for (int i = 0; i < count; i++) {
                    int yNow = (int) (newHeight * i) + y - height / 2;
                    g.drawImage(wallBlock, xNow, yNow, width, (int) newHeight+pop, null);
                }

            }else{
                //горизонтальная стена
                int count = width / height;
                double newWidth = width / (float) count;
                int yNow = y - height/2;
                for (int i = 0; i < count; i++) {
                    int xNow = (int) (newWidth * i + x - width / 2);
                    g.drawImage(wallBlock, xNow, yNow, (int) newWidth + pop, height, null);
                }
            }


            g.setColor(Color.black);
            g.drawString(Integer.toString(wall.getHealthPoint()), x - width/2 + pop, y + height/2 - pop);
        }else{
            g.fillRect(x - width/2,y - height/2,width,height);


            g.drawRect(x - width/2,y - height/2,width,height);
            g.drawString(Integer.toString(wall.getHealthPoint()), x - width/2 + pop, y + height/2 - pop);
        }




    }


}
