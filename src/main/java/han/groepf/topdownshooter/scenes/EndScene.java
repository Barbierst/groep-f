package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.buttons.ExitButton;
import han.groepf.topdownshooter.entities.buttons.MenuButton;

public class EndScene extends StaticScene {

    private final World world;


    /**
     * Scene in which the player can restart the game
     * @param world Instance of the current game
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
