import java.util.*;

class Tunnel {
    private Set<Integer> plants;
    private Map<String, Boolean> spreadKeys;
    private long brakeSize;

    Tunnel(Set<Integer> plants, Map<String, Boolean> spreadKeys) {
        this.plants = plants;
        this.spreadKeys = spreadKeys;
        brakeSize = 0;
    }

    void goThroughNGenerations(long generation) {
        for (long g = 0; g < generation; g++) {
            Set<Integer> newPlants = new HashSet<>();
            int min = Collections.min(plants);
            int max = Collections.max(plants);
            for (int i = min - 3; i < max + 3; i++) {
                StringBuilder pattern = new StringBuilder();
                for (int j = 0; j < 5; j++) {
                    if (plants.contains(i + j)) {
                        pattern.append("#");
                    } else {
                        pattern.append(".");
                    }
                }
                if (spreadKeys.containsKey(pattern.toString())) {
                    if (spreadKeys.get(pattern.toString())) {
                        newPlants.add(i + 2);
                    }
                }
            }/*
            if(plants.size() == newPlants.size()) {
                boolean breakerPlus = true;
                for (Integer i : newPlants) {
                    if (!plants.contains(i - 1)) {
                        breakerPlus = false;
                        break;
                    }
                }
                if (breakerPlus) {
                    long pom = plants.size();
                    pom *= (50000000000L - g - 1);
                    brakeSize = pom;
                    System.out.println(pom);
                    System.out.println((50000000000L-98)*81);
                    System.out.println(g);
                    break;
                }
            }*/
            plants = newPlants;
        }
    }

    long getSumOfPots() {
        int ret = 0;
        List<Integer> ints = new ArrayList<>(plants);
        for (int i : ints) {
            ret += i;
        }
        return ret + brakeSize;
    }
}
