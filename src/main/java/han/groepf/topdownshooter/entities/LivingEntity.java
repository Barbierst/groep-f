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

    /**
     * Function which executes upon colliding with another Collider
     * @param collider Target it collided with
     */
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

    /**
     * Removes health from the living entity
     * @param amount Amount to remove
     */
    protected void removeHealth(int amount){
        health -= health;
    }

    /**
     * Gets the entities' current health
     * @return Amount of health
     */
    protected int getHealth(){
        return health;
    }

    /**
     * Checks if the entity is dead
     * @return True if below or equal to 0
     */
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
