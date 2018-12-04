import java.util.ArrayList;
import java.util.List;

public class Guard {
    private List<Day> days;
    private int id;

    public Guard(int id) {
        this.id = id;
        this.days = new ArrayList<>();
    }

    public void addDay(String name) {
        days.add(new Day(name));
    }

    public Day getDay() {
        return days.get(days.size()-1);
    }

    public List<Day> getDays() {
        return days;
    }

    public int timeAsleep() {
        int ret = 0;
        for(Day d : days) {
            for(Integer i : d.getHour()) {
                ret += i;
            }
        }
        return ret;
    }

    public int minuteMostAsleep() {
        int[] allHours = new int[60];
        for(int i = 0; i < 60; i++) {
            allHours[i] = 0;
        }
        for (Day d : days) {
            for(int i = 0; i < 60; i++) {
                allHours[i] += d.getHour()[i];
            }
        }
        int max = 0;
        for(int i = 1; i < 60; i++) {
            if(allHours[i] > allHours[max]) {
                max = i;
            }
        }
        return max;
    }

    public int valueOfMinuteMostAsleep() {
        int[] allHours = new int[60];
        for(int i = 0; i < 60; i++) {
            allHours[i] = 0;
        }
        for (Day d : days) {
            for(int i = 0; i < 60; i++) {
                allHours[i] += d.getHour()[i];
            }
        }
        int max = 0;
        for(int i = 1; i < 60; i++) {
            if(allHours[i] > allHours[max]) {
                max = i;
            }
        }
        return allHours[max];
    }

    public void completeDay() {
        days.get(days.size()-1).Complete();
    }

    public int getId() {

        return id;
    }
}
