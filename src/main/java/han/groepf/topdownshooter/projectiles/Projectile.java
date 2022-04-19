package han.groepf.topdownshooter.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import han.groepf.topdownshooter.entities.enemies.Enemy;

/**
 * Base class used to create projectiles on the screen
 */
public abstract class Projectile extends DynamicSpriteEntity implements Collider, Collided {
    protected int damage = 1;

    /**
     * Projectile
     * @param resource Projectile's sprite
     * @param initialLocation Initial location on screen
     * @param size sprite size
     */
    protected Projectile(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

    /**
     * Function which executes upon colliding with another Collider
     *
     * @param collider Target it collided with
     */
    @Override
    public void onCollision(Collider collider) {
        if (!(collider instanceof Enemy)) {
            return;
        }

        Enemy target = (Enemy) collider;
        target.applyDamage(damage);
        remove();
    }
}
