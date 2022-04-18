package han.groepf.topdownshooter.weapons.gun;

import com.github.hanyaeger.api.entities.EntitySpawner;
import han.groepf.topdownshooter.projectiles.Projectile;
import han.groepf.topdownshooter.weapons.IShootable;

public class Gun extends EntitySpawner implements IShootable {

    public Gun(long intervalInMs) {
        super(intervalInMs);
    }

    /**
     * Displays the projectile and moves it to the right fast.
     * @param projectile
     */
    @Override
    public void shoot(Projectile projectile) {
        projectile.setSpeed(25);
        projectile.setDirection(90);
        this.spawn(projectile);
    }

    @Override
    protected void spawnEntities() {
    }
}
