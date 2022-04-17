package han.groepf.topdownshooter.game.state;

public class GameState {

    private static int killedEnemyCount = 0;
    private static int playerScore = 0;

    public static void incrementKilledEnemyCount() {
        killedEnemyCount++;
    }

    public static void incrementPlayerScore() {
        playerScore++;
    }

    public static int getKilledEnemyCount() {
        return killedEnemyCount;
    }

    public static int getPlayerScore() {
        return playerScore;
    }

}
