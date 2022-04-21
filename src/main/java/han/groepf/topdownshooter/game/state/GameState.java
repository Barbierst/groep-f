package han.groepf.topdownshooter.game.state;

import han.groepf.topdownshooter.entities.enemies.Enemy;

import java.util.ArrayList;

/**
 * Contains functions to retrieve and store game state
 */
public class GameState {

    private int playerScore = 0;
    private ArrayList<Enemy> slainEnemies = new ArrayList<>();

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
        return slainEnemies.size();
    }

    /**
     * Returns the player's score
     *
     * @return Score
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * Return the slain enemies
     *
     * @return SlainEnemies
     */
    public ArrayList<Enemy> getSlainEnemies() {
        return slainEnemies;
    }

    /**
     * Resets the player's score and enemy killcount
     */
    public void resetState() {
        slainEnemies.clear();
        playerScore = 0;
    }
}
