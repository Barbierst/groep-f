package han.groepf.topdownshooter.projectiles.bullets;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import han.groepf.topdownshooter.projectiles.Projectile;

/**
 * Represents a bullet which can explode
 */
public class ExplodingBullet extends Projectile {

    /**
     * Used for displaying an exploding bullet sprite on the scene
     *
     * @param initialLocation Initial location to spawn the bullet
     */
    public ExplodingBullet(Coordinate2D initialLocation) {
        super("Sprites/explodingbullet.png", initialLocation, new Size(16, 16));
    }
}
