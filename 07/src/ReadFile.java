import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ReadFile {
    @SuppressWarnings("Duplicates")
    static List<Step> getSteps() {
        List<Step> ret = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            for (String s : br.lines().collect(Collectors.toList())) {
                char c1 = s.charAt(5);
                char c2 = s.charAt(36);
                Step before = null;
                Step after = null;
                if(ret.stream().noneMatch(r -> r.getName() == c1)) {
                    ret.add(new Step(c1));
                    before = ret.get(ret.size()-1);
                } else {
                    for(Step step : ret) {
                        if(step.getName() == c1) {
                            before = step;
                        }
                    }
                }
                if(ret.stream().noneMatch(r -> r.getName() == c2)) {
                    ret.add(new Step(c2));
                    after = ret.get(ret.size()-1);
                } else {
                    for(Step step : ret) {
                        if(step.getName() == c2) {
                            after = step;
                        }
                    }
                }
                assert before != null;
                assert after != null;
                after.addStepBefore(before);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
