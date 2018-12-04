import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<Claim> readAllClaims() {
        List<Claim> claims = new ArrayList<>();
        File file = new File("input.txt");
        int elfID, x, y,width, height;
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                elfID = Integer.parseInt(scanner.next().substring(1));
                scanner.next();
                String[] xy = scanner.next().split(",");
                x = Integer.parseInt(xy[0]);
                y = Integer.parseInt(xy[1].substring(0,xy[1].length()-1));
                String[] wh = scanner.next().split("x");
                width = Integer.parseInt(wh[0]);
                height = Integer.parseInt(wh[1]);
                claims.add(new Claim(elfID, x, y,width, height));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return claims;
    }
}
