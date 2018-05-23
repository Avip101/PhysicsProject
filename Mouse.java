// Avi Patel, Jerry Zhang
// Use this to store the last location of the object square 
import java.awt.*;
import java.util.*;

public class Mouse
{
    private Square sqr;
    private int x;
    private int y; 
    
    public Mouse(int x, int y)
    {
        //sqr = new Square(0,0);
    }
    
    public void drawSquare(int x, int y, Graphics page)
    {
        //sqr = new Square(x,y);
        this.x = x;
        this.y = y;
        //sqr.draw(page);
        
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int getX()
    {
        return x; 
    }
    
    public int getY()
    {
        return y; 
    }
    
    
    public void draw(Graphics page)
    {
        sqr.draw(page);
    }
    
}
