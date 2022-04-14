package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.entities.LivingEntity;

public abstract class Enemy  extends LivingEntity {

    protected Enemy(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
