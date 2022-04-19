package han.groepf.topdownshooter.weapons;

import han.groepf.topdownshooter.projectiles.Projectile;

/**
 * Defines a contract for objects a player can use to shoot
 */
public interface IShootable {

    /**
     * Shoots the given projectile
     * @param projectile
     */
    void shoot(Projectile projectile);

}
