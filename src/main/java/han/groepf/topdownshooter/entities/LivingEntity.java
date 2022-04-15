package han.groepf.topdownshooter.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import han.groepf.topdownshooter.entities.enemies.Enemy;

public abstract class LivingEntity extends DynamicSpriteEntity implements Collided, Collider {

    private int health;

    protected LivingEntity(String resource, Coordinate2D initialLocation, int health) {
        super(resource, initialLocation);

        this.health = health;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Enemy) {
            health = health - ((Enemy) collider).getDamage();
        }

        this.onHit(collider);

        if (health <= 0) {
            onDeath();
            remove();
        }
    }

    /**
     * Abstract function that is called on a collision this is to be implemented by the subclass.
     * @param collider The object that is collided with
     */
    public abstract void onHit(Collider collider);

    /**
     * Abstract function that is called when the health of the LivingEntity reaches 0
     */
    public abstract void onDeath();
}
