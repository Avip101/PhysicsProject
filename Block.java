// Avi Patel, Jerry Zhang

import java.awt.*;

public class Block
{
    private int mass;
    private double x; 
    private double y;
    private int[] arr;

    private double position = 200;


    public Block(double x, double y, int mass)
    {
        this.x = x;
        this.y = y; 
        this.mass = mass;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }
    public double getMass()
    {
        return this.mass;
    }
    
    public void draw(Graphics page)
    {
        page.setColor( new Color( 150, 100, 50 ) );//color defined using rgb values (0-255 each)
        page.fillRect((int)x, (int)y, 75, 75 );//change the last two numbers and see what happens

    }



    public void setLoc(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void setMass(int m)
    {
        this.mass = m;
    }

    public void setPosition(double pos) {
        this.position = pos;
    }
   
    public double getPosition() {
        return this.position;
    }

    public boolean touchesSpring(Square other, Mouse mouse)
    {
        return false;
    }

}