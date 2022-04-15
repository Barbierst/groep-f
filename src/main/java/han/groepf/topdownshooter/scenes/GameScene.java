package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.barricade.Barricade;
import han.groepf.topdownshooter.entities.player.Player;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    private World world;

    /**
     * The basic game scene in which a controllable player entity, a barricade have been added
     * @param world
     */
    public GameScene(World world) {
        this.world = world;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        addEntity(new Player(new Coordinate2D(getWidth() * 0.1,getHeight() * 0.1)));
        addEntity(new Barricade(getWidth() * 0.15));
    }

    @Override
    public void setupEntitySpawners() {

    }
}
