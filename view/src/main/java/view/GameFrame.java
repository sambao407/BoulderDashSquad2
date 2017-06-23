package view;

import javax.swing.*;

/**
 * Created by MPN on 20/06/2017.
 */
public class GameFrame extends JFrame {
    public GameFrame() {
        this.setTitle("myGame");
        this.setSize(1366, 760);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.setContentPane(new GamePanel());
    }
}
