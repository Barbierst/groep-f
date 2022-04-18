package han.groepf.topdownshooter;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import han.groepf.topdownshooter.game.settings.Settings;
import han.groepf.topdownshooter.game.state.GameState;
import han.groepf.topdownshooter.scenes.EndScene;
import han.groepf.topdownshooter.scenes.GameScene;
import han.groepf.topdownshooter.scenes.MenuScene;
import han.groepf.topdownshooter.scenes.SettingsScene;
import han.groepf.topdownshooter.weapons.gun.Gun;

public class World extends YaegerGame {

    private final GameState state = new GameState();
    private final Settings settings = new Settings();

    public static void main(String[] args) {
        launch("--noSplash");
    }

    @Override
    public void setupGame() {
        setGameTitle("Day-A");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new MenuScene(this));
        addScene(1, new GameScene(this, new Gun(200)));
        addScene(2, new EndScene(this));
        addScene(3, new SettingsScene(this));
    }

    public GameState getState(){
        return state;
    }

    public Settings getSettings(){
        return settings;
    }
}
