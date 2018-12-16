package board.minions;

import board.boardElements.IBoardElement;

public class Goblin implements IMinion, IBoardElement {
    private int health;

    public Goblin() {
        health = 200;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean takeDamage() {
        health -= 3;
        return health <= 0;
    }

    @Override
    public boolean blocksMove() {
        return true;
    }
}
