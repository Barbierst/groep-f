package han.groepf.topdownshooter.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class StartButton extends Button{

    public StartButton(Coordinate2D initialLocation, String text, World world, Color color, Color hoverColor) {
        super(initialLocation, text, world, color, hoverColor);
    }

    /**
     * When this button is clicked, the active scene is set to the GameScene (scene 1)
     * @param mouseButton
     * @param coordinate2D
     */
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        world.setActiveScene(1);
    }
}
