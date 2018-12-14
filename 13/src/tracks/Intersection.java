package tracks;

import algorithm.Move;
import cart.Cart;

public class Intersection implements ITrack {
    private int x;
    private int y;

    public Intersection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveCart(Cart c) {
        c.move(c.getIntersectionMove());
    }

    @Override
    public boolean containsMove(Move move) {
        return true;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
