import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Step> steps = ReadFile.getSteps();
        List<Step> ordered = new ArrayList<>();
        Step first;

        while (steps.size() > 0) {
            List<Step> temp = steps.stream().filter(s -> s.getBefore().size() == 0).collect(Collectors.toList());
            if (temp.size() > 1) {
                temp = temp.stream().sorted(Comparator.comparing(Step::getName)).collect(Collectors.toList());
            }
            first = temp.get(0);

            for (Step s : steps) {
                s.getBefore().remove(first);
            }
            steps.remove(first);
            ordered.add(first);
        }

        System.out.print("1: ");
        for (Step s : ordered) {
            System.out.print(s.getName());
        }
        System.out.println();

        steps = ReadFile.getSteps();
        ordered = new ArrayList<>();
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            workers.add(new Worker());
        }

        int timer = 0;
        while (steps.size() > 0 || !workers.stream().allMatch(w-> w.getTimeToFinish() <= 0)) {
            List<Worker> freeWorkers = workers.stream().filter(w -> w.getTimeToFinish() <= 0).collect(Collectors.toList());
            for (Worker fw : freeWorkers) {
                if (fw.getActualStep() != null) {
                    for (Step s : steps) {
                        s.getBefore().remove(fw.getActualStep());
                    }
                    ordered.add(fw.getActualStep());
                    fw.setActualStep(null);
                }
            }
            List<Step> temp = steps.stream().filter(s -> s.getBefore().size() == 0).collect(Collectors.toList());
            temp = temp.stream().sorted(Comparator.comparing(Step::getName)).collect(Collectors.toList());
            if (freeWorkers.size() > temp.size()) {
                for (int i = 0; i < temp.size(); i++) {
                    freeWorkers.get(i).setActualStep(temp.get(i));
                    steps.remove(temp.get(i));
                }
            } else {
                for (int i = 0; i < freeWorkers.size(); i++) {
                    freeWorkers.get(i).setActualStep(temp.get(i));
                    steps.remove(temp.get(i));
                }
            }
            workers.forEach(Worker::updateTime);
            timer++;
        }
        System.out.println("2: " + timer);
    }
}
