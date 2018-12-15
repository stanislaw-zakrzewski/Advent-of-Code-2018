package tracks;

import algorithm.Move;
import cart.Cart;

import java.util.HashSet;
import java.util.List;

public class CurvedTrack implements ITrack {
    private int x;
    private int y;
    private HashSet<Move> elementMoves;

    public CurvedTrack(int x, int y) {
        this.x = x;
        this.y = y;
        elementMoves = new HashSet<>();
    }

    public void addMoves(List<Move> moves) {
        elementMoves.addAll(moves);
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
            if (!m.equals(opposite(lastMove))) {
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

    private Move opposite(Move move) {
        if(move == Move.UP) return Move.DOWN;
        if(move == Move.DOWN) return Move.UP;
        if(move == Move.LEFT) return Move.RIGHT;
        if(move == Move.RIGHT) return Move.LEFT;
        return null;
    }
}
