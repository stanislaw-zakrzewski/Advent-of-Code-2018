public class Point {
    private int x;
    private int y;
    private int vX;
    private int vY;

    public Point(int x, int y, int vX, int vY) {
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
    }

    public void move() {
        x += vX;
        y += vY;
    }

    public void moveBack() {
        x -= vX;
        y -= vY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
