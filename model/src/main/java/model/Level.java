package model;

/**
 * Created by MPN on 21/06/2017.
 */
public class Level {
    private String LEVELNAME;
    private int levelsize;

    public Level() {
    }

    public void setLevelsize(int levelsize) {
        this.levelsize = levelsize;
    }

    public int getLevelsize() {
        return levelsize;
    }

    public String getLevelName(int levelNumb) {
        switch (levelNumb) {
            case 1:
                LEVELNAME = "C:\\Users\\Samba\\Workspace2\\BoulerDashSquad\\view\\src\\main\\resources\\LVL1.txt";
                break;
            case 2:
                LEVELNAME = "C:\\Users\\Samba\\Workspace2\\BoulerDashSquad\\view\\src\\main\\resources\\LVL2.txt";
                break;
            case 3:
                LEVELNAME = "C:\\Users\\Samba\\Workspace2\\BoulerDashSquad\\view\\src\\main\\resources\\LVL3.txt";
                break;
            case 4:
                LEVELNAME = "C:\\Users\\Samba\\Workspace2\\BoulerDashSquad\\view\\src\\main\\resources\\LVL4.txt";
                break;
            case 5:
                LEVELNAME = "C:\\Users\\Samba\\Workspace2\\BoulerDashSquad\\view\\src\\main\\resources\\LVL5.txt";
                break;
            default:
                LEVELNAME = "C:\\Users\\Samba\\Workspace2\\BoulerDashSquad\\view\\src\\main\\resources\\LVL1.txt";
                break;
        }
        return LEVELNAME;
    }
}
