package han.groepf.topdownshooter.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.scenes.DynamicScene;
import han.groepf.topdownshooter.World;
import han.groepf.topdownshooter.entities.barricade.Barricade;
import han.groepf.topdownshooter.entities.player.Player;
import han.groepf.topdownshooter.game.userinterface.UserInterfaceComponent;
import han.groepf.topdownshooter.spawners.enemies.EnemySpawner;
import han.groepf.topdownshooter.spawners.powerups.PowerupSpawner;
import han.groepf.topdownshooter.weapons.IShootable;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    private Player player;
    private final World world;
    private final EntitySpawner bulletSpawner;
    private static UserInterfaceComponent killedEnemyComponent;
    private static UserInterfaceComponent scoreComponent;

    /**
     * The basic game scene in which a controllable player entity, a barricade have been added
     *
     * @param world        Instance of the current game
     * @param bulletSpawner EntitySpawner used to spawn bullets for the player
     */
    public GameScene(World world, EntitySpawner bulletSpawner) {
        this.world = world;
        this.bulletSpawner = bulletSpawner;
    }

    /**
     * Adds the user interface to the scene
     */
    @Override
    public void setupScene() {
        killedEnemyComponent = new UserInterfaceComponent(5, 10, "Enemies killed: 0");
        scoreComponent = new UserInterfaceComponent(5, 20, "Score: 0");

        addEntity(killedEnemyComponent.getEntity());
        addEntity(scoreComponent.getEntity());
    }

    /**
     * Adds the player to the scene
     */
    @Override
    public void setupEntities() {
        player = new Player(new Coordinate2D(getWidth() * 0.1, getHeight() * 0.1));
        player.setWeapon((IShootable) bulletSpawner);
        addEntity(player);
        addEntity(new Barricade(getWidth() * 0.15, this.world));
    }

    /**
     * Adds enemy spawner and player gun to the scene
     */
    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new EnemySpawner(getWidth(), getHeight(), this));
        addEntitySpawner(bulletSpawner);

        if(world.getSettings().isPowerUpsOn()){
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
     * Updates the user interface text
     */
    public void updateUserInterface() {
        killedEnemyComponent.updateText("Enemies killed: " + world.getState().getKilledEnemyCount());
        scoreComponent.updateText("Score: " + world.getState().getPlayerScore());
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
        world.getState().incrementKilledEnemyCount();
    }
}
