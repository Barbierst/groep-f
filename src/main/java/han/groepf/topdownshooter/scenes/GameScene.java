package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.scenes.DynamicScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.barricade.Barricade;
import han.groepf.topdownshooter.entities.player.Player;
import han.groepf.topdownshooter.game.state.Level;
import han.groepf.topdownshooter.game.userinterface.UserInterfaceComponent;
import han.groepf.topdownshooter.spawners.enemies.EnemySpawner;
import han.groepf.topdownshooter.spawners.powerups.PowerupSpawner;
import han.groepf.topdownshooter.weapons.IShootable;
import han.groepf.topdownshooter.weapons.gun.Gun;

/**
 * Represents the game screen
 */
public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    private Player player;
    private final World world;
    private final Level level;
    private final EntitySpawner bulletSpawner;
    private Barricade barricade;
    private static UserInterfaceComponent killedEnemyComponent;
    private static UserInterfaceComponent scoreComponent;
    private static UserInterfaceComponent enemiesToKillComponent;
    private static UserInterfaceComponent barricadeHealth;

    /**
     * The basic game scene in which a controllable player entity, a barricade have been added
     *
     * @param world Instance of the current game
     */
    public GameScene(World world, Level level) {
        this.bulletSpawner = new Gun(1);
        this.world = world;
        this.level = level;
    }

    /**
     * Adds the user interface to the scene
     */
    @Override
    public void setupScene() {

    }

    /**
     * Adds the player to the scene
     */
    @Override
    public void setupEntities() {
        double width = getWidth();

        killedEnemyComponent = new UserInterfaceComponent(width * 0.8, 10, "Enemies killed: " + level.getKilledEnemies());
        scoreComponent = new UserInterfaceComponent(width * 0.8, 30, "Score: " + world.getState().getPlayerScore());
        enemiesToKillComponent = new UserInterfaceComponent(width * 0.8, 50, "Enemies to kill: " + level.getEnemiesToKill());
        player = new Player(new Coordinate2D(width * 0.1, getHeight() * 0.1));
        player.setWeapon((IShootable) bulletSpawner);

        barricade = new Barricade(width * 0.15, world, this);
        barricadeHealth = new UserInterfaceComponent(width * 0.2, 10, "Barricade lives remaining: " + barricade.getHealth());

        addEntity(player);
        addEntity(barricade);
        addEntity(killedEnemyComponent.getEntity());
        addEntity(scoreComponent.getEntity());
        addEntity(enemiesToKillComponent.getEntity());
        addEntity(barricadeHealth.getEntity());
    }

    /**
     * Adds enemy spawner and player gun to the scene
     */
    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new EnemySpawner(getWidth(), getHeight(), this, world));
        addEntitySpawner(bulletSpawner);

        if (world.getSettings().isPowerUpsOn()) {
            addEntitySpawner(new PowerupSpawner(10000, 2, getWidth() * 0.1, getHeight() * 0.9));
        }

        if (bulletSpawner.isActive()) {
            bulletSpawner.pause();
        }
    }

    /**
     * Returns the player entity
     *
     * @return Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Checks whether the level has finished, if so it will go to the next level
     */
    public void checkLevelProgress() {
        if (level.hasFinishedLevel()) {
            world.nextLevel(level.levelNumber);
        }
    }

    /**
     * Updates the user interface text
     */
    public void updateUserInterface() {
        killedEnemyComponent.updateText("Enemies killed: " + level.getKilledEnemies());
        scoreComponent.updateText("Score: " + world.getState().getPlayerScore());
        barricadeHealth.updateText("Barricade lives remaining: " + barricade.getHealth());
    }

    /**
     * Increments the player's score by the amount given
     *
     * @param score Score to increment by
     */
    public void incrementPlayerScore(int score) {
        world.getState().incrementPlayerScore(score);
    }

    /**
     * Increments the player's kill count
     */
    public void incrementKilledEnemies() {
        level.incrementKilledEnemyCount();
    }
}
