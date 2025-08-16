
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// Image 
public class Image implements Displayable {
    BufferedImage image;
    int width;
    int height;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                display(x, y, Color.BLACK);
            }
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
        if (x >= 0 && x < width && y >= 0 && y < height) {
            image.setRGB(x, y, color.getRGB());
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}