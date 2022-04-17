package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.buttons.DifficultyButton;
import han.groepf.topdownshooter.entities.buttons.MenuButton;
import han.groepf.topdownshooter.entities.buttons.PowerUpToggle;
import han.groepf.topdownshooter.entities.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SettingsScene extends StaticScene {

    private final World world;

    public SettingsScene(World world){
       this.world = world;
    }

    @Override
    public void setupScene() {

    }

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
        addEntity(new MenuButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.6), this.world));
        addEntity(new DifficultyButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.65), this.world));
        addEntity(new PowerUpToggle(new Coordinate2D(getWidth() / 2, getHeight() * 0.70), this.world));
    }
}