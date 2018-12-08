import java.util.ArrayList;
import java.util.List;

public class Step {
    private char name;
    private List<Step> before;

    public Step(char name) {
        this.name = name;
        before = new ArrayList<>();
    }

    void addStepBefore(Step stepBefore) {
        before.add(stepBefore);
    }

    List<Step> getBefore() {
        return before;
    }

    char getName() {
        return name;
    }
}
