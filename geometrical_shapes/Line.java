import java.awt.Color;

public class Line implements Drawable {
    Point p1;
    Point p2;
    Color color;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void draw(Displayable image) {
        int x1 = p1.x, y1 = p1.y, x2 = p2.x, y2 = p2.y;
        int dx = x2 - x1, dy = y2 - y1;
        double steps = Math.max(Math.abs(dx), Math.abs(dy));

        double inc_x = dx / steps, inc_y = dy / steps;
        double x = x1, y = y1;
        
        if (color == null) {
            color = getColor();
        }

        for (int i = 0; i <= steps; i++) {
            image.display((int) Math.round(x), (int) Math.round(y), color);
            x += inc_x;
            y += inc_y;
        }
    }

    public static Line random(int width, int height) {
        return new Line(Point.random(width, height), Point.random(width, height));
    }
}
