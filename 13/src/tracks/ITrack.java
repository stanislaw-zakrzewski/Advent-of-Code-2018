package tracks;

import algorithm.Move;
import cart.Cart;

public interface ITrack {
    void moveCart(Cart c);
    boolean containsMove(Move move);
    int getX();
    int getY();
}
