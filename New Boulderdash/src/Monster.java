/**
 * Created by patri on 29/06/2017.
 */
public class Monster implements Cell {

    private boolean move;

    public Monster() {
        move = false;
    }
    public boolean getMove() {
        return move;
    }
    public void setMove(boolean m) {
        move = m;
    }
}
