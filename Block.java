// Avi Patel, Jerry Zhang

import java.awt.*;

public class Block
{
    private int mass;
    private int x; 
    private int y;

    public Block(int x, int y, int mass)
    {
        this.x = x;
        this.y = y; 
        this.mass = mass;
    }

    public void draw(Graphics page)
    {
        page.setColor( new Color( 150, 100, 50 ) );//color defined using rgb values (0-255 each)
        page.fillRect( x, y, 75, 75 );//change the last two numbers and see what happens
    }

    public void setLoc(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public boolean touchesSpring(Square other)
    {
        if(x == other.getX() && y == other.getY())
        {
            
            return true;
        }
        return false;      
    }

    
}