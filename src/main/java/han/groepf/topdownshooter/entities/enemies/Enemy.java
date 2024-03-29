package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.LivingEntity;
import han.groepf.topdownshooter.entities.barricade.Barricade;
import han.groepf.topdownshooter.projectiles.Projectile;
import han.groepf.topdownshooter.scenes.GameScene;

/**
 * Base enemy class
 */
public abstract class Enemy extends LivingEntity {

    private final int damage;
    private GameScene game;
    private World world;

    /**
     * Super class for all enemy types, abstracting away the movement and the implementation of a livingEntity
     *
     * @param resource        The resource file that is used for the SpriteEntity
     * @param initialPosition The initial position of the Enemy
     * @param speed           The speed with which the enemy moves in the LEFT direction
     * @param damage          Amount of damage the enemy does to the barricade
     * @param health          Amount of health the enemy has
     */
    protected Enemy(String resource, Coordinate2D initialPosition, World world, double speed, int damage, int health) {
        super(resource, initialPosition, health);
        this.damage = damage;
        setMotion(speed, Direction.LEFT);
        this.world = world;
    }

    /**
     * Removes the enemy on collision with the barricade
     *
     * @param collider The object that is collided with
     */
    @Override
    public void onHit(Collider collider) {
        if (collider instanceof Barricade) {
            remove();
        }

        if (isDead() && collider instanceof Projectile) {
            onDeath();
        }
    }

    /**
     * Called when the entity dies, increments the killed enemy count, playerscore and then updates the UI
     */
    @Override
    public void onDeath() {
        int score = (int) Math.round(game.getPlayer().distanceTo(this));

        game.incrementPlayerScore(score);
        game.incrementKilledEnemies();
        game.updateUserInterface();
        game.checkLevelProgressAndProgressToNextLevel();
        world.getState().getSlainEnemies().add(this);
    }

    /**
     * Get the amount of damage that is to be inflicted
     *
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Apply damage to the enemy
     * Will die if health reaches 0
     * @param damage damage to apply
     */
    public void applyDamage(int damage) {
        super.removeHealth(damage);
        if (getHealth() <= 0) {
            onDeath();
            remove();
        }
    }

    /**
     * Sets the game scene the enemy belongs to
     * @param game Game scene
     */
    public void setGameScene(GameScene game) {
        this.game = game;
    }
}
