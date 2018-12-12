import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static Tunnel readTunnel() {
        List<Boolean> plants = new ArrayList<>();
        List<SpreadKey> spreadKeys = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            scanner.next();
            scanner.next();
            char[] plantsC = scanner.next().toCharArray();
            for (char c : plantsC) {
                plants.add(c == '#');
            }
            while(scanner.hasNext()) {
                char[] s = scanner.next().toCharArray();
                scanner.next();
                char[] c = scanner.next().toCharArray();
                spreadKeys.add(new SpreadKey(s[0] == '#', s[1] == '#', s[2] == '#', s[3] == '#', s[4] == '#', c[0] == '#'));
            }
            return new Tunnel(plants, spreadKeys);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
