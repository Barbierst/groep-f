package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.game.userinterface.buttons.ExitButton;
import han.groepf.topdownshooter.game.userinterface.buttons.SceneSwitchButton;
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
        Font font = Font.font("Roboto", FontWeight.BOLD, 30);

        TextEntity score = new TextEntity(new Coordinate2D(getWidth() * 0.4, getHeight() * 0.6));
        TextEntity zombiesKilled = new TextEntity(new Coordinate2D(getWidth() * 0.4, getHeight() * 0.65));
        TextEntity barricadeHealthLost = new TextEntity(new Coordinate2D(getWidth() * 0.4, getHeight() * 0.7));

        score.setText("Score: " + world.getState().getPlayerScore());
        zombiesKilled.setText("Zombies killed: " + world.getState().getKilledEnemyCount());
        barricadeHealthLost.setText("Barricade health lost: 0");

        score.setFont(font);
        zombiesKilled.setFont(font);
        barricadeHealthLost.setFont(font);

        addEntity(score);
        addEntity(zombiesKilled);
        addEntity(barricadeHealthLost);
        addEntity(new SceneSwitchButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.5), this.world, "Game menu", 0));
        addEntity(new ExitButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.55), this.world));
    }
}
