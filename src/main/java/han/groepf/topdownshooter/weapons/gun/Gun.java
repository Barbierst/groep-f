package han.groepf.topdownshooter.weapons.gun;

import com.github.hanyaeger.api.entities.EntitySpawner;
import han.groepf.topdownshooter.projectiles.Projectile;
import han.groepf.topdownshooter.weapons.IShootable;

public class Gun extends EntitySpawner implements IShootable {

    protected Gun(long intervalInMs) {
        super(intervalInMs);
    }

    @Override
    public void shoot(Projectile projectile) {

    }

    @Override
    protected void spawnEntities() {

    }
}
