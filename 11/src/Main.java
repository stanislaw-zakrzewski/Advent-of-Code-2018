public class Main {
    private static final int gridSerialNumber = 7857;

    public static void main(String[] args) {
        Batteries batteries = new Batteries(gridSerialNumber);
        int[] best = batteries.findBest3by3();
        System.out.println("1: " + best[0] + "," + best[1]);
        int[] bestAny = batteries.findBestAnySize();
        System.out.println("2: " + bestAny[0] + "," + bestAny[1] + "," + bestAny[2]);
    }
}
