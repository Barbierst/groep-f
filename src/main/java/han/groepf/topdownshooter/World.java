package han.groepf.topdownshooter;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class World extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Working title");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {

    }
}
