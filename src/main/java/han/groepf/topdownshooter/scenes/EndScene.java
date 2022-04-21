package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.enemies.Car;
import han.groepf.topdownshooter.entities.enemies.Dog;
import han.groepf.topdownshooter.entities.enemies.Zombie;
import han.groepf.topdownshooter.game.state.GameState;
import han.groepf.topdownshooter.game.userinterface.buttons.ExitButton;
import han.groepf.topdownshooter.game.userinterface.buttons.SceneSwitchButton;
import han.groepf.topdownshooter.game.userinterface.text.BasicText;

import java.util.ArrayList;

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
        double height = getHeight();

        addEntity(new SceneSwitchButton(new Coordinate2D(width / 2, height * 0.3), this.world, "Game menu", 0));
        addEntity(new ExitButton(new Coordinate2D(width / 2, height * 0.35), this.world));

        GameState state = world.getState();
        addEntity(new BasicText(new Coordinate2D(width * 0.4, height * 0.4), "Score: " + state.getPlayerScore()));
        addEntity(new BasicText(new Coordinate2D(width * 0.4, height * 0.45), "Zombies killed: " + state.getSlainEnemies().size()));

        addEntity(new BasicText(new Coordinate2D(width * 0.4, height * 0.5), "Zombies: " + state.getSlainTypeCount(Zombie.class)));
        addEntity(new BasicText(new Coordinate2D(width * 0.4, height * 0.55), "Dogs: " + state.getSlainTypeCount(Dog.class)));
        addEntity(new BasicText(new Coordinate2D(width * 0.4, height * 0.6), "Cars: " + state.getSlainTypeCount(Car.class)));
    }
}
