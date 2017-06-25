package model;

/**
 * Created by Kerim on 16/06/2017.
 */
public class Wall extends Entity {
    /**
     * sprite_x value for Wall
     */
    private int sprite_x = 1;
    /**
     * sprite_y value for Wall
     */
    private int sprite_y = 1;

    /**
     * Constructor of class Wall
     */
    public Wall() {
    }

    /** getter of Sprite_x
     * @return sprite_x
     */
    public int getSprite_x() {
        return sprite_x;
    }
    /** getter of Sprite_y
     * @return sprite_y
     */
    public int getSprite_y() {
        return sprite_y;
    }
}
