package han.groepf.topdownshooter.entities.barricade;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.LivingEntity;
import han.groepf.topdownshooter.scenes.GameScene;

/**
 * Represents a barricade for player protection
 */
public class Barricade extends LivingEntity {

    private final double x;
    private final World world;
    private final GameScene game;

    /**
     * This constructor abstracts away the resource selection and coordinate creation based on an X-coordinate and passes this on to the super constructor
     *
     * @param x     The horizontal position for the barricade
     * @param world world to spawn the barricade in
     */
    public Barricade(double x, World world, GameScene game) {
        super("sprites/barricade.png", new Coordinate2D(x, 0), 5);
        this.x = x;
        this.world = world;
        this.game = game;
    }

    /**
     * Returns the current horizontal location of the barricade
     *
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Called whenever a collider collides with the barricade, in most cases an enemy
     *
     * @param collider The object that is collided with
     */
    @Override
    public void onHit(Collider collider) {
        game.updateUserInterface();
    }

    /**
     * Changes the active scene to the end scene on death
     */
    @Override
    public void onDeath() {
        world.setActiveScene(2);
    }
}
