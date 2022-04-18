package han.groepf.topdownshooter.projectiles.bullets;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import han.groepf.topdownshooter.projectiles.Projectile;

public class ExplodingBullet extends Projectile {

    public ExplodingBullet(Coordinate2D initialLocation) {
        super("Sprites/explodingbullet.png", initialLocation, new Size(16, 16));
    }
}
