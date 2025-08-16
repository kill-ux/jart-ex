
import java.awt.Color;

public class Pentagon implements Drawable {
    Point center;
    int radius;

    public Pentagon(Point point, int radius) {
        this.center = point;
        this.radius = radius;
    }

    public static Pentagon random(int width, int height) {
        return new Pentagon(Point.random(width, height), (int) (Math.random() * Math.max(width, height)));
    }

    @Override
    public void draw(Displayable image) {
        int last_x = radius + center.x;
        int last_y = center.y;
        Color color = getColor();

        for (int i = 0; i <= 5; i++) {
            Point last_point = new Point(last_x,last_y);
            double angle =  ((double) i * (360.0 / 5.) * Math.PI ) / 180. ;
            int x = (int) Math.floor(radius * Math.cos(angle) + (double) center.x) ;
            int y = (int) Math.floor(radius * Math.sin(angle) + (double) center.y) ;
            last_x = x;
            last_y = y;
            Point next_point = new Point(x,y);
            Line line = new Line(last_point, next_point);
            line.color = color;
            line.draw(image);
        }
    }

    @Override
    public Color getColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }
}
