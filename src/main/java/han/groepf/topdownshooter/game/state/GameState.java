package han.groepf.topdownshooter.game.state;

public class GameState {

    private int killedEnemyCount = 0;
    private int playerScore = 0;

    /**
     * Increments the amount of killed enemies by 1
     */
    public void incrementKilledEnemyCount() {
        killedEnemyCount++;
    }

    /**
     * Increments the player's score by the amount given
     *
     * @param addedScore Score to add
     */
    public void incrementPlayerScore(int addedScore) {
        playerScore += addedScore;
    }

    /**
     * Returns the amount of enemies killed
     *
     * @return Amount of enemies killed
     */
    public int getKilledEnemyCount() {
        return killedEnemyCount;
    }

    /**
     * Returns the player's score
     *
     * @return Score
     */
    public int getPlayerScore() {
        return playerScore;
    }

    public void resetState() {
        killedEnemyCount = 0;
        playerScore = 0;
    }
}
