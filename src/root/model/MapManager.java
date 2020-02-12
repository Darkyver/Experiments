package root.model;

import root.control.ControlBullet;
import root.control.ControlTurret;
import root.control.ControlWall;
import root.main.MainFrame;
import root.view.ViewBullet;
import root.view.ViewTurret;
import root.view.ViewerWall;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Random;

public class MapManager implements MouseListener, MouseMotionListener {

    private ControlBullet controlBullet;
    private ControlTurret controlTurret;
    private ControlWall controlWall;

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
        controlWall.createWall(300, 500, 200, 30, 1000);
        controlWall.createWall(300, 100, 300, 40, 2000);
        controlWall.createWall(600, 200, 20, 150, 500);

        controlWall.saveWalls();

//        controlWall.loadWalls();







    }

    public void save() {
        controlWall.saveWalls();
    }


    public void render(Graphics2D g) {

        controlBullet.render(g);
        controlWall.render(g);
        controlTurret.render(g);
    }

    public void update() {
        controlTurret.update();
        controlBullet.update();
        controlWall.update();
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

        controlTurret.actionPerformed(new ActionEvent(e.getSource(), e.getID(), e.paramString()));
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        controlTurret.mouseMoved(e);
    }
}
