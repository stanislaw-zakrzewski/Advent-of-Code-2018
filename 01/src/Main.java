import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int result = 0;
        List<Integer> visited = new ArrayList<>();
        visited.add(0);
        try {
            Scanner scanner = new Scanner((new File("input.txt")));
            while (scanner.hasNext()) {
                result += scanner.nextInt();
                if (visited.contains(result)) {
                    System.out.println("2 answer: " + result);
                    break;
                } else {
                    visited.add(result);
                }
                if (!scanner.hasNext()) {
                    scanner = new Scanner((new File("input.txt")));
                }
            }
            System.out.println("1 answer: " + result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
