package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;

public class Dog extends Enemy {

    /**
     * An enemy with mediocre speed
     * @param initialPosition
     */
    public Dog(Coordinate2D initialPosition) {
        super("sprites/dog.png", initialPosition, 2, 2, 1);
    }
}
