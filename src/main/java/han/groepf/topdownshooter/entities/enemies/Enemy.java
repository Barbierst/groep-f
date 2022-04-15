package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import han.groepf.topdownshooter.entities.LivingEntity;
import han.groepf.topdownshooter.entities.barricade.Barricade;

import java.util.Random;

public abstract class Enemy extends LivingEntity {

    private int damage;
    /**
     * Super class for all enemy types, abstracting away the moveement and the implementation of a livingEntity
     * @param resource
     * @param initialPosition
     * @param speed
     */
    protected Enemy(String resource, Coordinate2D initialPosition, double speed, int damage, int health) {
        super(resource, initialPosition, health);
        this.damage = damage;
        setMotion(speed, Direction.LEFT);
    }

    /**
     * Removes the enemy on collision with the barricade
     * @param collider
     */
    @Override
    public void onHit(Collider collider) {
        if (collider instanceof Barricade) {
            remove();
        }
    }

    @Override
    public void onDeath() {
        // award points
    }

    /**
     * Get the amount of damage that is to be inflicted
     * @return damage
     */
    public int getDamage() {
        return damage;
    }
}
