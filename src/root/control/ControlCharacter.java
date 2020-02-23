package root.control;

import root.model.TheCharacter;
import root.view.ViewCharacter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlCharacter implements KeyListener {

    private TheCharacter character;
    private ViewCharacter viewer;

    public ControlCharacter(TheCharacter character) {
        this.character = character;
        viewer = new ViewCharacter();
    }


    public void update(){
        character.update();
    }

    public void render(Graphics2D g){
        viewer.render(g, character);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int i = e.getKeyCode();
        if (i == KeyEvent.VK_W) {
            character.setDirection(TheCharacter.UP);
        }

        if (i == KeyEvent.VK_D) {
            character.setDirection(TheCharacter.RIGHT);
        }

        if (i == KeyEvent.VK_S) {
            character.setDirection(TheCharacter.DOWN);
        }

        if (i == KeyEvent.VK_A) {
            character.setDirection(TheCharacter.LEFT);
        }

        if (i == KeyEvent.VK_Y) {
            character.grabFocus(!character.isFocusFrame());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        character.setDirection(TheCharacter.STOP);
    }

    public void fixFrameOnCharacter(){

    }
}
