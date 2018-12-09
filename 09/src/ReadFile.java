import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ReadFile {
    static int[] getGameInfo() {
        int[] ret = new int[2];
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            ret[0] = scanner.nextInt();
            scanner.next();
            scanner.next();
            scanner.next();
            scanner.next();
            scanner.next();
            ret[1] = scanner.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
