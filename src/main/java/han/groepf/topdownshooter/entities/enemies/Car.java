package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;

/**
 * Represents a car enemy
 */
public class Car extends Enemy {

    /**
     * An enemy with high speed
     *
     * @param initialPosition The initial position for the Car
     */
    public Car(Coordinate2D initialPosition, World world) {
        super("sprites/car.png", initialPosition, world, 3, 2, 2);
    }
}
