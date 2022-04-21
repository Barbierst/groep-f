package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.game.userinterface.buttons.ExitButton;
import han.groepf.topdownshooter.game.userinterface.buttons.SceneSwitchButton;
import han.groepf.topdownshooter.game.userinterface.text.BasicText;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Represents the end menu
 */
public class EndScene extends StaticScene {

    private final World world;


    /**
     * Scene in which the player can restart the game
     *
     * @param world Instance of the current game
     */
    public EndScene(World world) {
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
        double width = getWidth();

        addEntity(new BasicText(new Coordinate2D(width * 0.4, width * 0.6), "Score: " + world.getState().getPlayerScore()));
        addEntity(new BasicText(new Coordinate2D(width * 0.4, width * 0.65), "Zombies killed: " + world.getState().getSlainEnemies().size()));
        addEntity(new SceneSwitchButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.5), this.world, "Game menu", 0));
        addEntity(new ExitButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.55), this.world));
    }
}
