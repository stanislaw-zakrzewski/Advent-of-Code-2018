import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoordinatesFromFile {
    public static List<Coordinate> getCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        {
            try {
                Scanner scanner = new Scanner(new File("input.txt"));
                while (scanner.hasNext()) {
                    String pom = scanner.next();
                    int x = Integer.parseInt(pom.substring(0,pom.length()-1));
                    int y = scanner.nextInt();
                    coordinates.add(new Coordinate(x,y));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return coordinates;
    }
}
