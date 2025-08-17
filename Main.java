
// interface Displayable {
//     void display(int x, int y, Color color);
//     void save(String string);
// }

// interface Drawable {
//     void draw(Displayable displayable);
//     Color getColor();
// }

public class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);
        Point point1 = new Point(0, 10);
        Point point2 = new Point(500, 0);
        // point1.draw(image);
        Line line = new Line(point1, point2);
        line.draw(image);
        Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
        rectangle.draw(image);
        Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900),
                new Point(100, 900));
        triangle.draw(image);

        for (int i = 0; i < 50; i++) {
            Circle circle = Circle.random(image.getWidth(), image.getHeight());
            circle.draw(image);
        }
        Pentagon pen1 = new Pentagon(new Point(500, 500), 30);
        pen1.draw(image);

        Cube cube = new Cube(new Point(400, 300), 80);
        cube.draw(image);

        for (int i = 0; i < 5; i++) {
            Pentagon pen = Pentagon.random(image.getWidth(), image.getHeight());
            pen.draw(image);
        }

        Drawable[] arr = new Drawable[] {
                Point.random(image.getWidth(), image.getHeight()),
                Line.random(image.getWidth(), image.getHeight()),
                Triangle.random(image.getWidth(), image.getHeight()),
                Circle.random(image.getWidth(), image.getHeight()),
                Rectangle.random(image.getWidth(), image.getHeight()),
                Pentagon.random(image.getWidth(), image.getHeight()),
                Cube.random(image.getWidth(), image.getHeight()),
        };

        for (Drawable shape : arr) {
            shape.draw(image);
        }

        image.save("image.png");
    }
}