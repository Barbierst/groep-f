package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.game.userinterface.buttons.DifficultyButton;
import han.groepf.topdownshooter.game.userinterface.buttons.PowerUpToggle;
import han.groepf.topdownshooter.game.userinterface.buttons.SceneSwitchButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Represents the settings screen
 */
public class SettingsScene extends StaticScene {

    private final World world;

    public SettingsScene(World world) {
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
        addEntity(new SceneSwitchButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.6), this.world, "Menu", 0));
        addEntity(new DifficultyButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.65), this.world));
        addEntity(new PowerUpToggle(new Coordinate2D(getWidth() / 2, getHeight() * 0.70), this.world));
    }
}