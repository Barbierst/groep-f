package han.groepf.topdownshooter.spawners.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import han.groepf.topdownshooter.entities.powerups.Powerup;

import java.util.Random;

/**
 * Spawns powerups
 */
public class PowerupSpawner extends EntitySpawner {

    private final int maxSpawns;
    private int spawns = 0;
    private final double maxX;
    private final double maxY;

    /**
     * Creates an PowerupSpawner that spawns a random powerup
     * @param intervalInMs Seconds to wait between powerup spawn tries
     * @param maxSpawns Max amount of powerups to spawn per level
     * @param maxX Max X location the powerup can spawn
     * @param maxY Max Y location the powerup can spawn
     */
    public PowerupSpawner(long intervalInMs, int maxSpawns, double maxX, double maxY) {
        super(intervalInMs);
        this.maxSpawns = maxSpawns;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Spawns powerups in random places if the spawn limit hasn't been reached yet
     */
    @Override
    protected void spawnEntities() {
        if (spawns >= maxSpawns) {
            this.pause();
        }

        Random rand = new Random();
        spawns += 1;
        double spawnX = rand.nextInt((int) maxX) + 10;
        double spawnY = rand.nextInt((int) maxY) + 10;
        Powerup p = new Powerup(new Coordinate2D(spawnX, spawnY));
        spawn(p);
    }
}
