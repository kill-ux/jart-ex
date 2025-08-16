
import java.awt.Color;

public class Cube implements Drawable {
    Point point;
    int side;

    public Cube(Point point, int side) {
        this.point = point;
        this.side = side;
    }

    public static Cube random(int width, int height) {
        return new Cube(Point.random(width, height), (int) (Math.random() * Math.max(width, height)));
    }

    @Override
    public void draw(Displayable image) {
        Point p1 = point;
        Point p2 = new Point(p1.x + side, p1.y);
        Point p3 = new Point(p1.x + side, p1.y + side);
        Point p4 = new Point(p1.x, p1.y + side);

        int d = Math.abs((p3.x - p1.x)) / 3;

        Point p1_b = new Point(p1.x + d, p1.y - d);
        Point p2_b = new Point(p2.x + d, p2.y - d);
        Point p3_b = new Point(p3.x + d, p3.y - d);
        Point p4_b = new Point(p4.x + d, p4.y - d);

        Color color = getColor();

        Rectangle rec1 = new Rectangle(p1, p3);
        rec1.color = color;
        rec1.draw(image);
        Rectangle rec2 = new Rectangle(p1_b, p3_b);
        rec2.color = color;
        rec2.draw(image);

        Line line1 = new Line(p1, p1_b);
        line1.color = color;
        line1.draw(image);
        Line line2 = new Line(p2, p2_b);
        line2.color = color;
        line2.draw(image);
        Line line3 = new Line(p3, p3_b);
        line3.color = color;
        line3.draw(image);
        Line line4 = new Line(p4, p4_b);
        line4.color = color;
        line4.draw(image);

    }

    @Override
    public Color getColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }
}
