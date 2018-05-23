// Avi Patel, Jerry Zhang

import java.awt.*;

public class Block
{
    private int mass;
    private int x; 
    private int y;
    private int[] arr;

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

    public boolean touchesSpring(Square other, Mouse mouse)
    {
        arr = other.getArr();
        int x = mouse.getX();
        int y = mouse.getY();
        if( arr[0] < x  && arr[1] > x && arr[2] < y && arr[3] > y)
        {
            this.x = arr[0];
            this.y = arr[3];
            return true;
        }
        
        return false;      
    }

}