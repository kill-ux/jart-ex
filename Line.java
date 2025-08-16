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
            double fx = x - Math.floor(x);
            double fy = y - Math.floor(y);

            // Determine which pixel gets more weight
            if (fx <= 0.5 && fy <= 0.5) {
                // Primary pixel is floor(x), floor(y)
                image.display((int) Math.floor(x), (int) Math.floor(y), color);
                // Secondary pixel gets partial alpha
                if (fx > fy) {
                    int alpha = (int) (255 * (0.5 - fx) / 0.5);
                    image.display((int) Math.ceil(x), (int) Math.floor(y),
                            new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
                } else {
                    int alpha = (int) (255 * (0.5 - fy) / 0.5);
                    image.display((int) Math.floor(x), (int) Math.ceil(y),
                            new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
                }
            } else if (fx > 0.5 && fy > 0.5) {
                // Primary pixel is ceil(x), ceil(y)
                image.display((int) Math.ceil(x), (int) Math.ceil(y), color);
                // Secondary pixel gets partial alpha
                if (fx < fy) {
                    int alpha = (int) (255 * (fx - 0.5) / 0.5);
                    image.display((int) Math.floor(x), (int) Math.ceil(y),
                            new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
                } else {
                    int alpha = (int) (255 * (fy - 0.5) / 0.5);
                    image.display((int) Math.ceil(x), (int) Math.floor(y),
                            new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
                }
            } else {
                // Default case - just draw the rounded pixel
                image.display((int) Math.round(x), (int) Math.round(y), color);
            }

            x += inc_x;
            y += inc_y;
        }
    }

    @Override
    public Color getColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255), 255);
    }

    public static Line random(int width, int height) {
        return new Line(Point.random(width, height), Point.random(width, height));
    }
}
