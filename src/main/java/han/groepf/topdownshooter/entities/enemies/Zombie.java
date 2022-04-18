package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;

public class Zombie extends Enemy {
    /**
     * An enemy with low speed
     * @param initialPosition The initial position for the Zombie
     * @param additionalHealth
     * @param additionalSpeed
     */
    public Zombie(Coordinate2D initialPosition, int additionalHealth, double additionalSpeed) {
        super("sprites/zombie.png", initialPosition, 1 + additionalSpeed, 1, 1 + additionalHealth);
    }
}
