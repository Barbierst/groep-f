package han.groepf.topdownshooter.game.settings;

public enum Difficulty {
    EASY(0,"Easy"),
    NORMAL(1, "Normal"),
    HARD(2, "Hard");

    private final int index;
    private final String name;

    Difficulty(int index, String name){
        this.index = index;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getIndex(){
        return index;
    }
}
