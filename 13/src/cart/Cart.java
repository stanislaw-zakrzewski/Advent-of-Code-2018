package cart;

import algorithm.Move;

import java.util.LinkedList;

public class Cart {
    private int x;
    private int y;
    private Move lastMove;
    private LinkedList<Move> intersectionMoves;

    public Cart(int x, int y, Move lastMove) {
        this.x = x;
        this.y = y;
        this.lastMove = lastMove;
        intersectionMoves = new LinkedList<>();
        intersectionMoves.addLast(Move.LEFT);
        intersectionMoves.addLast(Move.UP);
        intersectionMoves.addLast(Move.RIGHT);
    }

    public Move getIntersectionMove() {
        Move move = intersectionMoves.getFirst();
        intersectionMoves.addLast(intersectionMoves.getFirst());
        intersectionMoves.removeFirst();
        switch (lastMove) {
            case DOWN:
                if (move == Move.LEFT) move = Move.RIGHT;
                else if (move == Move.UP) move = Move.DOWN;
                else if (move == Move.RIGHT) move = Move.LEFT;
                break;
            case LEFT:
                if (move == Move.LEFT) move = Move.DOWN;
                else if (move == Move.UP) move = Move.LEFT;
                else if (move == Move.RIGHT) move = Move.UP;
                break;
            case RIGHT:
                if (move == Move.LEFT) move = Move.UP;
                else if (move == Move.UP) move = Move.RIGHT;
                else if (move == Move.RIGHT) move = Move.DOWN;
                break;
            default:
                break;
        }
        return move;
    }

    public void move(Move move) {
        lastMove = move;
        switch (move) {
            case UP:
                x--;
                break;
            case DOWN:
                x++;
                break;
            case LEFT:
                y--;
                break;
            case RIGHT:
                y++;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Move getLastMove() {
        return lastMove;
    }
}
