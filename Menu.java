import java.awt.*;

public class Menu
{
    private int x;                  // x position
    private int y;                  // y position
    Font f;
    
    public Menu(int xLoc, int yLoc)
    {
        this.x = xLoc;
        this.y = yLoc;
        f = new Font("Dialog", Font.PLAIN, 20);
    }

    public void draw( Graphics page )
    {
        page.setFont(f);
        page.drawString("Keys", x, y);
        page.drawString("1: Set mass to 50 (default)", x, y+20);
        page.drawString("2: Set mass to 100", x, y+40);
        page.drawString("3: Set k to 10 (default)", x, y+60);
        page.drawString("4: Set k to 50", x, y+80);
    }

    public void setLoc(int x, int y)
    {
        this.x = x;
        this.y = y;
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