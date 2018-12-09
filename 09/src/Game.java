import java.util.*;

public class Game {
    private int playerCount;
    private int marblesCount;
    private long[] players;
    private LinkedList<Integer> marbles;

    public Game() {
        int[] info = ReadFile.getGameInfo();
        playerCount = info[0];
        players = new long[playerCount];
        for (int i = 0; i < playerCount; i++) {
            players[i] = 0;
        }
        marblesCount = info[1];
        marbles = new LinkedList<>();
    }

    private void play() {
        marbles.add(0);
        marbles.add(0,1);
        for (int i = 2; i <= marblesCount; i++) {
            if (i % 23 == 0) {
                players[i%playerCount] += i;
                for (int j = 0; j < 7; j++) {
                    int a = marbles.getLast();
                    marbles.removeLast();
                    marbles.addFirst(a);
                }
                players[i%playerCount] += marbles.getFirst();
                marbles.removeFirst();
            }
            else{
                for (int j = 0; j < 2; j++) {
                    int a = marbles.getFirst();
                    marbles.removeFirst();
                    marbles.addLast(a);
                }
                marbles.addFirst(i);
            }
        }
    }

    long getHighScore() {
        play();
        long highScore = 0;
        for (Long l : players) {
            if (l > highScore) {
                highScore = l;
            }
        }
        return highScore;
    }

    long getHighScore_WhenMarblesTimes100() {
        marblesCount *= 100;
        play();
        long highScore = 0;
        for (Long l : players) {
            if (l > highScore) {
                highScore = l;
            }
        }
        return highScore;
    }
}
