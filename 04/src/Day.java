public class Day {
    private String date;
    private int[] hour;

    public Day(String date) {
        this.date = date;
        hour = new int[60];
        for(int i = 0; i < 60; i++) {
            hour[i] = 2;
        }
    }

    public void addSleep(int minute) {
        hour[minute] = 1;
    }

    public void addAwake(int minute) {
        hour[minute] = 0;
    }

    public void Complete() {
        int sign = 0;
        for(int i = 0; i < 60; i++) {
            if(hour[i] == 2) {
                hour[i] = sign;
            } else {
                sign = hour[i];
            }
        }
    }

    public String getDate() {
        return date;
    }

    public int[] getHour() {
        return hour;
    }
}
