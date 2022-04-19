package han.groepf.topdownshooter.game.userinterface.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.game.userinterface.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

/**
 * Represents a toggle button on screen
 */
public class PowerUpToggle extends Button {

    private final World world;

    public PowerUpToggle(Coordinate2D initialLocation, World world) {
        super(initialLocation, "Power ups: Off", world, Color.GREEN, Color.GREENYELLOW);
        this.world = world;

        String text = "Power ups: ";
        boolean powerUpToggleValue = this.world
                .getSettings()
                .isPowerUpsOn();

        text += powerUpToggleValue ? "On" : "Off";
        this.setText(text);
    }

    /**
     * When this button is clicked, powerups are toggled on or off
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
