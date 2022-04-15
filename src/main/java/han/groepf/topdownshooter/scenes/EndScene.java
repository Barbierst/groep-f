package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.scenes.StaticScene;
import han.groepf.topdownshooter.World;

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

    }
}
