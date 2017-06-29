

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class Game extends JFrame implements KeyListener, ActionListener {

    private View view;
    private Model model;
    private JPanel infoPanel; // Instanciation d'un panneau pour montrer les diamants restants et récoltés.
    private JLabel diamonds; // Instanciation d'un texte, pour son affichage concernant les diamants.
    private int currentLevel; // Attribut pour déterminer le niveau actuel.
    public  static final int MAX_LEVELS = 6; // Attribut pour déterminer le niveau maximal.

    private Game() {
        setTitle("BoulderDashSquad");
        currentLevel = 6;
        model = new Model(getLevel(currentLevel)); //Récupération d'un niveau, en fonction de son niveau.
        view = new View(model.getCaveArray()); //Conversion des données contenues dans le niveau.
        this.setLayout(new BorderLayout()); // Définition de la disposition d'objets, sur le panneau.
        JButton click = new JButton(); //Définition d'un bouton.
        click.addActionListener(this); // Liaison du bouton à des commandes, permettant de rafraichir la fenetre et le déplacement des elements mobiles.
        click.addKeyListener(this); //Liaison du bouton au events clavier.
        infoPanel = new JPanel(); // Définition d'un panneau, sur l'actuel.
        diamonds = new JLabel(model.getDiamonds()); //Liaison entre la méthode et le texte pour afficher le nb de diamants manquants et totaux.
        infoPanel.add(diamonds); // Implémentation du texte concernant les diamants sur le panneau.
        this.add(infoPanel,BorderLayout.NORTH); // Positionnement du panneau, vers le dessus.
        this.add(click,BorderLayout.SOUTH); // Positionnement d'un bouton, vers le bas de la fenetre.
        this.add(view,BorderLayout.CENTER); // Positionnement de l'afichage de la carte convertie, au centre de la fenêtre.
        this.setResizable(false); // Verouillage du redimensionnement de la fenetre.
    }
    public static void main (String[] args) {
        Game game = new Game();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setLocation(300,120);
        game.pack();
        game.setVisible(true);
        Timer t; // Définition d'un timer pour exécuter des tâches à intervalle régulier.
        t = new Timer(300, game);
        t.start();
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_DOWN) {
            keyDown();
        } else if(key == KeyEvent.VK_UP) {
            keyUp();
        } else if(key == KeyEvent.VK_LEFT) {
            keyLeft();
        } else if(key == KeyEvent.VK_RIGHT) {
            keyRight();
        } else if(key == KeyEvent.VK_R) { //Refresh de la carte.
            model = new Model(getLevel(currentLevel));
            view.updateCave(model.getCaveArray());
            diamonds.setText(model.getDiamonds());
        } else if(key == KeyEvent.VK_Q) { //Fermer la fenêtre.
            this.dispose();
        }

    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    private void update() { //Màj constante de la fenêtre.
        view.updateCave(model.getCaveArray()); // Màj de la carte.
        diamonds.setText(model.getDiamonds());
        if(model.getLevelCompleted()) {
            if(currentLevel == MAX_LEVELS) {
                JOptionPane.showMessageDialog(this, "Game Completed!\nExit from this panel.");
            } else {
                JOptionPane.showMessageDialog(this, "Level Completed!\nClick OK to move on to the next one.");
                currentLevel++;
                model = new Model(getLevel(currentLevel));
                view.updateCave(model.getCaveArray());
                diamonds.setText(model.getDiamonds());
            }
        }
    }
    private void keyUp() {
        model.moveUp();
        update();
    }
    private void keyDown() {
        model.moveDown();
        update();
    }
    private void keyLeft() {
        model.moveLeft();
        update();
    }
    private void keyRight() {
        model.moveRight();
        update();
    }

    public void actionPerformed (ActionEvent e) {
        model.tick(); //Appliquer le mouvement des elements mobiles.
        model.tick2();
        view.updateCave(model.getCaveArray()); //Màj de la carte.
        diamonds.setText(model.getDiamonds());//
        if(model.getGameOver()) {
            JOptionPane.showMessageDialog(this, "You need more practice!\nPress OK to restart."); //Impression d'un message.

            //Relancement du level/
            model = new Model(getLevel(currentLevel));
            view.updateCave(model.getCaveArray());
            diamonds.setText(model.getDiamonds());
        }
    }
    public int[][] getLevel(int levelNumber) {
        int[][] level0 = {
                {1,1,1,1,1,1,1,1,1,1},
                {1,2,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,4,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,6,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,5,4,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1}};
        int[][] level1 = {
                {1,1,1,1,1,1,1,1,1,1},
                {1,2,0,0,0,0,0,4,0,1},
                {1,1,1,1,3,3,3,3,3,1},
                {1,6,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,5,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1}};
        int[][] level2 = {
                {1,1,1,1,1,1,1,1,1,1},
                {1,2,0,0,0,5,5,5,5,1},
                {1,1,1,1,3,3,3,3,3,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,3,3,3,1},
                {1,0,0,0,0,0,3,4,3,1},
                {1,0,0,0,0,0,3,4,3,1},
                {1,6,0,0,0,0,3,4,3,1},
                {1,1,1,1,1,1,1,1,1,1}};
        int[][] level3 = {
                {1,1,1,1,1,1,1,1,1,1},
                {1,3,3,3,0,3,4,3,3,1},
                {1,5,2,5,0,0,5,0,0,1},
                {1,3,3,3,3,3,3,3,3,1},
                {1,1,1,1,1,1,3,3,3,1},
                {1,3,3,3,4,4,3,3,3,1},
                {1,3,3,3,4,3,3,3,3,1},
                {1,0,5,0,5,1,1,1,1,1},
                {1,0,3,3,3,3,3,0,6,1},
                {1,1,1,1,1,1,1,1,1,1}};
        int[][] level4 = {
                {1,1,1,1,1,1,1,1,1,1},
                {1,5,2,1,4,3,3,1,6,1},
                {1,1,3,1,3,1,3,1,3,1},
                {1,4,3,1,3,1,4,1,3,1},
                {1,1,3,1,4,1,3,1,3,1},
                {1,4,3,1,3,1,0,1,3,1},
                {1,1,3,1,3,1,3,1,3,1},
                {1,4,3,1,3,1,3,1,3,1},
                {1,1,3,0,4,1,3,4,3,1},
                {1,1,1,1,1,1,1,1,1,1}};
        int[][] level5 = {
                {1,1,1,1,1,1,1,1,1,1},
                {1,2,0,3,4,4,0,3,3,1},
                {1,5,5,1,1,1,1,1,3,1},
                {1,5,3,3,3,3,4,4,3,1},
                {1,1,3,1,1,1,1,1,1,1},
                {1,4,3,3,3,3,3,3,4,1},
                {1,1,1,1,1,1,1,1,0,1},
                {1,0,0,4,0,0,3,0,0,1},
                {1,6,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1}};
        int[][] level6 = {
                {1,1,1,1,1,1,1,1,1,1},
                {1,0,4,0,0,0,4,0,0,1},
                {1,0,0,0,0,0,3,0,0,1},
                {1,0,0,0,5,0,0,5,0,1},
                {1,0,0,0,3,0,0,3,0,1},
                {1,0,0,0,3,8,0,5,0,1},
                {1,0,0,0,3,3,3,3,0,1},
                {1,6,0,0,3,0,0,1,0,1},
                {1,0,0,0,3,3,3,3,2,1},
                {1,1,1,1,1,1,1,1,1,1}};
        if(levelNumber == 1) {
            return level1;
        } else if(levelNumber == 2) {
            return level2;
        } else if(levelNumber == 3) {
            return level3;
        } else if(levelNumber == 4) {
            return level4;
        } else if(levelNumber == 5) {
            return level5;
        } else if(levelNumber == 6) {
            return level6;
        } else {
            return level0;
        }
    }
}