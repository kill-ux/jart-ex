import java.awt.Color;

public interface Drawable {
    void draw(Displayable displayable);

    default Color getColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    };
}
