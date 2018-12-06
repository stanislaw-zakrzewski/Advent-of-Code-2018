import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Input {
    static String getInput() {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            return scanner.next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
