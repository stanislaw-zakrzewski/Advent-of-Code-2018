import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static long twoOfKind;
    private static long threeOfKind;

    public static void main(String[] args) {
        List<String> boxes = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()) {
                boxes.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boxes.forEach(Main::checkSum);

        System.out.println(twoOfKind*threeOfKind);
    }

    private static void checkSum(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : chars) {
            if(map.containsKey(c)) {
                int pom = map.get(c);
                map.remove(c);
                map.put(c, pom + 1);
            } else {
                map.put(c,1);
            }
        }
        if(map.values().contains(3)) {
            threeOfKind++;
        }
        if(map.values().contains(2)) {
            twoOfKind++;
        }
    }
}
