package view;

import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {

    // Chemin de la fiche de sprite
    private static final String bgroundPATH = "C:\\Users\\MPN\\Desktop\\NewGame\\view\\src\\main\\resources\\bground.png";
    private static final String playerPATH = "C:\\Users\\MPN\\Desktop\\NewGame\\view\\src\\main\\resources\\player.png";
    // Taille en pixels des éléments de la carte
    private int map_x;
    private int map_y;

    // Taille en pixels des sprites
    private int cell_x;
    private int cell_y;

    public void paintComponent(Graphics graphics) {


        Entity entity = new Entity();
        Wall wall = new Wall();
        Ground ground = new Ground();
        Diamond diamond = new Diamond();
        Boulder boulder = new Boulder();
        Mud mud = new Mud();
        Player player = new Player();

        char[][] tab = new ReadMap().convertMap();
        int levelsize = new ReadMap().getHeight();
        System.out.println(" GET MAX END : "+levelsize);

        int tabX = 1;
        int tabY = 1;
        String IMGNAME;

        try {
            for (int coord_y = 1; coord_y <= levelsize; coord_y++){
                map_y = entity.getSpritesize() * coord_y;

                for (int coord_x = 1; coord_x <= levelsize; coord_x++){
                    map_x = entity.getSpritesize() * coord_x;
                    // System.out.println(" WIDTH : "+tabX+" HEIGHT : "+tabY+" CHAR : "+tab[tabX][tabY]);
                    // System.out.println(" MAX : "+level.getLevelsize());
                    switch (tab[tabX][tabY]) {
                        case 'W':
                            IMGNAME = bgroundPATH;
                            cell_x = 16 * wall.getSprite_x();
                            cell_y = 16 * wall.getSprite_y();
                            break;
                        case 'D':
                            IMGNAME = bgroundPATH;
                            cell_x = 16 * diamond.getSprite_x();
                            cell_y = 16 * diamond.getSprite_y();
                            break;
                        case 'B':
                            IMGNAME = bgroundPATH;
                            cell_x = 16 * boulder.getSprite_x();
                            cell_y = 16 * boulder.getSprite_y();
                            break;
                        case 'M':
                            IMGNAME = bgroundPATH;
                            cell_x = 16 * mud.getSprite_x();
                            cell_y = 16 * mud.getSprite_y();
                            break;
                        case 'P':
                            IMGNAME = playerPATH;
                            cell_x = 16 * player.getSprite_x();
                            cell_y = 16 * player.getSprite_y();
                            break;
                        default:
                            IMGNAME = bgroundPATH;
                            cell_x = 16 * ground.getSprite_x();
                            cell_y = 16 * ground.getSprite_y();
                            break;
                    }

                    Image img = ImageIO.read(new File(IMGNAME));
                    graphics.drawImage(img,
                            map_x, map_y, // Decalage case DROITE, BAS
                            map_x - entity.getSpritesize(), map_y - entity.getSpritesize(), // Decalage case GAUCHE, HAUT
                            cell_x, cell_y, // Selection cellule DROITE, BAS
                            cell_x - 16, cell_y - 16, // Selection cellule GAUCHE, HAUT
                            this);

                    if (tabX != levelsize) {
                        tabX++;
                    }
                    else {
                        tabX = 1;
                        tabY++;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}