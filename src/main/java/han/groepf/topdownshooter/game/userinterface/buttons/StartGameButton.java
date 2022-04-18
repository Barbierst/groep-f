package han.groepf.topdownshooter.game.userinterface.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.game.state.GameState;
import javafx.scene.input.MouseButton;

public class StartGameButton extends SceneSwitchButton{

    private final GameState state;

    public StartGameButton(Coordinate2D initialLocation, World world, String Text, int targetScene, GameState state) {
        super(initialLocation, world, Text, targetScene);
        this.state = state;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        super.onMouseButtonPressed(mouseButton, coordinate2D);
        super.world.setupScenes();
        state.resetState();
    }
}
