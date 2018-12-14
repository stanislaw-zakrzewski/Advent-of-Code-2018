package tracks;

import java.util.HashSet;
import java.util.Optional;

public class AllTracks {
    private HashSet<ITrack> tracks;

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
}
