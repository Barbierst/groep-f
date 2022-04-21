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
     * Return the amount of enemies slain of a given type
     * @param className The type of enemy to check for
     * @return The amount of enemies slain of given type
     */
    public int getSlainTypeCount(Class className) {
        int count = 0;

        for (Enemy e: slainEnemies) {
            if (className.isInstance(e)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Resets the player's score and enemy killcount
     */
    public void resetState() {
        slainEnemies.clear();
        playerScore = 0;
    }
}
