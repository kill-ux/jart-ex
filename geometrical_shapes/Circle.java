
import java.awt.Color;

public class Circle implements Drawable {
    Point point;
    int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public static Circle random(int width, int height) {
        return new Circle(Point.random(width, height), (int) (Math.random() * Math.max(width, height)));
    }

    @Override
    public void draw(Displayable image) {
        int x = 0;
        int y = -radius;
        int r = radius;
        // x.pow(2) + (y as f32 + 0.5).powf(2.) - r.pow(2);
        double p = (double) -r + 0.25;
        int cx = this.point.x;
        int cy = this.point.y;

        Color color = getColor();
        if (r == 0) {
            image.display(cx + y, cy - x, color);
        }

        while (x < -y) {
            // normal
            // p = x.pow(2) + (y + 0.5).powf(2.) - r.pow(2);
            if (p > 0.) {
                // p = (x+1).pow(2) + (y + 1.5).powf(2.) - r.pow(2);
                p += 2. * (double) (x + y) + 1.;
                y++;
            } else {
                // p = (x+1).pow(2) + (y + 0.5).powf(2.) - r.pow(2);
                p += (double) (2 * x + 1);
            }

            image.display(cx + x, cy + y, color);
            image.display(cx - x, cy + y, color);
            image.display(cx - x, cy - y, color);
            image.display(cx + x, cy - y, color);
            image.display(cx + y, cy + x, color);
            image.display(cx - y, cy + x, color);
            image.display(cx - y, cy - x, color);
            image.display(cx + y, cy - x, color);

            x++;
        }
    }

}
