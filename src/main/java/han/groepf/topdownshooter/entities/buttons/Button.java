package han.groepf.topdownshooter.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import han.groepf.topdownshooter.World;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private Color hoverColor;
    private Color color;
    protected World world;

    /**
     * Abstract class to handle the default behaviour of a button. This class should be extended upon and the action should be implemented in the sub class
     * Default behaviour includes color changing, and setting the cursor to a hand.
     * @param initialLocation
     * @param text
     * @param world
     * @param color
     * @param hoverColor
     */
    public Button(Coordinate2D initialLocation, String text, World world, Color color, Color hoverColor) {
        super(initialLocation, text);

        this.world = world;
        this.color = color;
        this.hoverColor = hoverColor;

        setFill(color);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public abstract void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D);

    /**
     * When the mouse is in the bounding box of the button change the color to the hove color and set the cursor to a hand
     */
    @Override
    public void onMouseEntered() {
        setFill(hoverColor);
        setCursor(Cursor.HAND);
    }

    /**
     * When the mouse exits the button reset the color and cursor to default
     */
    @Override
    public void onMouseExited() {
        setFill(color);
        setCursor(Cursor.DEFAULT);
    }
}
