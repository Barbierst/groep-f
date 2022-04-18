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

    /**
     * Checks whether the player has killed enough enemies
     * @return
     */
    public boolean hasFinishedLevel() {
        boolean res =  killedEnemies >= enemiesToKill;
        return res;
    }

    /**
     * Returns the amount of enemies to kill
     * @return Enemies to kill
     */
    public int getEnemiesToKill() {
        return enemiesToKill;
    }

    /**
     * Increments the killed enemy count
     */
    public void incrementKilledEnemyCount() {
        killedEnemies += 1;
    }

    /**
     * Returns the amount of killed enemies
     * @return Amount of killed enemies
     */
    public int getKilledEnemies() {
        return killedEnemies;
    }
}
