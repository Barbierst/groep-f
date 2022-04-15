package han.groepf.topdownshooter.spawners.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import han.groepf.topdownshooter.entities.enemies.Car;
import han.groepf.topdownshooter.entities.enemies.Dog;
import han.groepf.topdownshooter.entities.enemies.Zombie;

import java.util.Random;

public class EnemySpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;

    /**
     * Creates an EnemySpawner that spawns a random enemy on an interval of 100ms
     * @param sceneWidth The width of the current scene
     * @param sceneHeight The height of the current scene
     */
    public EnemySpawner(double sceneWidth, double sceneHeight) {
        super(2000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        int  rand = new Random().nextInt(10);

        if (rand < 5) {
            spawn(new Zombie(new Coordinate2D(sceneWidth * 0.98, randomY())));
        } else if (rand < 8) {
            spawn(new Dog(new Coordinate2D(sceneWidth * 0.98, randomY())));
        } else {
            spawn(new Car(new Coordinate2D(sceneWidth * 0.98, randomY())));
        }
    }

    private double randomY() {
        return new Random().nextInt((int) sceneHeight);
    }
}
