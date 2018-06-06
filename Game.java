import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Game extends JPanel implements KeyListener, ActionListener, MouseMotionListener
{
    private Square square;
    private Mouse mouse;
    private Block block;
    private Menu menu;


    private BufferedImage hooke;
    private BufferedImage newton;
    
    //constructor - sets the initial conditions for this Game object
    public Game(int width, int height)
    {
        //make a panel with dimensions width by height with a black background
        this.setLayout( null );//Don't change
        this.setBackground( Color.WHITE );
        this.setPreferredSize( new Dimension( width, height ) );//Don't change

        //initialize the instance variables
        square = new Square( 50, 50, 1, 50 ); //change these numbers and see what happens
        mouse = new Mouse(0,0);
        block = new Block(250,250,1);
        menu = new Menu(600,30);
        this.addKeyListener(this);//allows the program to respond to key presses - Don't change
        this.addMouseMotionListener(this);
        this.setFocusable(true);//I'll tell you later - Don't change
        try {
            hooke = ImageIO.read(new File("hooke.jpg"));
            newton = ImageIO.read(new File("newton.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //This is the method that runs the game
    public void playGame()
    {
        boolean over = false;
        while( !over )
        {            
            //square.move(500,500, mouse.getX(), mouse.getY());
            if(block.touchesSpring(square, mouse))
            {
                //square.move();
            }      
            this.repaint();//redraw the screen with the updated locations; calls paintComponent below
        }
    }

    //Precondition: executed when repaint() or paintImmediately is called
    //Postcondition: the screen has been updated with current player location
    public void paintComponent( Graphics page )
    {
        super.paintComponent(page);
        page.drawImage(hooke, 600, 660, 350, 450, null);
        page.drawImage(newton, 60, 700, 350, 450, null);
        square.draw(page);
        block.draw(page);
        menu.draw(page, k, block.getMass(), period, velocity, force, maxEnergy);
    }

    //not used but must be present
    public void keyReleased( KeyEvent event )
    {  
    }

    //tells the program what to do when keys are pressed
    public void keyPressed( KeyEvent event)
    {   
        if (event.getKeyChar() == '1') { //m=50
            block.setMass(5);
        } else if (event.getKeyChar() == '2') { // m=100
            block.setMass(10);
        } else if (event.getKeyChar() == '3') { // k=10
            k = 5;
        } else if (event.getKeyChar() == '4') { // k=20
            k = 10;
        } else if (event.getKeyChar() == '5') { // reset
            square.setLoc(50, 50);
            k = 1;
            square.setLength(300);
            block.setLoc(250,250);
            block.setMass(1);
            time = 1;
            force = 0;
            acceleration = 0;
            velocity = 0;
            positionPositive = false;

        } else if (event.getKeyChar() == '6') { //move
            block.setLoc(40,150);

            move();
        }
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

    public void mouseReleased(MouseEvent event, Graphics page)
    {
        int mouseX = event.getX();
        int mouseY = event.getY();        
        System.out.println("HELLO!!!!!!!!");

    }

    public void mouseDragged(MouseEvent event)
    {
        int mouseX = event.getX();
        int mouseY = event.getY();
        mouse.setX(mouseX);
        mouse.setY(mouseY);
        //square.setLoc(mouseX, mouseY);
        if(!block.touchesSpring(square, mouse))
        {
            //block.setLoc(mouseX, mouseY);
        }
        //square.adjustLength(mouseX, mouseY);
    }

    double force = 0;
    double acceleration = 0;
    double velocity = 0;
    double time = 1;

    double k = 1;
    double maxEnergy = k*200*200;
    boolean positionPositive = false;
    double period = 0;
    double timeDifference = 0.05;

    public void move() {
        maxEnergy = k*200*200;
        double position = block.getPosition();
        double mass = block.getMass();
        period = 2*Math.PI*Math.sqrt(mass/k);
        //System.out.println(" V: " + velocity + " Pos: " + position + " Force: " + force);
        force = -k*position;
        acceleration = force/mass;
        //System.out.println(acceleration*timeDifference);
        velocity = velocity + acceleration*timeDifference;
        //System.out.println(velocity);
        double mv2 = mass * velocity * velocity;
        if (!positionPositive) {
            if (mv2 > maxEnergy) {
                position = -Math.sqrt((mass*velocity*velocity - maxEnergy)/k);
                positionPositive = true;
                //                  System.out.println("MEME1");
            } else {
                position = Math.sqrt((maxEnergy - mass*velocity*velocity)/k);
            }
        } else {
            if (mv2 > maxEnergy) {
                position = Math.sqrt((mass*velocity*velocity - maxEnergy)/k);
                positionPositive = false;
                //System.out.println("MEME2");
            } else {
                position = -Math.sqrt((maxEnergy - mass*velocity*velocity)/k);

            }
        }

        //System.out.println(position);
        block.setPosition(position);
        block.setLoc(block.getX(), position+400);

        square.adjustLength(position+400);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("I was interrupted!");
            e.printStackTrace();
        }
        //  System.out.println("PERIOD: " + period + " V: " + velocity + " Pos: " + position + " Force: " + force);
        time = time + timeDifference;

    }
}