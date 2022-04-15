package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import han.groepf.topdownshooter.World;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    private World world;

    public GameScene(World world) {
        this.world = world;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupEntitySpawners() {

    }
}
