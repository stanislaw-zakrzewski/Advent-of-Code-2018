import java.util.List;

public class SkySimulator {
    private List<Point> points;

    public SkySimulator() {
        points = ReadFile.getPoints();
    }

    public void findInformation() {
        int previous = Math.abs(getMaxY() - getMinY());
        int time = -1;
        while (Math.abs(getMaxY() - getMinY()) <= previous) {
            time++;
            previous = Math.abs(getMaxY() - getMinY());
            points.forEach(Point::move);
        }
        points.forEach(Point::moveBack);
        System.out.println("1:");
        printInfo();
        System.out.println("2: " + time + " seconds");
    }

    private void printInfo() {
        int maxX = getMaxX();
        int minX = getMinX();
        int maxY = getMaxY();
        int minY = getMinY();
        int lengthY = Math.abs(maxY - minY) + 1;
        int lengthX = Math.abs(maxX - minX) + 1;
        char tab[][] = new char[lengthY][lengthX];
        for (int i = 0; i < lengthY; i++) {
            for (int j = 0; j < lengthX; j++) {
                tab[i][j] = ' ';
            }
        }
        for (Point p : points) {
            tab[p.getY() - minY][p.getX() - minX] = '#';
        }
        for (char[] row : tab) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private int getMaxX() {
        int maxX = points.get(0).getX();
        for (Point point : points) {
            if (point.getX() > maxX) {
                maxX = point.getX();
            }
        }
        return maxX;
    }

    private int getMinX() {
        int minX = points.get(0).getX();
        for (Point point : points) {
            if (point.getX() < minX) {
                minX = point.getX();
            }
        }
        return minX;
    }

    private int getMaxY() {
        int maxY = points.get(0).getY();
        for (Point point : points) {
            if (point.getY() > maxY) {
                maxY = point.getY();
            }
        }
        return maxY;
    }

    private int getMinY() {
        int minY = points.get(0).getY();
        for (Point point : points) {
            if (point.getY() < minY) {
                minY = point.getY();
            }
        }
        return minY;
    }
}
