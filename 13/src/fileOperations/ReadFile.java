package fileOperations;

import algorithm.Move;
import cart.Cart;
import tracks.AllTracks;
import tracks.CurvedTrack;
import tracks.Intersection;
import tracks.StraightTrack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReadFile {
    public static AllTracks readAllTracks() {
        AllTracks allTracks = new AllTracks();
        List<String> lines = new ArrayList<>();
        HashSet<Cart> carts = new HashSet<>();
        HashSet<CurvedTrack> curvedTracks = new HashSet<>();
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

        return allTracks;
    }
}
