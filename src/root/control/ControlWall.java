package root.control;

import root.model.Bullet;
import root.model.Model;
import root.model.Wall;
import root.view.ViewerWall;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ControlWall {

    private final String path = "save/walls.save";

    private ViewerWall viewerWall;
    private ArrayList<Wall> walls;

    public ControlWall(ViewerWall viewerWall) {
        walls = new ArrayList<>();
        this.viewerWall = viewerWall;


    }


    public void createWall(int x, int y, int width, int height, int healthPoint) {
        Wall wall = new Wall(healthPoint);
        wall.setCoord(x, y);
        wall.setSize(width, height);
        walls.add(wall);
    }

    public void addWall(Wall w) {
        walls.add(w);
    }

    public void saveWalls() {
        try {

            ClassLoader cl = this.getClass().getClassLoader();
            File f = new File("walls.save");
            if (!f.exists()) {
                f.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(f);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(walls);
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("fail save walls to walls.ser");
        } catch (IOException e) {
            System.out.println("fail create objectOutputStream to save walls.ser");
        }
    }

    public void loadWalls() {
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            InputStream inputStream = cl.getResourceAsStream(path);

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Object o = objectInputStream.readObject();
            walls = (ArrayList) o;

        } catch (FileNotFoundException e) {
            System.out.println("fail load walls.ser");
        } catch (IOException e) {
            System.out.println("fail create objectInputStream to load walls.ser");
        } catch (ClassNotFoundException e) {
            System.out.println("fail load wall from walls.ser");
        }
    }


    public void update() {
        for (int i = 0; i < walls.size(); i++) {
            Wall wall = walls.get(i);
            Model m = ControlBullet.getCollision(wall);
            if (m instanceof Bullet) {
                Bullet b = (Bullet) m;
                int damage = (int) b.getDamage();
                b.setImpacted(true);
                wall.takeDamage(damage);
            }
        }

    }

    public void render(Graphics2D g) {

        for (int i = 0; i < walls.size(); i++) {
            Wall wall = walls.get(i);
            viewerWall.render(g, wall);
        }

    }


}
