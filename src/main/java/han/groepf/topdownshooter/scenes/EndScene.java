package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.buttons.ExitButton;
import han.groepf.topdownshooter.entities.buttons.MenuButton;
import han.groepf.topdownshooter.entities.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndScene extends StaticScene {

    private final World world;


    /**
     * Scene in which the player can restart the game
     * @param world
     */
    public EndScene(World world) {
        this.world = world;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        addEntity(new MenuButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.5), this.world));
        addEntity(new ExitButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.55), this.world));
    }
}
