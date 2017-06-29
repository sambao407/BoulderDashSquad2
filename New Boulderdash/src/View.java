 

import javax.swing.*;
import java.awt.GridLayout;
public class View extends JPanel {

    public static final int CAVE_SIZE = 10; // Définition de la taille de la carte.
    private JLabel[][] labels; //Instanciation d'un tableau 2D, pour récupérer le tableau à chaque mouvement.
    private Icon[] icons; //Instanciation d'un tableau ne contenant que des images. Cela va permettre la conversion des chiffres en images.

    public View(int[][] cave) {
        icons = new Icon[9];
        icons[0] = new ImageIcon("void.png");
        icons[1] = new ImageIcon("wall.png");
        icons[2] = new ImageIcon("player.png");
        icons[3] = new ImageIcon("mud.png");
        icons[4] = new ImageIcon("diamond.png");
        icons[5] = new ImageIcon("boulder.png");
        icons[6] = new ImageIcon("exitlocked.png");
        icons[7] = new ImageIcon("exitopen.png");
        icons[8] = new ImageIcon("monster1.png");

        setLayout(new GridLayout(CAVE_SIZE,CAVE_SIZE)); // Positionnement de la taille de la carte. Sans cela, l'affichage se fera de manière rectiligne.

        labels = new JLabel[CAVE_SIZE][CAVE_SIZE]; //Faire correspondre le tableau 2D à un tableau défini.
        // Cela va ainsi permettre le remplissage du tableau. (et ainsi de pouvoir màj la carte).

        for (int x = 0; x < CAVE_SIZE; x++) {
            for (int y = 0; y < CAVE_SIZE; y++) {
                labels[x][y] = new JLabel(icons[cave[y][x]]);
                add(labels[x][y]);
            }     
        }
    }

    //Màj de la carte dans un nouveau tableau 2D.
    public void updateCave(int[][] newCaveArray) {
        for (int x = 0; x < CAVE_SIZE; x++) {
            for (int y = 0; y < CAVE_SIZE; y++) {
                labels[x][y].setIcon(icons[newCaveArray[y][x]]);
            }
        }
    }
}