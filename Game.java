import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Game extends JPanel implements KeyListener, ActionListener, MouseMotionListener
{
    private Square square;
    private Mouse mouse;
    private Block block;
    private Menu menu;

    //constructor - sets the initial conditions for this Game object
    public Game(int width, int height)
    {
        //make a panel with dimensions width by height with a black background
        this.setLayout( null );//Don't change
        this.setBackground( Color.WHITE );
        this.setPreferredSize( new Dimension( width, height ) );//Don't change

        //initialize the instance variables
        square = new Square( 500, 500, 50, 50 ); //change these numbers and see what happens
        mouse = new Mouse(0,0);
        block = new Block(250,250,50);
        menu = new Menu(15,15);
        this.addKeyListener(this);//allows the program to respond to key presses - Don't change
        this.addMouseMotionListener(this);
        this.setFocusable(true);//I'll tell you later - Don't change
    }

    //This is the method that runs the game
    public void playGame()
    {
        boolean over = false;
        while( !over )
        {            
            //square.move(500,500, mouse.getX(), mouse.getY());
            if(block.touchesSpring(square))
            {
               

            }
            
            try
            {
                Thread.sleep( 1 );//pause for 200 milliseconds
            }catch( InterruptedException ex ){}            
            this.repaint();//redraw the screen with the updated locations; calls paintComponent below
        }
    }

    //Precondition: executed when repaint() or paintImmediately is called
    //Postcondition: the screen has been updated with current player location
    public void paintComponent( Graphics page )
    {
        super.paintComponent( page );//I'll tell you later.
        square.draw( page );//calls the draw method in the Square class
        block.draw(page);
        menu.draw(page);
    }

    //not used but must be present
    public void keyReleased( KeyEvent event )
    {  
    }

    //tells the program what to do when keys are pressed
    public void keyPressed( KeyEvent event )
    {

    }

    //not used but must be present
    public void keyTyped( KeyEvent event )
    {
    }

    public void actionPerformed(ActionEvent event)
    {
    }

    public void mouseMoved(MouseEvent event)
    {
    }

    public void mouseDragged(MouseEvent event)
    {
        int mouseX = event.getX();
        int mouseY = event.getY();
        mouse.setX(mouseX);
        mouse.setY(mouseY);
        //square.setLoc(mouseX, mouseY);
        block.setLoc(mouseX, mouseY);
        //square.move(500,500, mouse.getX(), mouse.getY());
    }
}