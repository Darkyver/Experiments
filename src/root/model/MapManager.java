package root.model;

import root.control.ControlBullet;
import root.control.ControlCharacter;
import root.control.ControlTurret;
import root.control.ControlWall;
import root.main.MainFrame;
import root.utils.ControlWindow;
import root.view.ViewBullet;
import root.view.ViewTurret;
import root.view.ViewerWall;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MapManager implements MouseListener, MouseMotionListener, KeyListener, MouseWheelListener {

    private ControlBullet controlBullet;
    private ControlTurret controlTurret;
    private ControlWall controlWall;
    private ControlCharacter controlCharacter;

    public MapManager() {
        ViewTurret viewTurret = new ViewTurret();

        controlTurret = new ControlTurret(viewTurret);
        Random r = new Random();

        for (int i = 0; i < 2; i++) {
            controlTurret.createTurret(r.nextInt(MainFrame.WIDTH), r.nextInt(MainFrame.HEIGHT), 1000, 20);
        }


        ViewBullet viewBullet = new ViewBullet();
        controlBullet = new ControlBullet(viewBullet);

        Wall wall = new Wall(1000);
        wall.setCoord(300, 200);
        wall.setSize(200, 5);


        ViewerWall viewerWall = new ViewerWall();
        controlWall = new ControlWall(viewerWall);
//        controlWall.createWall(300, 500, 200, 30, 1000);
//        controlWall.createWall(300, 100, 300, 40, 2000);
//        controlWall.createWall(600, 200, 50, 400, 500);
//
//        controlWall.saveWalls();

        controlWall.loadWalls();



        TheCharacter character = new TheCharacter(0, 0, 0, 30, 30,  100);
        controlCharacter = new ControlCharacter(character);





    }

    public void save() {
//        controlWall.saveWalls();
    }


    public void render(Graphics2D g) {

        controlBullet.render(g);
        controlWall.render(g);
        controlTurret.render(g);
        controlCharacter.render(g);

    }

    public void update() {
        controlTurret.update();
        controlBullet.update();
        controlWall.update();
        controlCharacter.update();
    }


    //MOUSE LISTENER

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        controlTurret.mousePressed(e);
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

    //MOUSE MOTION
    @Override
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {
        controlTurret.mouseMoved(e);
    }
    //MOUSE MOTION END

    //KEY LISTENER
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        controlCharacter.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        controlCharacter.keyReleased(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(e.getWheelRotation()<0){
            ControlWindow.incScale();
        } else {
            ControlWindow.decScale();
        }
    }

    //KEY LISTENER END
}
