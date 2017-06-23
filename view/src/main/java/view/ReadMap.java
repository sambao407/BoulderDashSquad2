package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadMap {

    private static final String FILENAME = "C:\\Users\\Kerim\\Desktop\\NewGame\\view\\src\\main\\resources\\test.txt";

    public ReadMap () {

    }

    public char[][] convertMap() {

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

            while ((idChar  = br.read()) != -1) {
                char mapChar = (char) idChar;
                if (idChar != 13 && idChar != 10) {
                    tabChar[width][height] = mapChar;
                    // System.out.println(" WIDTH : "+width+" HEIGHT : "+height+" CHAR : "+tabChar[width][height]);
                    width++;
                }
                else if (idChar == 10 && idChar != 13) {
                    width = 1;
                    height++;
                }
            }
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
}
