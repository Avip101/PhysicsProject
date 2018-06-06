import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Square
{
    private int x;                  // x position
    private int y;                  // y position
    private int size;
    private int vx;                 // x velocity
    private int vy;                 // y velocity
    private int accel;              // for F = -kx
    private double k = 1;
    private int force; 
    private int mass;
    private double length;
    private int[] coordArr;
    private final int width = 50; 

    private BufferedImage img;

    public Square( int xLoc, int yLoc, double k, int size)
    {
        try {
            img = ImageIO.read(new File("spring.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        this.length = 300;
        this.x = xLoc;
        this.y = yLoc;
        this.vx = 0;
        this.vy = 0;
        this.accel = 10;
        this.k = k;
        this.mass = 100;
    }

    public void move()
    {
    }

    public void draw( Graphics page )
    {
        page.drawImage(img, x, y, width, (int)length, null);
    }

    public void adjustLength(double yCoord)
    {
        this.length = yCoord - 50;
    }
    
    public void setLength(double length) {
        this.length = length;
    }
    
    public void setLoc(int x, int y)
    {
        this.x = x;
        this.y = y;
        
    }

    public void setK(int k) {
        this.k = k;
    }

    public void setMass(int m) {
        this.mass = m;
    }

    public double getK() {
        return this.k;
    }
    
    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }
}