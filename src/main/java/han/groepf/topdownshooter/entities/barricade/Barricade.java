package han.groepf.topdownshooter.entities.barricade;

import com.github.hanyaeger.api.Coordinate2D;
import han.groepf.topdownshooter.entities.LivingEntity;

public class Barricade extends LivingEntity {

    private final double x;

    /**
     * This constructor abstracts away the resource selection and coordinate creation based on a X-coordinate and passes this on to the super constructor
     * @param x
     */
    public Barricade(double x) {
        super("sprites/barricade.png", new Coordinate2D(x, 0));
        this.x = x;
    }

    /**
     * Returns the current horizontal location of the barricade
     * @return x
     */
    public double getX() {
        return x;
    }
}
