package han.groepf.topdownshooter.game.userinterface.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.game.userinterface.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class ExitButton extends Button {

    public ExitButton(Coordinate2D initialLocation, World world) {
        super(initialLocation, "Exit game", world, Color.BLACK, Color.DARKGRAY);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        world.quit();
    }
}
