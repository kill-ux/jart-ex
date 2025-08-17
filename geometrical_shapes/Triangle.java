
import java.awt.Color;

public class Triangle implements Drawable {
    Point p1;
    Point p2;
    Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public void draw(Displayable image) {
        Color color = getColor();
        Line line1 = new Line(p1, p2);
        line1.color = color;
        Line line2 = new Line(p2, p3);
        line2.color = color;
        Line line3 = new Line(p3, p1);
        line3.color = color;

        line1.draw(image);
        line2.draw(image);
        line3.draw(image);
    }

    public static Triangle random(int width, int height) {
        return new Triangle(Point.random(width, height), Point.random(width, height), Point.random(width, height));
    }
}
