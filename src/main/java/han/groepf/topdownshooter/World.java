package han.groepf.topdownshooter;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import han.groepf.topdownshooter.scenes.GameScene;
import han.groepf.topdownshooter.scenes.MenuScene;

public class World extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Day-A");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new MenuScene(this));
        addScene(1, new GameScene(this));
    }
}
