public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("1: " + game.getHighScore());
        game = new Game();
        System.out.println("2: " + game.getHighScore_WhenMarblesTimes100());
    }
}
