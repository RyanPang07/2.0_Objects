import java.awt.*;

/**
 * Created by chales on 11/6/2017.
 */
public class Astronaut {

    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;
    public boolean isIntersecting;
    public boolean isEating;
    //a boolean to denote if the hero is alive or dead.


    // METHOD DEFINITION SECTION

    // Constructor Definition
    // A constructor builds the object when called and sets variable values.


    //This is a SECOND constructor that takes 3 parameters.  This allows us to specify the hero's name and position when we build it.
    // if you put in a String, an int and an int the program will use this constructor instead of the one above.
    public void printInfo(){
        System.out.println("the (x,y) position of my astro is: " + xpos + ", "+ypos);
        System.out.println("the x speed is "+dx+ " and the y speed is " + dy+"");
        System.out.println("the (width, height) of my astro is "+width+", "+height+"");
        System.out.println("it is " + isAlive + "that my astro is alive");

    }

    public Astronaut(int pXpos, int pYpos, int pDx, int pDy) {
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = 150;
        height = 150;
        isAlive = true;
        isIntersecting = false;
        isEating = false;

    } // constructor

    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;

        if(xpos>1000){
            xpos=0;
        }
        if (ypos>700){
            ypos=0;
        }
        if(ypos<0){
            ypos=700;
        }


        rec = new Rectangle (xpos, ypos, width, height);
    }
}






