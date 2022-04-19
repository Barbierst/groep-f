package han.groepf.topdownshooter.game.userinterface.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.game.userinterface.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

/**
 * Represents a button on the screen
 */
public class SceneSwitchButton extends Button {
    private final int targetScene;

    public SceneSwitchButton(Coordinate2D initialLocation, World world, String Text, int targetScene) {
        super(initialLocation, Text, world, Color.GREEN, Color.GREENYELLOW);
        this.targetScene = targetScene;
    }

    /**
     * When this button is clicked, the active scene is set to the targetScene
     *
     * @param mouseButton  The clicked mouse button
     * @param coordinate2D /
     */
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        world.setActiveScene(targetScene);
    }
}
