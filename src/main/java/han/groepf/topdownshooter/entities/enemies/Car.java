package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;

public class Car extends Enemy {

    /**
     * An enemy with high speed
     * @param initialPosition The initial position for the Car
     * @param additionalHealth
     * @param additionalSpeed
     */
    public Car(Coordinate2D initialPosition, int additionalHealth, double additionalSpeed) {
        super("sprites/car.png", initialPosition, 3+ additionalSpeed, 2, 2 + additionalHealth);
    }
}
