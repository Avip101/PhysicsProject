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
        
        f = new Font("Dialog", Font.PLAIN, 40);
    }

    public void draw(Graphics page, double k, double mass, double per, double velocity, double force, double maxEnergy)
    {
        int fontsize = 40;
        page.setFont(f);
        page.drawString("Keyboard Commands", x, y);
        page.drawString("1: Set mass to 5", x, y+40);
        page.drawString("2: Set mass to 10", x, y+80);
        page.drawString("3: Set k to 5", x, y+120);
        page.drawString("4: Set k to 10", x, y+160);
        page.drawString("5: Reset", x, y+200);
        page.drawString("6: Run Simulation. (Hold it down)", x, y+240);
        int infoStart = 400;
        page.drawString("K: " + k, x, infoStart);
        page.drawString("Mass: " + mass, x, infoStart+fontsize);
        page.drawString("Period: " + per, x, infoStart+2*fontsize);
        page.drawString("Velocity: " + velocity, x, infoStart+3*fontsize);
        page.drawString("Force: " + force, x, infoStart+4*fontsize);
        page.drawString("Amplitude: 200", x, infoStart+5*fontsize);
        page.drawString("Total Energy: " + maxEnergy, x, infoStart+6*fontsize);
        Font g = new Font("Dialog", Font.PLAIN, 20);
        page.setFont(g);
        page.drawString("By Avi Patel and Jerry Zhang", x+200, 1180);
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