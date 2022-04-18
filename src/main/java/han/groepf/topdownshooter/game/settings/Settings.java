package han.groepf.topdownshooter.game.settings;

/**
 * Contains functions to retrieve and change various game settings
 */
public class Settings {
    private Difficulty difficulty = Difficulty.EASY;
    private boolean powerUpsOn = false;

    /**
     * Set the power up toggle on the value it's currently not
     * @return The new power up toggle value
     */
    public boolean togglePowerUp(){
        powerUpsOn = !powerUpsOn;
        return powerUpsOn;
    }

    /**
     * Set the game difficulty to the difficulty provided
     * @param newDifficulty New difficulty to use
     * @return The new difficulty
     */
    public Difficulty setDifficulty(Difficulty newDifficulty){
        difficulty = newDifficulty;
        return difficulty;
    }

    public boolean isPowerUpsOn(){
        return powerUpsOn;
    }

    public String getDifficultyString(){
        return difficulty.getName();
    }
}
