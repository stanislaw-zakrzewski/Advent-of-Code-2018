public class SpreadKey {
    private final boolean ll;
    private final boolean l;
    private final boolean c;
    private final boolean r;
    private final boolean rr;
    private final boolean value;

    public SpreadKey(boolean ll, boolean l, boolean c, boolean r, boolean rr, boolean value) {
        this.ll = ll;
        this.l = l;
        this.c = c;
        this.r = r;
        this.rr = rr;
        this.value = value;
    }

    public boolean isLl() {
        return ll;
    }

    public boolean isL() {
        return l;
    }

    public boolean isC() {
        return c;
    }

    public boolean isR() {
        return r;
    }

    public boolean isRr() {
        return rr;
    }

    public boolean isValue() {
        return value;
    }
}
