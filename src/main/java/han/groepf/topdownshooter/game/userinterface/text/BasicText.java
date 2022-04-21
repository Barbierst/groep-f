package han.groepf.topdownshooter.game.userinterface.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BasicText extends TextEntity {

    public BasicText(Coordinate2D initialLocation, String text) {
        super(initialLocation, text);

        this.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }
}
