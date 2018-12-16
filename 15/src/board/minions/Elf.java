package board.minions;

public class Elf implements IMinion {
    private int health;

    public Elf() {
        health = 200;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public boolean takeDamage() {
        health -= 3;
        return health <= 0;
    }
}
