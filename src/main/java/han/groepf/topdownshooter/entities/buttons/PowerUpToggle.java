package han.groepf.topdownshooter.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class PowerUpToggle extends Button {

    private final World world;

    public PowerUpToggle(Coordinate2D initialLocation, World world) {
        super(initialLocation, "Power ups: Off" , world, Color.GREEN, Color.GREENYELLOW);
        this.world = world;

        String text = "Power ups: ";
        boolean powerUpToggleValue = this.world
                .getSettings()
                .isPowerUpsOn();

        text += powerUpToggleValue ? "On" : "Off";
        this.setText(text);
    }

    /**
     * When this button is clicked, the active scene is set to the GameScene (scene 1)
     *
     * @param mouseButton  The clicked mouse button
     * @param coordinate2D /
     */
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        String text = "Power ups: ";
        boolean powerUpToggleValue = this.world
                .getSettings()
                .togglePowerUp();

        text += powerUpToggleValue ? "On" : "Off";
        this.setText(text);
    }
}
