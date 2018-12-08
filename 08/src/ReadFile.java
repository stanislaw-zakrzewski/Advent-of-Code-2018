import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ReadFile {
    static List<Integer> getNumbers() {
        List<Integer> ret = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()) {
                ret.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
