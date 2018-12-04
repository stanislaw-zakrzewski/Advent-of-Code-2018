import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> info = ReadFile.getInfo();
        Collections.sort(info);

        List<Guard> guards = new ArrayList<>();
        Guard actualGuard = null;
        boolean awake = true;

        for(String s : info) {
            if(s.substring(19, 20).equals("G")) {
                if(actualGuard!=null) actualGuard.completeDay();
                int id = Integer.parseInt(s.substring(26, s.length()-13));
                Optional<Guard> theOne = guards.stream().filter(guard -> guard.getId() == id).findFirst();
                if(theOne.isPresent()) {
                    actualGuard = theOne.get();
                    actualGuard.addDay(s.substring(1,17));
                } else {
                    actualGuard = new Guard(id);
                    guards.add(actualGuard);
                    actualGuard.addDay(s.substring(1,17));
                }
                actualGuard.getDay().addAwake(0);
                awake = true;
            } else {
                if(awake) {
                    actualGuard.getDay().addSleep(Integer.parseInt(s.substring(15,17)));
                    awake = false;
                } else {
                    actualGuard.getDay().addAwake(Integer.parseInt(s.substring(15,17)));
                    awake = true;
                }
            }
        }

        Guard sleeper = guards.get(0);
        for(Guard g : guards) {
            if(g.timeAsleep() > sleeper.timeAsleep()) {
                sleeper = g;
            }
        }
        System.out.println("1:" + sleeper.getId() * sleeper.minuteMostAsleep());

        for(Guard g : guards) {
            if(g.valueOfMinuteMostAsleep() > sleeper.valueOfMinuteMostAsleep()) {
                sleeper = g;
            }
        }
        System.out.println("2:" + sleeper.getId() * sleeper.minuteMostAsleep());
    }
}
