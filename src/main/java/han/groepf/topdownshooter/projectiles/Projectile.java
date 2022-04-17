package han.groepf.topdownshooter.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import han.groepf.topdownshooter.entities.enemies.Enemy;

public abstract class Projectile extends DynamicSpriteEntity implements Collider, Collided {
    protected int damage = 1;

    protected Projectile(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

    @Override
    public void onCollision(Collider collider) {
        if(!(collider instanceof Enemy)){
            return;
        }

        Enemy target = (Enemy)collider;
        target.applyDamage(damage);
        remove();
    }
}
