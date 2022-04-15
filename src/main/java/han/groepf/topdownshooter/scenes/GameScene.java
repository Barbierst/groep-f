package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.barricade.Barricade;
import han.groepf.topdownshooter.entities.enemies.Car;
import han.groepf.topdownshooter.entities.enemies.Dog;
import han.groepf.topdownshooter.entities.enemies.Zombie;
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

        // These are to be spawned in a spawner
        addEntity(new Zombie(new Coordinate2D(getWidth() * 0.9,getHeight() * 0.3)));
        addEntity(new Dog(new Coordinate2D(getWidth() * 0.9,getHeight() * 0.5)));
        addEntity(new Car(new Coordinate2D(getWidth() * 0.9,getHeight() * 0.7)));
    }

    @Override
    public void setupEntitySpawners() {

    }
}
