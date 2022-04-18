package han.groepf.topdownshooter.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Powerup extends SpriteEntity implements IActivateAble, Collider {
    public Powerup(Coordinate2D location) {
        super("sprites/powerup.png", location, new Size(32,32));
    }

    /**
     * Called to activate the powerup
     */
    @Override
    public void activate() {
        System.out.println("Activated powerup!");
    }
}
