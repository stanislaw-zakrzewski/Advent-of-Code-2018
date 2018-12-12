public class Main {
    public static void main(String[] args) {
        Tunnel tunnnel = ReadFile.readTunnel();
        //10000 too low
        for (int i = 0; i < 1000; i++) {
            tunnnel.goThroughNGenerations(50000000);
            System.out.println(i);
        }
        System.out.println("1: " + tunnnel.getSumOfPots());
    }
}
