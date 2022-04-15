package han.groepf.topdownshooter.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class MenuButton extends Button{

    public MenuButton(Coordinate2D initialLocation, World world) {
        super(initialLocation, "Game menu", world, Color.GREEN, Color.GREENYELLOW);
    }

    /**
     * When this button is clicked, the active scene is set to the GameScene (scene 1)
     * @param mouseButton The clicked mouse button
     * @param coordinate2D /
     */
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        world.setActiveScene(0);
    }
}
