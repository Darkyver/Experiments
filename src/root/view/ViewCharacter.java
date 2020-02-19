package root.view;

import root.model.TheCharacter;
import root.utils.ControlWindow;

import java.awt.*;

public class ViewCharacter {

    public void render(Graphics2D g, TheCharacter character){
        g.setColor(Color.BLACK);

        Point p = ControlWindow.toWindowCoordinate(character.getX(),character.getY());
        int x = (int) p.getX();
        int y = (int) p.getY();
        int width = (int) character.getWidth();
        int height = (int) character.getHeight();

        g.drawRect(x - width/2,y - height/2,width,height);
    }

}
