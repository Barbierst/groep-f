package han.groepf.topdownshooter.entities.barricade;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.LivingEntity;

public class Barricade extends LivingEntity {

    private final double x;
    private final World world;

    /**
     * This constructor abstracts away the resource selection and coordinate creation based on a X-coordinate and passes this on to the super constructor
     * @param x
     */
    public Barricade(double x, World world) {
        super("sprites/barricade.png", new Coordinate2D(x, 0), 5);
        this.x = x;
        this.world = world;
    }

    /**
     * Returns the current horizontal location of the barricade
     * @return x
     */
    public double getX() {
        return x;
    }

    @Override
    public void onHit(Collider collider) {
        // barricade specific on hit
    }

    @Override
    public void onDeath() {
        world.setActiveScene(2);
    }
}
