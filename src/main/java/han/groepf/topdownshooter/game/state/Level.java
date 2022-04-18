package han.groepf.topdownshooter.game.state;

import han.groepf.topdownshooter.game.settings.Difficulty;

public class Level {

    private final Difficulty difficulty;
    private final int enemiesToKill;
    private int killedEnemies = 0;
    public final int levelNumber;
    private final GameState gameState;

    public Level(int levelNumber, Difficulty difficulty, GameState gameState) {
        this.difficulty = difficulty;
        this.levelNumber = levelNumber;
        this.gameState = gameState;
        enemiesToKill = ((levelNumber + 1) * 3) + (difficulty.getIndex() * 5);
    }

    public boolean hasFinishedLevel() {
        boolean res =  killedEnemies >= enemiesToKill;
        return res;
    }

    public int getEnemiesToKill() {
        return enemiesToKill;
    }

    public void incrementKilledEnemyCount() {
        killedEnemies += 1;
    }

    public int getKilledEnemies() {
        return killedEnemies;
    }
}
