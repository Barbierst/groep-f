package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;

/**
 * Represents a car enemy
 */
public class Car extends Enemy {

    /**
     * An enemy with high speed
     *
     * @param initialPosition The initial position for the Car
     */
    public Car(Coordinate2D initialPosition) {
        super("sprites/car.png", initialPosition, 3, 2, 2);
    }
}
