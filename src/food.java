import java.awt.*;

public class food {
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




    public food (int pXpos, int pYpos, int pDx, int pDy) {
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = 50;
        height = 50;
        isAlive = true;
        isIntersecting = false;
    }
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


