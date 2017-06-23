package view;

import model.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by MPN on 20/06/2017.
 */
public class GameFrame extends JFrame implements  KeyListener{


    private String IMGNAME = "C:\\Users\\Kerim\\Desktop\\NewGame\\view\\src\\main\\resources\\bground.png";
    public GameFrame() {
        this.setTitle("myGame");
        this.setSize(1366, 760);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(this);
        this.setContentPane(new GamePanel());
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            System.out.println("RIGHT");
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println("LEFT");
        }

        if (e.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("UP");
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("DOWN");
        }
    }

    public void keyReleased(KeyEvent keyEvent) {

    }
}
