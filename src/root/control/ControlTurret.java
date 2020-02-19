package root.control;

import root.model.Turret;
import root.utils.ControlWindow;
import root.view.ViewTurret;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static root.utils.Calculate.angleOf;

public class ControlTurret implements MouseListener, MouseMotionListener {

    public static final int TURRET_SIZE = 70;

    private ArrayList<Turret> turrets;
    private ViewTurret viewTurret;

    public ControlTurret(ViewTurret viewTurret) {
        turrets = new ArrayList<>();
        this.viewTurret = viewTurret;
    }


    public void createTurret(int x, int y,  int healthPoint, double attackDamage){
        Turret t = new Turret(x, y,healthPoint, attackDamage, 0);

        t.setSize(TURRET_SIZE, TURRET_SIZE);

        turrets.add(t);
    }


    public void update() {
//        t.update();
    }


    public void render(Graphics2D g) {
        for (int i = 0; i < turrets.size(); i++) {
            viewTurret.render(g, turrets.get(i));
        }
    }

    private void turnTurret(Turret t, double x, double y){
        int tx = (int) t.getX();
        int ty = (int) t.getY();

        Point p = ControlWindow.toMapCoordinate(x, y);
        int mX = (int) p.getX();
        int mY = (int) p.getY();


        t.setAngle(angleOf(tx, ty, mX, mY));
    }


    //MOUSE MOTION
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (int i = 0; i < turrets.size(); i++) {
            Turret t = turrets.get(i);
            turnTurret(t, e.getX(), e.getY());
        }
    }
    //MOUSE MOTION END



    //MOUSE LISTENER
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < turrets.size(); i++) {
            Turret t = turrets.get(i);
            turnTurret(t, e.getX(), e.getY());
            ControlBullet.pushBullet(t.fire());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    //MOUSE LISTENER END
}
