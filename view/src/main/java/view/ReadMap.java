package view;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Level;


/**
 * Created by patricia on 16/06/2017.
 */
public class ReadMap {

    private static Level level;
    private String FILENAME;


    public ReadMap() {

    }

    public char[][] convertMap() {

        this.level = new Level();
        FILENAME = level.getLevelName(5);
        FileReader fr = null;
        BufferedReader br = null;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            int idChar;
            char tabChar[][] = new char[999][999];
            int width = 1;
            int height = 1;

            br = new BufferedReader(new FileReader(FILENAME));

            while ((idChar = br.read()) != -1) {
                char mapChar = (char) idChar;
                if (idChar != 13 && idChar != 10) {
                    tabChar[width][height] = mapChar;
                    width++;
                } else if (idChar == 10 && idChar != 13) {
                    width = 1;
                    height++;
                }
            }

            level.setLevelsize(height);
            System.out.println(" GET MAX START : "+level.getLevelsize());
            return tabChar;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
    public static int getHeight(){
        return level.getLevelsize();
    }
}
