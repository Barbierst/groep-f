package han.groepf.topdownshooter.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class LivingEntity extends DynamicSpriteEntity implements Collided, Collider {

    protected LivingEntity(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void onCollision(Collider collider) {

        this.onHit(collider);
    }

    /**
     * Abstract function that is called on a collision this is to be implemented by the subclass.
     * @param collider
     */
    public abstract void onHit(Collider collider);
}
