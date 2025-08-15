import java.awt.Color;

public class Point implements Drawable {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Displayable image) {
        image.display(x, y, getColor());
    }

    @Override
    public Color getColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }
}
