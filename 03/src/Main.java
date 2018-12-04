import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Claim> claims = FileReader.readAllClaims();

        int[][] fabric = new int[1000][1000];
        int result = 0;

        for(Claim c : claims) {
            for(int i = c.getX(); i < c.getX()+c.getWidth(); i++) {
                for(int j = c.getY(); j < c.getY() + c.getHeight(); j++) {
                    fabric[i][j]++;
                }
            }
        }

        for(int i = 0; i < fabric.length; i++) {
            for(int j = 0; j < fabric[0].length; j++) {
                if(fabric[i][j]>=2) result++;
            }
        }
        System.out.println("1: " + result);

        for(Claim c : claims) {
            checkClaim(c, fabric);
        }
    }

    private static void checkClaim(Claim c, int[][] fabric) {
        for(int i = c.getX(); i < c.getX()+c.getWidth(); i++) {
            for(int j = c.getY(); j < c.getY() + c.getHeight(); j++) {
                if(fabric[i][j] > 1) {
                    return;
                }
            }
        }
        System.out.println("2: " + c.getElfID());
    }
}
