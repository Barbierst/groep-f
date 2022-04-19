package han.groepf.topdownshooter.projectiles.bullets;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import han.groepf.topdownshooter.projectiles.Projectile;

/**
 * Represents a bullet which lights the target on fire
 */
public class FireBullet extends Projectile {

    /**
     * Used for displaying a fire bullet sprite on the scene
     *
     * @param initialLocation Initial location to spawn the bullet
     */
    public FireBullet(Coordinate2D initialLocation) {
        super("Sprites/firebullet.png", initialLocation, new Size(16, 16));
    }
}
