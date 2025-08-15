
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// Image 
public class Image implements Displayable {
    BufferedImage image;

    public Image(int width, int higth) {
        try {
            this.image = new BufferedImage(width, higth, BufferedImage.TYPE_INT_RGB);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void save(String output) {
        try {
            ImageIO.write(this.image, "PNG", new File(output));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void display(int x, int y, Color color) {
        if (x >= 0 && x <= image.getWidth() && y >= 0 && y <= image.getHeight()) {
            image.setRGB(x, y, color.getRGB());
        }
    }
}