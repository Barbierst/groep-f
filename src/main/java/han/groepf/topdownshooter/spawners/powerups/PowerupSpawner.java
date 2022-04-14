package han.groepf.topdownshooter.spawners.powerups;

import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.List;

public class PowerupSpawner extends EntitySpawner implements TimerContainer {

    public PowerupSpawner(long intervalInMs) {
        super(intervalInMs);
    }

    @Override
    public void setupTimers() {

    }

    @Override
    public List<Timer> getTimers() {
        return null;
    }

    @Override
    protected void spawnEntities() {

    }
}
