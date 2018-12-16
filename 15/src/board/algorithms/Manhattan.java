package board.algorithms;

import board.Board;
import board.boardElements.IBoardElement;

import java.util.*;

public class Manhattan {
    public static List<IBoardElement> getPath(IBoardElement start, IBoardElement end, Board board) {
        List<IBoardElement> path = new ArrayList<>();
        LinkedList<IBoardElement> opened = new LinkedList<>();
        opened.add(start);
        LinkedList<IBoardElement> closed = new LinkedList<>();
        IBoardElement actualElement;
        while (true) {
            opened.sort(Manhattan::manhattanDistance);
            actualElement = opened.getFirst();
            if(actualElement.equals(end)) {
                break;
            }
        }

        return path;
    }


    public static int manhattanDistance(IBoardElement a, IBoardElement b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }
}
