package projetapp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Sprite implements ISprite {

    private String filename;
    private Image image;
    private int x, y;

    public Sprite(String filename) {
        this(filename, 0, 0);
    }

    public Sprite(String filename, int x, int y) {
        this.filename = filename;
        this.x = x;
        this.y = y;
        this.loadImage();
    }

    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(this.filename));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
}
