package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import han.groepf.topdownshooter.entities.LivingEntity;

import java.util.Random;

public abstract class Enemy extends LivingEntity {

    /**
     * Super class for all enemy types, abstracting away the moveement and the implementation of a livingEntity
     * @param resource
     * @param initialPosition
     * @param speed
     */
    protected Enemy(String resource, Coordinate2D initialPosition, double speed) {
        super(resource, initialPosition);
        setMotion(speed, Direction.LEFT);
    }

    @Override
    public void onHit(Collider collider) {
        setSpeed(0);
    }
}
