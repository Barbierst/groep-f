package han.groepf.topdownshooter.game.state;

public class GameState {

    private int killedEnemyCount = 0;
    private int playerScore = 0;

    public void incrementKilledEnemyCount() {
        killedEnemyCount++;
    }

    public void incrementPlayerScore(int addedScore) {
        playerScore += addedScore;
    }

    public int getKilledEnemyCount() {
        return killedEnemyCount;
    }

    public int getPlayerScore() {
        return playerScore;
    }

}
