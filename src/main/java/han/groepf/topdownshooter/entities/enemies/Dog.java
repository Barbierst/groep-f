package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;

/**
 * Represents a dog enemy
 */
public class Dog extends Enemy {

    /**
     * An enemy with mediocre speed
     *
     * @param initialPosition The start position for the dog
     */
    public Dog(Coordinate2D initialPosition, World world) {
        super("sprites/dog.png", initialPosition, world, 2, 2, 1);
    }
}
