package han.groepf.topdownshooter.game.userinterface.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.game.state.GameState;
import javafx.scene.input.MouseButton;

/**
 * Represents a start button on the screen
 */
public class StartGameButton extends SceneSwitchButton {

    private final GameState state;

    /**
     * Creates a button which when clicked starts the game
     * @param initialLocation Initial location
     * @param world engine
     * @param Text button text
     * @param targetScene next scene
     * @param state game state
     */
    public StartGameButton(Coordinate2D initialLocation, World world, String Text, int targetScene, GameState state) {
        super(initialLocation, world, Text, targetScene);
        this.state = state;
    }

    /**
     * When this button is clicked, the game's state is reset and the game is started
     *
     * @param mouseButton  The clicked mouse button
     * @param coordinate2D /
     */
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        super.onMouseButtonPressed(mouseButton, coordinate2D);
        super.world.setupScenes();
        state.resetState();
    }
}
