import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    private static int place;
    public static void main(String[] args) {
        List<String> boxes = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()) {
                boxes.add(scanner.nextLine());
            }
        } catch (FileNotFoundException ignored) {
        }

        for(int i = 0; i < boxes.size(); i++) {
            for(int j = i; j < boxes.size(); j++) {
                if(compare(boxes.get(i), boxes.get(j)) == 1) {
                    char[] pom =  boxes.get(i).toCharArray();
                    for(int k = 0; k < pom.length; k++) {
                        if(k != place) {
                            System.out.print(pom[k]);
                        }
                    }
                }
            }
        }
    }

    private static int compare(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int pom = 0;
        for(int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i]) {
                pom++;
                place = i;
            }
        }
        return pom;
    }
}
