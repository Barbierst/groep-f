package han.groepf.topdownshooter.projectiles.bullets;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import han.groepf.topdownshooter.projectiles.Projectile;

public class FireBullet extends Projectile {

    public FireBullet(Coordinate2D initialLocation) {
        super("Sprites/firebullet.png", initialLocation, new Size(16, 16));
    }
}
