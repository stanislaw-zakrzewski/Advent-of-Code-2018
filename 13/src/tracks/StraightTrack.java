package tracks;

import algorithm.Move;
import cart.Cart;

import java.util.HashSet;

public class StraightTrack implements ITrack {
    private int x;
    private int y;
    private HashSet<Move> elementMoves;

    public StraightTrack(int x, int y, Move first, Move second) {
        this.x = x;
        this.y = y;
        elementMoves = new HashSet<>();
        elementMoves.add(first);
        elementMoves.add(second);
    }

    @Override
    public void moveCart(Cart c) {
        c.move(getPossibleMove(c.getLastMove()));
    }

    @Override
    public boolean containsMove(Move move) {
        return elementMoves.contains(move);
    }

    private Move getPossibleMove(Move lastMove) {
        for(Move m : elementMoves) {
            if(m.equals(lastMove)) {
                return m;
            }
        }
        return null;
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
