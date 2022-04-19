package han.groepf.topdownshooter.game.settings;

/**
 * Used for easily displaying varying difficulty settings
 */
public enum Difficulty {
    EASY(0, "Easy"),
    NORMAL(1, "Normal"),
    HARD(2, "Hard");

    private final int index;
    private final String name;

    /**
     * Used for easily displaying varying difficulty settings
     * @param index Unique index used to determine the difficulty, 0 = low
     * @param name Difficulty name
     */
    Difficulty(int index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * Returns the difficulty's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the difficulty's index
     * @return index
     */
    public int getIndex() {
        return index;
    }
}
