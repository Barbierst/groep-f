package han.groepf.topdownshooter.projectiles.bullets;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import han.groepf.topdownshooter.entities.enemies.Enemy;
import han.groepf.topdownshooter.projectiles.Projectile;

public class Bullet extends Projectile {

    public Bullet(Coordinate2D initialLocation) {
        super("Sprites/bullet.png", initialLocation, new Size(16,16));
    }

}
