package tracks;

import algorithm.Move;
import cart.Cart;

import java.util.HashSet;

public class CurvedTrack implements ITrack {
    private int x;
    private int y;
    private HashSet<Move> elementMoves;

    public CurvedTrack(int x, int y) {
        this.x = x;
        this.y = y;
        elementMoves = new HashSet<>();
    }

    public void addMoves(Move first, Move second) {
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
        for (Move m : elementMoves) {
            if (!m.equals(lastMove)) {
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
