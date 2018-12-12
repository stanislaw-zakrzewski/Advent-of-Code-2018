import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Tunnel {
    private LinkedList<Boolean> plants;
    private List<SpreadKey> spreadKeys;
    private int shift;

    Tunnel(List<Boolean> plants, List<SpreadKey> spreadKeys) {
        this.plants = new LinkedList<>();
        for (Boolean b : plants) {
            this.plants.addLast(b);
        }
        this.spreadKeys = spreadKeys;
        shift = 0;
        checkListBoundries();
    }

    private void checkListBoundries() {
        checkLast();
        checkFirst();
    }

    private void checkLast() {
        if (plants.getLast()) {
            plants.addLast(false);
            plants.addLast(false);
            plants.addLast(false);
            plants.addLast(false);
            plants.addLast(false);
        } else {
            plants.removeLast();
            checkLast();
        }
    }

    private void checkFirst() {
        if (plants.getFirst()) {
            shift -= 5;
            plants.addFirst(false);
            plants.addFirst(false);
            plants.addFirst(false);
            plants.addFirst(false);
            plants.addFirst(false);
        } else {
            shift++;
            plants.removeFirst();
            checkFirst();
        }
    }

    void goThroughNGenerations(int generation) {
        printPots();
        for (int g = 0; g < generation; g++) {
            List<Boolean> old = new ArrayList<>();
            plants.forEach(p -> old.add(null));
            Collections.copy(old, plants);
            for(int i = 2; i < plants.size()-2; i++) {
                setValue(i, old);
            }
            checkListBoundries();
        }
    }

    private void printPots() {
        for (boolean b : plants) {
            if(b) {
                System.out.print("#");
            } else {
                System.out.print(".");
            }
        }
        System.out.println();
    }

    private void setValue(int i, List<Boolean> old) {
        for(SpreadKey sk : spreadKeys) {
            if(old.get(i-2) == sk.isLl() && old.get(i-1) == sk.isL() && old.get(i) == sk.isC() && old.get(i+1) == sk.isR() && old.get(i+2) == sk.isRr()) {
                plants.set(i, sk.isValue());
            }
        }
    }

    int getSumOfPots() {
        int ret = 0;
        for(int i = 0; i < plants.size(); i++) {
            if(plants.get(i)) {
                ret += i + shift;
            }
        }
        return ret;
    }
}
