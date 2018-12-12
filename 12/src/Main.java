public class Main {
    public static void main(String[] args) {
        Tunnel tunnel = ReadFile.readTunnel();
        tunnel.goThroughNGenerations(98);
        System.out.println("1: " + tunnel.getSumOfPots());
        tunnel = ReadFile.readTunnel();
        //k must be higher than 98
        int k = 200;
        tunnel.goThroughNGenerations(k);
        System.out.println("2: " + (tunnel.getSumOfPots() + (50000000000L - k) * 81 ));
    }
}
