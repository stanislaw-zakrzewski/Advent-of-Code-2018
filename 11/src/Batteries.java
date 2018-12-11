class Batteries {
    private int[][] grid;

    Batteries(int gridSerialNumber) {
        grid = new int[300][300];
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                int pom = i + 1 + 10;
                pom *= (j + 1);
                pom += gridSerialNumber;
                pom = ((pom % 1000) * ((i + 1 + 10) % 1000)) % 1000;
                pom = pom - pom % 100;
                pom /= 100;
                pom -= 5;
                grid[i][j] = pom;
            }
        }
    }

    int[] findBest3by3() {
        int[] best = new int[]{0, 0};
        for (int i = 0; i < 288; i++) {
            for (int j = 0; j < 288; j++) {
                if (calculateValue(i, j, 3) > calculateValue(best[0], best[1], 3)) {
                    best[0] = i;
                    best[1] = j;
                }
            }
        }
        best[0]++;
        best[1]++;
        return best;
    }

    int[] findBestAnySize() {
        int[] best = new int[]{0, 0, 0};
        int bestValue = 0;
        for (int s = 1; s < 300; s++) {
            for (int i = 0; i < 300 - s; i++) {
                for (int j = 0; j < 300 - s; j++) {
                    int nextValue = calculateValue(i, j, s);
                    if (nextValue > bestValue) {
                        bestValue = nextValue;
                        best[0] = i;
                        best[1] = j;
                        best[2] = s;
                    }
                }
            }
        }
        best[0]++;
        best[1]++;
        return best;
    }

    private int calculateValue(int x, int y, int size) {
        int ret = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                ret += grid[i][j];
            }
        }
        return ret;
    }
}
