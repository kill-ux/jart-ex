import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Image {
    public Image() {
        try {
            int width = 1000;
            int higth = 1000;
            BufferedImage image = new BufferedImage(width, higth, BufferedImage.TYPE_INT_RGB);
            ImageIO.write(image, "PNG", new File("image.png"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}