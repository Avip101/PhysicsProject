import java.awt.*;//must be imported to use Graphics and Color

public class Square
{
    private int x;                  // x position
    private int y;                  // y position
    private int vx;                 // x velocity
    private int vy;                 // y velocity
    private int accel;           // for F = -kx
    private int k;
    private int force; 
    private int mass;

    public Square( int xLoc, int yLoc, int k, int mass)
    {
        this.x = xLoc;
        this.y = yLoc;
        this.vx = 0;
        this.vy = 0;
        this.accel = 10;
        this.k = k;
        this.mass = mass;
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
        page.setColor( new Color( 150, 100, 50 ) );//color defined using rgb values (0-255 each)
        page.fillRect( x, y, 75, 75 );//change the last two numbers and see what happens
    }

    public void setLoc(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

}