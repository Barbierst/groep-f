package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.World;

/**
 * Represents a zombie enemy
 */
public class Zombie extends Enemy {
    /**
     * An enemy with low speed
     *
     * @param initialPosition The initial position for the Zombie
     */
    public Zombie(Coordinate2D initialPosition, World world) {
        super("sprites/zombie.png", initialPosition, world,1, 1, 1);
    }
}
