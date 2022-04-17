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
import han.groepf.topdownshooter.weapons.IShootable;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    private Player player;
    private final World world;
    private final EntitySpawner playerWeapon;
    private static UserInterfaceComponent killedEnemyComponent;
    private static UserInterfaceComponent scoreComponent;

    /**
     * The basic game scene in which a controllable player entity, a barricade have been added
     *
     * @param world        Instance of the current game
     * @param playerWeapon
     */
    public GameScene(World world, EntitySpawner playerWeapon) {
        this.world = world;
        this.playerWeapon = playerWeapon;
    }

    @Override
    public void setupScene() {
        killedEnemyComponent = new UserInterfaceComponent(5, 10, "Enemies killed: 0");
        scoreComponent = new UserInterfaceComponent(5, 20, "Score: 0");

        addEntity(killedEnemyComponent.getEntity());
        addEntity(scoreComponent.getEntity());
    }

    @Override
    public void setupEntities() {
        player = new Player(new Coordinate2D(getWidth() * 0.1, getHeight() * 0.1));
        player.setWeapon((IShootable) playerWeapon);
        addEntity(player);
        addEntity(new Barricade(getWidth() * 0.15, this.world));
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new EnemySpawner(getWidth(), getHeight(), this));
        addEntitySpawner(playerWeapon);
        if (playerWeapon.isActive()) {
            playerWeapon.pause();
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void updateUserInterface() {
        killedEnemyComponent.updateText("Enemies killed: " + world.getState().getKilledEnemyCount());
        scoreComponent.updateText("Score: " + world.getState().getPlayerScore());
    }

    public void incrementPlayerScore(int score) {
        world.getState().incrementPlayerScore(score);
    }

    public void incrementKilledEnemies() {
        world.getState().incrementKilledEnemyCount();
    }
}
