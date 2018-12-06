import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Coordinate> coordinates = CoordinatesFromFile.getCoordinates();

        //Setting minimal values
        int minX = coordinates.get(0).getX();
        int maxX = coordinates.get(0).getX();
        int minY = coordinates.get(0).getY();
        int maxY = coordinates.get(0).getY();
        for (Coordinate c : coordinates) {
            if (c.getX() < minX) minX = c.getX();
            if (c.getX() > maxX) maxX = c.getX();
            if (c.getY() < minY) minY = c.getY();
            if (c.getY() > maxY) maxY = c.getY();
        }

        //Setting filed sizes and checking if field is infinite
        for (int i = minX - 1; i <= maxX + 1; i++) {
            for (int j = minY - 1; j <= maxY + 1; j++) {
                List<Coordinate> closest = findClosest(coordinates, i, j);
                if (i == minX - 1 || i == maxX + 1 || j == minY - 1 || j == maxY + 1) {
                    if (closest.size() < 2) {
                        closest.get(0).setIsInfinite();
                    }
                } else {
                    if (closest.size() < 2) {
                        closest.get(0).expandField();
                    }
                }
            }
        }
        int max = 0;
        for (Coordinate c : coordinates) {
            if (!c.isInfinite()) {
                if (c.getField() > max) {
                    max = c.getField();
                }
            }
        }
        System.out.println("1: " + max);

        int under10000Count = 0;
        for (int i = minX - 1; i <= maxX + 1; i++) {
            for (int j = minY - 1; j <= maxY + 1; j++) {
                int sum = 0;
                for (Coordinate c : coordinates) {
                    sum += manhattanDistance(c.getX(), c.getY(), i,j);
                }
                if(sum < 10000) {
                    under10000Count++;
                }
            }
        }
        System.out.println("2: " + under10000Count);
    }

    private static List<Coordinate> findClosest(List<Coordinate> coordinates, int x, int y) {
        List<Coordinate> closest = new ArrayList<>();
        closest.add(coordinates.get(0));
        for (Coordinate c : coordinates) {
            int distance1 = manhattanDistance(c.getX(), c.getY(), x, y);
            int distance2 = manhattanDistance(closest.get(0).getX(), closest.get(0).getY(), x, y);
            if (distance1 == distance2) {
                closest.add(c);
            } else if (distance1 < distance2) {
                closest = new ArrayList<>();
                closest.add(c);
            }
        }
        return closest;
    }

    private static int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
