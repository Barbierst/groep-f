package han.groepf.topdownshooter.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.LivingEntity;
import han.groepf.topdownshooter.entities.barricade.Barricade;
import han.groepf.topdownshooter.game.state.GameState;
import han.groepf.topdownshooter.projectiles.Projectile;
import han.groepf.topdownshooter.scenes.GameScene;

public abstract class Enemy extends LivingEntity {

    private final int damage;
    private GameScene game;

    /**
     * Super class for all enemy types, abstracting away the moveement and the implementation of a livingEntity
     *
     * @param resource        The resource file that is used for the SpriteEntity
     * @param initialPosition The initial position of the Enemy
     * @param speed           The speed with which the enemy moves in the LEFT direction
     */
    protected Enemy(String resource, Coordinate2D initialPosition, double speed, int damage, int health) {
        super(resource, initialPosition, health);
        this.damage = damage;
        setMotion(speed, Direction.LEFT);
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
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Enemy) {
            int damage = ((Enemy) collider).getDamage();
            removeHealth(damage);
        }
        if(collider instanceof Projectile){
            if (isDead()) {
                onDeath();
            }
        }
        onHit(collider);
        if (isDead()) {
            remove();
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
        game.checkLevelProgress();
    }

    /**
     * Get the amount of damage that is to be inflicted
     *
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    public void applyDamage(int damage) {
        super.removeHealth(damage);
        if (getHealth() <= 0) {
            onDeath();
            remove();
        }
    }

    public void setGameScene(GameScene game) {
        this.game = game;
    }
}
