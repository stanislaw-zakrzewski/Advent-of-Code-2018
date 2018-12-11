public class Batteries {
    private int[][] grid;

    public Batteries(int gridSerialNumber) {
        grid = new int[300][300];
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                int pom = j + 1 + 10;
                pom *= (i + 1);
                pom += 18;
                pom = ((pom % 1000) * (pom % 1000)) % 1000;
                pom = pom - pom % 100;
                pom /= 100;
                pom -= 5;
                grid[j][i] = pom;
            }
        }
        System.out.println(calculateValue(32,44));
    }

    public int[] findBest() {
        int[] best = new int[]{0, 0};
        for (int i = 0; i < 288; i++) {
            for (int j = 0; j < 288; j++) {
                if (calculateValue(i, j) > calculateValue(best[0], best[1])) {
                    best[0] = i;
                    best[1] = j;
                }
            }
        }
        best[0]++;
        best[1]++;
        return best;
    }

    private int calculateValue(int x, int y) {
        int ret = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                ret += grid[i][j];
            }
        }
        return ret;
    }
}
