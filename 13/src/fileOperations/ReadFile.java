package fileOperations;

import algorithm.Move;
import cart.Cart;
import tracks.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ReadFile {
    public static AllTracks readAllTracks() {
        AllTracks allTracks = new AllTracks();
        List<String> lines = new ArrayList<>();
        HashSet<Cart> carts = new HashSet<>();
        List<CurvedTrack> curvedTracks = new LinkedList<>();
        try {
            lines = Files.readAllLines(Paths.get("input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                switch (lines.get(i).charAt(j)) {
                    case '+':
                        allTracks.addTrack(new Intersection(i, j));
                        break;
                    case '-':
                        allTracks.addTrack(new StraightTrack(i, j, Move.LEFT, Move.RIGHT));
                        break;
                    case '|':
                        allTracks.addTrack(new StraightTrack(i, j, Move.UP, Move.DOWN));
                        break;
                    case '^':
                        carts.add(new Cart(i, j, Move.UP));
                        break;
                    case '<':
                        carts.add(new Cart(i, j, Move.LEFT));
                        break;
                    case '>':
                        carts.add(new Cart(i, j, Move.RIGHT));
                        break;
                    case 'v':
                        carts.add(new Cart(i, j, Move.DOWN));
                        break;
                    case '\\':
                    case '/':
                        curvedTracks.add(new CurvedTrack(i, j));
                        break;
                    default:
                        break;
                }
            }
        }

        for (CurvedTrack curvedTrack : curvedTracks) {
            curvedTrack.addMoves(movesForCurved(curvedTrack.getX(), curvedTrack.getY(), allTracks, carts));
        }
        curvedTracks.forEach(allTracks::addTrack);

        for (Cart cart : carts) {
            allTracks.addTrack(elementForCart(cart, allTracks));
        }
        allTracks.setCarts(carts);
        return allTracks;
    }

    private static List<Move> movesForCurved(int x, int y, AllTracks allTracks, HashSet<Cart> carts) {
        List<Move> ret = new ArrayList<>();
        Optional<ITrack> actualMove;
        actualMove = allTracks.getTrack(x - 1, y);

        if (actualMove.isPresent()) {
            ret.add(Move.UP);
            if (!actualMove.get().containsMove(Move.DOWN)) {
                ret.remove(Move.UP);
            }
        }
        if (carts.stream().anyMatch(c -> c.getX() == x - 1 && c.getY() == y) && !ret.contains(Move.UP)) {
            ret.add(Move.UP);
        }

        actualMove = allTracks.getTrack(x + 1, y);
        if (actualMove.isPresent()) {
            ret.add(Move.DOWN);
            if (!actualMove.get().containsMove(Move.UP)) {
                ret.remove(Move.DOWN);
            }
        }
        if (carts.stream().anyMatch(c -> c.getX() == x + 1 && c.getY() == y) && !ret.contains(Move.UP)) {
            ret.add(Move.DOWN);
        }

        actualMove = allTracks.getTrack(x, y - 1);
        if (actualMove.isPresent()) {
            ret.add(Move.LEFT);
            if (!actualMove.get().containsMove(Move.RIGHT)) {
                ret.remove(Move.LEFT);
            }
        }
        if (carts.stream().anyMatch(c -> c.getX() == x && c.getY() == y - 1) && !ret.contains(Move.UP)) {
            ret.add(Move.LEFT);
        }

        actualMove = allTracks.getTrack(x, y + 1);
        if (actualMove.isPresent()) {
            ret.add(Move.RIGHT);
            if (!actualMove.get().containsMove(Move.LEFT)) {
                ret.remove(Move.RIGHT);
            }
        }
        if (carts.stream().anyMatch(c -> c.getX() == x && c.getY() == y + 1) && !ret.contains(Move.UP)) {
            ret.add(Move.RIGHT);
        }

        if (ret.size() != 2) {
            System.out.println("error");
        }
        return ret;
    }

    private static ITrack elementForCart(Cart cart, AllTracks allTracks) {
        Optional<ITrack> upTrack = allTracks.getTrack(cart.getX() - 1, cart.getY());
        Optional<ITrack> downTrack = allTracks.getTrack(cart.getX() + 1, cart.getY());
        Optional<ITrack> leftTrack = allTracks.getTrack(cart.getX(), cart.getY() - 1);
        Optional<ITrack> rightTrack = allTracks.getTrack(cart.getX(), cart.getY() + 1);
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        if(upTrack.isPresent()) {
            up = upTrack.get().containsMove(Move.DOWN);
        }
        if(downTrack.isPresent()) {
            down = downTrack.get().containsMove(Move.UP);
        }
        if(leftTrack.isPresent()) {
            left = leftTrack.get().containsMove(Move.LEFT);
        }
        if(rightTrack.isPresent()) {
            right = rightTrack.get().containsMove(Move.RIGHT);
        }

        if(right && left && up && down) {
            return new Intersection(cart.getX(), cart.getY());
        }
        if(up && down) {
            return new StraightTrack(cart.getX(), cart.getY(), Move.UP, Move.DOWN);
        }
        if(left && right) {
            return new StraightTrack(cart.getX(), cart.getY(), Move.LEFT, Move.RIGHT);
        }
        CurvedTrack curvedTrack = new CurvedTrack(cart.getX(), cart.getY());
        LinkedList<Move> moves = new LinkedList<>();
        if(up) moves.add(Move.UP);
        if(down) moves.add(Move.DOWN);
        if(left) moves.add(Move.LEFT);
        if(right) moves.add(Move.RIGHT);
        curvedTrack.addMoves(moves);
        return curvedTrack;
    }
}
