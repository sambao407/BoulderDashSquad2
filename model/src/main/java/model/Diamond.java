package model;

/**
 * Created by Kerim on 16/06/2017.
 */
public class Diamond extends Entity {
    /**
     * Sprite size
     */
    private int sprite_x = 5;
    private int sprite_y = 1;

    /**
     * Constructor of Diamond
     */
    public Diamond() {
    }

    /**
     * getter Sprite_x
     * @return sprite_x
     */
    public int getSprite_x() {
        return sprite_x;
    }

    /**
     * getter Sprite_y
     * @return sprite_y
     */
    public int getSprite_y() {
        return sprite_y;
    }
}