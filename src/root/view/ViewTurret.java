package root.view;

import root.model.Turret;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;



public class ViewTurret {

    private Image body;
    private Image gun;

    private boolean texturesLoadCompleted = true;


    public ViewTurret() {
//        body =  new ImageIcon("images/images/turretBody.png").getImage();
//        gun =  new ImageIcon("images/images/turretGun.png").getImage();

        ClassLoader cl = this.getClass().getClassLoader();
// создать изображения
        try {
            body  = new ImageIcon(cl.getResource("images/turretBody.png")).getImage();
            gun   = new ImageIcon(cl.getResource("images/turretGun.png")).getImage();
        } catch (Exception e) {
            texturesLoadCompleted = false;
        }


    }

    public void render(Graphics2D g, Turret t){
        g.setColor(Color.BLUE);
        int x = (int) t.getX();
        int y = (int) t.getY();
        int width = (int) t.getWidth();
        int height = (int) t.getHeight();
        int pop = 3;



        if(texturesLoadCompleted){
            g.drawImage(body, x - width/2,y - height/2,width,height, null);
        } else {
            g.drawRect(x - width/2,y - height/2,width,height);
            g.drawString(Integer.toString(t.getHealthPoint()), x - width/2 + pop, y + height/2 - pop);
        }


        //gun



        if(texturesLoadCompleted){
            AffineTransform origTr = g.getTransform();
            AffineTransform newTr = (AffineTransform) origTr.clone();

            newTr.rotate(Math.toRadians(-t.getAngle()), x, y);

            g.setTransform(newTr);

            g.drawImage(gun, x - width/2,y - height/2,width,height, null);

            g.setTransform(origTr);
        } else {
            int r = (width+height)/2;
            int gunX = (int)(x + Math.cos(Math.toRadians(t.getAngle())) * r);
            int gunY = (int)(y - Math.sin(Math.toRadians(t.getAngle())) * r);

            g.setColor(Color.red);
            g.drawLine(x,y,gunX,gunY);
        }







    }




}
