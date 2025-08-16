
import java.awt.Color;

public class Rectangle implements Drawable {
    Point p1;
    Point p3;

    public Rectangle(Point p1, Point p3) {
        this.p1 = p1;
        this.p3 = p3;
    }

    @Override
    public void draw(Displayable image) {
        Point p2 = new Point(p1.x, p3.y);
        Point p4 = new Point(p3.x, p1.x);

        Color color = getColor();
        Line line1 = new Line(p1, p2);
        line1.color = color;
        Line line2 = new Line(p2, p3);
        line2.color = color;
        Line line3 = new Line(p3, p4);
        line3.color = color;
        Line line4 = new Line(p4, p1);
        line4.color = color;

        line1.draw(image);
        line2.draw(image);
        line3.draw(image);
        line4.draw(image);
    }

    @Override
    public Color getColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }
}
