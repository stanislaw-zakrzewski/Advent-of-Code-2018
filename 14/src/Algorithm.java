import java.util.Stack;

class Algorithm {
    private Stack<Integer> recipes;
    private int elf1;
    private int elf2;

    Algorithm() {
        recipes = new Stack<>();
        recipes.push(3);
        recipes.push(7);
        elf1 = 0;
        elf2 = 1;
    }

    String scoreAfterNRecipes() {
        while(recipes.size() < Main.puzzleInput + 10) {
            makeRecipe();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            stringBuilder.append(recipes.get(Main.puzzleInput + i));
        }
        return stringBuilder.toString();
    }

    int recipesCount() {
        String s = Integer.toString(Main.puzzleInput);
        int length =s.length();
        int recipesCount = 0;
        while (true) {
            recipesCount++;
            while (recipes.size() < length + recipesCount) {
                makeRecipe();
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < length; i++) {
                stringBuilder.append(recipes.get(recipesCount + i));
            }
            if(stringBuilder.toString().equals(s)) {
                break;
            }
        }
        return recipesCount;
    }

    private void makeRecipe() {
        int pom = recipes.get(elf1) + recipes.get(elf2);
        if (pom > 9) recipes.push(1);
        recipes.push(pom % 10);
        elf1 = (elf1 + recipes.get(elf1) + 1) % recipes.size();
        elf2 = (elf2 + recipes.get(elf2) + 1) % recipes.size();
    }
}
