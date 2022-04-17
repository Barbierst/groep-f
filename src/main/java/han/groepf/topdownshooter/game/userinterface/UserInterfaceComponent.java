package han.groepf.topdownshooter.game.userinterface;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UserInterfaceComponent {
    private final TextEntity textEntity;
    public UserInterfaceComponent(double x, double y, String startText){
        textEntity = new TextEntity(
                new Coordinate2D(x, y),
                startText
        );
        textEntity.setAnchorPoint(AnchorPoint.TOP_LEFT);
        textEntity.setFill(Color.DARKBLUE);
        textEntity.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 12));
    }

    public void updateText(String newText){
        textEntity.setText(newText);
    }

    public TextEntity getEntity(){
        return textEntity;
    }
}
