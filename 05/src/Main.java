public class Main {
    public static void main(String[] args) {
        String polymer = Input.getInput();

        polymer = react(polymer);

        System.out.println("1: " + polymer.length());

        polymer = improve(polymer);

        System.out.println("2: " + polymer.length());
    }

    private static String react(String polymer) {
        assert polymer != null;
        int i = 0;
        while (i < polymer.length()-1) {
            if (((int) polymer.charAt(i)) == ((int) polymer.charAt(i + 1)) + 32 || ((int) polymer.charAt(i)) == ((int) polymer.charAt(i + 1)) - 32) {
                String a = polymer.substring(0,i);
                String b = polymer.substring(i+2);
                polymer = a + b;
                i = 0;
            } else {
                i++;
            }
        }
        return polymer;
    }

    private static String improve(String polymer) {
        String improved = polymer;
        int shortest = polymer.length();
        for(int i = 0; i < 26; i++) {
            char upperCase = (char)(i + 65);
            char lowerCase = (char)(upperCase + 32);
            String experimental = polymer;
            experimental = experimental.replaceAll( Character.toString(upperCase), "");
            experimental = experimental.replaceAll( Character.toString(lowerCase), "");
            experimental = react(experimental);
            if(experimental.length() < shortest) {
                shortest = experimental.length();
                improved = experimental;
            }
        }
        return improved;
    }
}
