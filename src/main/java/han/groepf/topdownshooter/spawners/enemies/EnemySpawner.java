package han.groepf.topdownshooter.spawners.enemies;

import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Collections;
import java.util.List;

public class EnemySpawner extends EntitySpawner implements TimerContainer {

    public EnemySpawner(long intervalInMs) {
        super(intervalInMs);
    }

    @Override
    public void setupTimers() {

    }

    @Override
    public List<Timer> getTimers() {
        return Collections.emptyList();
    }

    @Override
    protected void spawnEntities() {

    }
}
