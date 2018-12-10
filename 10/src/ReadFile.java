import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static List<Point> getPoints() {
        List<Point> ret = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNext()) {
                String pom = scanner.next();
                if (pom.length() == 10) {
                    pom = scanner.next();
                } else {
                    pom = pom.substring(10);
                }
                int x = Integer.parseInt(pom.substring(0, pom.length() - 1));
                pom = scanner.next();
                int y = Integer.parseInt(pom.substring(0, pom.length() - 1));
                pom = scanner.next();
                if (pom.length() == 10) {
                    pom = scanner.next();
                    pom = pom.substring(0, pom.length() - 1);
                } else {
                    pom = pom.substring(10, pom.length() - 1);
                }
                int vX = Integer.parseInt(pom);
                pom = scanner.next();
                int vY = Integer.parseInt(pom.substring(0, pom.length() - 1));
                ret.add(new Point(x, y, vX, vY));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
