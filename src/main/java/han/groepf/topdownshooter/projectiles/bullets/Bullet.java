package han.groepf.topdownshooter.projectiles.bullets;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import han.groepf.topdownshooter.projectiles.Projectile;

/**
 * Represents a normal bullet
 */
public class Bullet extends Projectile {

    /**
     * Used for displaying a bullet sprite on the scene
     *
     * @param initialLocation Initial location to spawn the bullet
     */
    public Bullet(Coordinate2D initialLocation) {
        super("Sprites/bullet.png", initialLocation, new Size(16, 16));
    }
}
