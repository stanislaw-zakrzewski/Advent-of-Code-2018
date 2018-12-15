package tracks;

import algorithm.Move;
import cart.Cart;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;

public class AllTracks {
    private HashSet<ITrack> tracks;
    private LinkedList<Cart> carts;

    public AllTracks() {
        this.tracks = new HashSet<>();
    }

    public void addTrack(ITrack track) {
        tracks.add(track);
    }

    public Optional<ITrack> getTrack(int x, int y) {
        return tracks.stream().filter(t -> t.getX() == x && t.getY() == y).findFirst();
    }

    public HashSet<ITrack> getTracks() {
        return tracks;
    }

    public LinkedList<Cart> getCarts() {
        return carts;
    }

    public void setCarts(HashSet<Cart> carts) {
        this.carts = new LinkedList<>();
        this.carts.addAll(carts);
    }
}
