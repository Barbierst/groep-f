package han.groepf.topdownshooter.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import han.groepf.topdownshooter.entities.barricade.Barricade;
import han.groepf.topdownshooter.entities.powerups.IActivateAble;
import han.groepf.topdownshooter.entities.powerups.Powerup;
import han.groepf.topdownshooter.projectiles.bullets.FireBullet;
import han.groepf.topdownshooter.weapons.IShootable;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {

    private IShootable shootable;
    private IActivateAble powerUp;

    /**
     * This constructor abstracts away the resource selection and passes on the initial location to the super constructor
     * Adds friction to stop the player after a key is released
     *
     * @param initialLocation The initial location for the Player
     */
    public Player(Coordinate2D initialLocation) {
        super("sprites/player.png", initialLocation);

        setGravityConstant(0);
        setFrictionConstant(0.04);
    }

    /**
     * Lissen to the pressed key changed event and move the player in the correct direction
     *
     * @param pressedKeys The pressed keys
     */
    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(3, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(3, Direction.RIGHT);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(3, Direction.UP);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(3, Direction.DOWN);
        } else if (pressedKeys.contains(KeyCode.SPACE)) {
            shootable.shoot(new FireBullet(new Coordinate2D(this.getLocationInScene())));
        }else if(pressedKeys.contains(KeyCode.X)){
            if(powerUp != null){
                powerUp.activate();
                powerUp = null;
            }
        }
    }

    /**
     * When the player touches a border the speed is set to 0 to prevent leaving the game.
     *
     * @param sceneBorder The ScheneBorde that is touched
     */
    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        setSpeed(0);
        switch (sceneBorder) {
            case TOP -> setAnchorLocationY(1);
            case BOTTOM -> setAnchorLocationY(getSceneHeight() - getHeight() - 1);
            case LEFT -> setAnchorLocationX(1);
            case RIGHT -> setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default -> {
            }
        }
    }

    /**
     * Prevent the player from crossing the barricade
     *
     * @param collider The object that is collided with
     */
    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Barricade) {
            setSpeed(0);
            setAnchorLocationX(((Barricade) collider).getX() - collider.getWidth());
        }
        if (collider instanceof Powerup) {
            ((Powerup) collider).notifyRemove();
            powerUp = (IActivateAble) collider;
        }
    }

    /**
     * Set the player's currently weapon and projectile
     *
     * @param weapon Weapon to fire
     */
    public void setWeapon(IShootable weapon) {
        this.shootable = weapon;
    }
}
