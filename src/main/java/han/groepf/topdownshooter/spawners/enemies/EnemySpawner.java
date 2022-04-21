package han.groepf.topdownshooter.spawners.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.enemies.Car;
import han.groepf.topdownshooter.entities.enemies.Dog;
import han.groepf.topdownshooter.entities.enemies.Enemy;
import han.groepf.topdownshooter.entities.enemies.Zombie;
import han.groepf.topdownshooter.scenes.GameScene;

import java.util.Random;

/**
 * Spawns enemies
 */
public class EnemySpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    private final GameScene game;
    private final World world;

    /**
     * Creates an EnemySpawner that spawns a random enemy on an interval of 100ms
     *
     * @param sceneWidth  The width of the current scene
     * @param sceneHeight The height of the current scene
     */
    public EnemySpawner(double sceneWidth, double sceneHeight, GameScene game, World world) {
        super(2000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.game = game;
        this.world = world;
    }

    @Override
    protected void spawnEntities() {
        int rand = new Random().nextInt(10);
        Enemy e;
        if (rand < 5) {
            e = new Zombie(new Coordinate2D(sceneWidth * 0.98, randomY()), world);
        } else if (rand < 8) {
            e = new Dog(new Coordinate2D(sceneWidth * 0.98, randomY()), world);
        } else {
            e = new Car(new Coordinate2D(sceneWidth * 0.98, randomY()), world);
        }
        e.setGameScene(game);
        spawn(e);
    }

    /**
     * Generates a random Y coordinate
     * @return
     */
    private double randomY() {
        return new Random().nextInt((int) sceneHeight);
    }
}
