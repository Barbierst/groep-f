package han.groepf.topdownshooter.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;

public class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    public Button(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }

    @Override
    public void onMouseEntered() {

    }

    @Override
    public void onMouseExited() {

    }
}
