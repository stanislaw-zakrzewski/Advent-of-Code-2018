import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class ReadFile {
    static Tunnel readTunnel() {
        Set<Integer> plants = new HashSet<>();
        HashMap<String, Boolean> spreadKeys = new HashMap<>();
        Tunnel tunnel = null;
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            scanner.next();
            scanner.next();
            char[] plantsC = scanner.next().toCharArray();
            for (int i = 0; i < plantsC.length; i++) {
                if (plantsC[i] == '#') {
                    plants.add(i);
                }
            }
            while (scanner.hasNext()) {
                String s = scanner.next();
                scanner.next();
                char[] c = scanner.next().toCharArray();
                spreadKeys.put(s, c[0] == '#');
            }
            tunnel = new Tunnel(plants, spreadKeys);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tunnel;
    }
}
