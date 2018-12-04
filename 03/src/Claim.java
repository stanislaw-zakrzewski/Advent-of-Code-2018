public class Claim {
    private int elfID;
    private int x;
    private int y;
    private int width;
    private int height;

    public Claim(int elfID, int x, int y, int width, int height) {
        this.elfID = elfID;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getElfID() {
        return elfID;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
