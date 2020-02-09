package root.main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private GraphicsPanel graphicsPanel;
    private JFrame frame;


    public MainFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.setResizable(false);

        graphicsPanel = new GraphicsPanel(WIDTH, HEIGHT);
        frame.setContentPane(graphicsPanel);

        frame.pack();



        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    graphicsPanel.stop();

                    frame.dispose();
                } catch (InterruptedException e1) {

                }


            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }




    public void start(){

        frame.setVisible(true);
        graphicsPanel.start();
    }

    public void stop(){
        try {
            graphicsPanel.stop();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException closing");
        }

        frame.dispose();

    }
}
