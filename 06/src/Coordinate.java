public class Coordinate {
    private int x;
    private int y;
    private int field;
    private boolean isInfinite;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        field = 0;
        isInfinite = false;
    }

    public void expandField() {
        field++;
    }

    public void setIsInfinite() {
        isInfinite = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getField() {
        return field;
    }

    public boolean isInfinite() {
        return isInfinite;
    }
}
