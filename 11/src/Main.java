public class Main {
    private static final int gridSerialNumber = 18;

    public static void main(String[] args) {
        Batteries batteries = new Batteries(gridSerialNumber);
        int[] best = batteries.findBest();
        System.out.println("1: " + best[0] + "," + best[1]);
    }
}
