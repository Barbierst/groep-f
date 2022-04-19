package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.game.userinterface.buttons.SceneSwitchButton;
import han.groepf.topdownshooter.game.userinterface.buttons.StartGameButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Represents the menu screen
 */
public class MenuScene extends StaticScene {

    private final World world;

    /**
     * Scene in which the user can select start a game, go to the settings menu or quit the game
     *
     * @param world Instance of the current game
     */
    public MenuScene(World world) {
        this.world = world;
    }

    @Override
    public void setupScene() {

    }

    /**
     * Adds menu items to the scene
     */
    @Override
    public void setupEntities() {
        TextEntity title = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Day-A"
        );
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFill(Color.DARKBLUE);
        title.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        addEntity(title);
        addEntity(new StartGameButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.6), world, "Start game", 10, world.getState()));
        addEntity(new SceneSwitchButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.65), world, "Settings", 3));
    }
}