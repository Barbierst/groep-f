package han.groepf.topdownshooter.spawners.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import han.groepf.topdownshooter.entities.enemies.Car;
import han.groepf.topdownshooter.entities.enemies.Dog;
import han.groepf.topdownshooter.entities.enemies.Enemy;
import han.groepf.topdownshooter.entities.enemies.Zombie;
import han.groepf.topdownshooter.scenes.GameScene;

import java.util.Random;

public class EnemySpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    private final GameScene game;
    private final double additionalSpeed;
    private final int additionalHealth;

    public EnemySpawner(double sceneWidth, double sceneHeight, GameScene game, double additionalSpeed, int additionalHealth) {
        super(2000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.game = game;
        this.additionalSpeed = additionalSpeed;
        this.additionalHealth = additionalHealth;
    }

    @Override
    protected void spawnEntities() {
        int rand = new Random().nextInt(10);
        Enemy e;
        if (rand < 5) {
            e = new Zombie(new Coordinate2D(sceneWidth * 0.98, randomY()), additionalHealth, additionalSpeed);
        } else if (rand < 8) {
            e = new Dog(new Coordinate2D(sceneWidth * 0.98, randomY()), additionalHealth, additionalSpeed);
        } else {
            e = new Car(new Coordinate2D(sceneWidth * 0.98, randomY()), additionalHealth, additionalSpeed);
        }
        e.setGameScene(game);
        spawn(e);
    }

    private double randomY() {
        return new Random().nextInt((int) sceneHeight);
    }



}
