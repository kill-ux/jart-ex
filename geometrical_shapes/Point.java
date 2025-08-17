
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

    public static Point random(int width, int height) {
        return new Point((int) (Math.random() * width), (int) (Math.random() * height));
    }
}
