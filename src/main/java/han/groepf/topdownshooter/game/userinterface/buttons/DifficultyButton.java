package han.groepf.topdownshooter.game.userinterface.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.game.settings.Difficulty;
import han.groepf.topdownshooter.game.userinterface.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

import java.util.Arrays;

/**
 * Contains functions for managing the difficulty button's behaviour
 */
public class DifficultyButton extends Button {
    private final Difficulty[] difficulties = new Difficulty[]{
            Difficulty.EASY,
            Difficulty.NORMAL,
            Difficulty.HARD
    };
    private int index = 0;

    public DifficultyButton(Coordinate2D initialLocation, World world) {
        super(initialLocation, "Difficulty: easy", world, Color.GREEN, Color.GREENYELLOW);

        String currentDifficulty = this.world
                .getSettings()
                .getDifficulty()
                .getName();
        this.setText("Difficulty: " + currentDifficulty);
    }

    /**
     * When this button is clicked, the game's difficulty changes
     *
     * @param mouseButton  The clicked mouse button
     * @param coordinate2D /
     */
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        int choices = difficulties.length;
        index += 1;
        Difficulty newDifficullty = Arrays.stream(difficulties)
                .filter(d -> d.getIndex() == index % choices)
                .findFirst()
                .get();

        if (newDifficullty == null) {
            return;
        }

        this.setText("Difficulty: " + newDifficullty.getName());
        world
                .getSettings()
                .setDifficulty(newDifficullty);
    }
}
