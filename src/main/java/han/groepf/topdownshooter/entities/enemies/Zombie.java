package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;

public class Zombie extends Enemy {
    /**
     * An enemy with low speed
     * @param initialPosition The initial position for the Zombie
     */
    public Zombie(Coordinate2D initialPosition) {
        super("sprites/zombie.png", initialPosition, 1, 1, 1);
    }
}
