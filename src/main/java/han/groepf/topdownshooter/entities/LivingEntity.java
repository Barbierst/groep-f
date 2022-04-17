package han.groepf.topdownshooter.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import han.groepf.topdownshooter.entities.enemies.Enemy;
import han.groepf.topdownshooter.projectiles.Projectile;

public abstract class LivingEntity extends DynamicSpriteEntity implements Collided, Collider {

    private int health;

    protected LivingEntity(String resource, Coordinate2D initialLocation, int health) {
        super(resource, initialLocation);

        this.health = health;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Enemy) {
            int damage = ((Enemy) collider).getDamage();
            removeHealth(damage);
        }

        this.onHit(collider);

        if (isDead()) {
            onDeath();
            remove();
        }
    }

    protected void removeHealth(int amount){
        health -= health;
    }

    protected int getHealth(){
        return health;
    }

    protected boolean isDead(){
        return health <= 0;
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
