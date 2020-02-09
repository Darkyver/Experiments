package root.control;

import root.model.Turret;
import root.view.ViewTurret;

import javax.management.openmbean.ArrayType;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static root.utils.Calculate.angleOf;

public class ControlTurret implements ActionListener, MouseMotionListener {

    public static final int TURRET_SIZE = 70;
    public static final int TURRET_DAMAGE = 70;

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


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < turrets.size(); i++) {
            Turret t = turrets.get(i);
            ControlBullet.pushBullet(t.fire());
        }
    }







    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (int i = 0; i < turrets.size(); i++) {
            Turret t = turrets.get(i);
            int x = (int) t.getX(), y = (int) t.getY(), mX = e.getX(), mY = e.getY();
            t.setAngle(angleOf(x, y, mX, mY));
        }
    }
}
