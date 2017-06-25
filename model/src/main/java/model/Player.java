package model;

/**
 * Created by Kerim on 19/06/2017.
 */

public class Player extends Entity {
    /**
     * sprite_x value for Player
     */
    private int sprite_x = 1;
    /** sprite_y value for Player
     *
     */
    private int sprite_y = 1;

    /** Constructor of class player
     *
     */
    public Player() {
    }

    /**
     * getter of Sprite_x
     * @return sprite_x
     */
    public int getSprite_x() {
        return sprite_x;
    }

    /**
     * getter of Sprite_y
     * @return sprite_y
     */
    public int getSprite_y() {
        return sprite_y;
    }
}
