package root.main;


import root.model.MapManager;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GraphicsPanel extends JPanel implements Runnable {


    private boolean running = false;

    private int FRAME_RATE = 60;
    private int IDLE = 1000/FRAME_RATE;
    private BufferedImage image;
    private BufferedImage background;

    private Graphics2D g;

    private Thread t;



    private MapManager mapManager;


    public GraphicsPanel(int width, int height) {
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
        image = new BufferedImage(MainFrame.WIDTH, MainFrame.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        background = new BufferedImage(MainFrame.WIDTH, MainFrame.HEIGHT, BufferedImage.TYPE_INT_ARGB);

        mapManager = new MapManager();


        addMouseListener(mapManager);
        addMouseMotionListener(mapManager);
        addKeyListener(mapManager);



        Graphics2D g = (Graphics2D) background.getGraphics();
        g.setColor(Color.green.darker().darker());
        g.fillRect(0,0, MainFrame.WIDTH, MainFrame.HEIGHT);

        Random r = new Random();
        int iteration = 1000;
        for (int i = 0; i < iteration/3; i++) {
            int size = r.nextInt(12);
            int x = r.nextInt(MainFrame.WIDTH);
            int y = r.nextInt(MainFrame.HEIGHT);
            g.setColor(Color.GREEN);
            g.fillRect(x,y,size,size);
        }
        for (int i = 0; i < iteration; i++) {
            int size = r.nextInt(12);
            int x = r.nextInt(MainFrame.WIDTH);
            int y = r.nextInt(MainFrame.HEIGHT);
            g.setColor(Color.GREEN.darker().darker().darker());
            g.fillRect(x,y,size,size);
        }

    }


    @Override
    public void run() {
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        while(running){
            update();

            render();

            try {
                Thread.sleep(IDLE);
            } catch (InterruptedException e) {

            }
        }


    }



    private void update(){
        mapManager.update();
    }

    private void render() {
        g.drawImage(background, 0,0, null);




        mapManager.render(g);

        swapImage();
    }

    private void swapImage(){
        getGraphics().drawImage(image, 0,0, null);
    }



    public void start(){
        if(t != null) return;

        running = true;
        t = new Thread(this);
        t.start();
    }

    public void stop() throws InterruptedException {
        if(!running) return;

        mapManager.save();
        running = false;
        t.join();

    }


}
