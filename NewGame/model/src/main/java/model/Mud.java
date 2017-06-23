package model;

public class Mud extends Entity {
    private int sprite_x;
    private int sprite_y;

    public Mud(int sprite_x, int sprite_y) {
        this.sprite_x = sprite_x;
        this.sprite_y = sprite_y;
    }
    public int getSprite_x() {
        return sprite_x;
    }
    public int getSprite_y() {
        return sprite_y;
    }
}