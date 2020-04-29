import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {
    public static void main(String[] args) throws IOException {
        BufferedImage read = ImageIO.read(new File("C:/Java5/image.png")); // Incarc o imagine folosind metoda statica read din clasa ImageIO
        BufferedImage rotate = Scalr.rotate(read, Scalr.Rotation.CW_90); // Rotesc imaginea incarcata anterior folosind metoda statica rotate din clasa Scalr
        System.out.println(read);
        System.out.println(rotate);

    }
}
