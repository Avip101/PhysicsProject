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
    private int k;
    private int force; 
    private int mass;
    private int length;
    private int[] coordArr;
    private final int width = 50; 

    private BufferedImage img;

    public Square( int xLoc, int yLoc, int k, int size)
    {
        try {
            img = ImageIO.read(new File("spring.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        this.length = 100;
        this.x = xLoc;
        this.y = yLoc;
        this.vx = 0;
        this.vy = 0;
        this.accel = 10;
        this.k = k;
        this.mass = mass;
        this.coordArr = new int[] {x, x + 50,y, y + length};
    }

    public void move(int xInit, int yInit, int x, int y)
    {
        force = -k * (x - xInit); // for x direction
        accel = force / mass; 

        force = -k * (y - yInit); // for y direction
        accel = force / mass;

        vx = vx + accel;    

        vy = vy + accel;  

    }

    public void draw( Graphics page )
    {
        page.drawImage(img, x, y, width, length, null);
    }

    
    public void adjustLength(int mouseX, int mouseY)
    {
        if (50 < mouseX && mouseX < 100) {
            int length = mouseY-y;
            this.length = length;
        }
    }
    
    
    public void setLoc(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.coordArr = new int[]{x, x + 50,y, y + length};
    }
    
    public void setK(int k) {
        this.k = k;
    }
    
    public void setMass(int m) {
        this.mass = m;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }
   
    

    public int[] getArr()
    {
        return coordArr;
    }    
}