public class Main {
    static final int puzzleInput = 825401;

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        System.out.println("1: " + algorithm.scoreAfterNRecipes());
        System.out.println("2: " + algorithm.recipesCount());
    }
}
