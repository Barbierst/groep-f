package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;

public class Dog extends Enemy {

     /**
     * An enemy with mediocre speed
      * @param initialPosition The start position for the dog
      * @param additionalHealth
      * @param additionalSpeed
      */
    public Dog(Coordinate2D initialPosition, int additionalHealth, double additionalSpeed) {
        super("sprites/dog.png", initialPosition, 2+ additionalSpeed, 2, 1 + additionalHealth);
    }
}
