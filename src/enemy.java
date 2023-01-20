import java.awt.*;

public class enemy {


    public String name;

    public int xpos;

    public int ypos;

    public int dx;

    public int dy;

    public int width;

    public int height;

    public boolean isEating;

    public Rectangle rec;
    public boolean isAlive;
    public boolean isIntersecting;
    public Rectangle leftRec;
    public Rectangle rightRec;
    public Rectangle topRec;
    public Rectangle bottomRec;

    public enemy(int pXpos, int pYpos, int pDx, int pDy) {
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = 60;
        height = 60;
        isAlive = true;
        isEating = false;
        isIntersecting = false;


    }

    public void move() {
//        xpos = (xpos) + dx;
//        ypos = (ypos) + dy;
//        if (ypos > 700) {
//            ypos = -width;
//        }  else if (ypos<-width){
//            ypos = 700-width;
//        }
//        if (xpos > 1000){
//            xpos = -height;
//        } else if (xpos < -height) {
//            xpos = 1000-height;
//        }
        xpos = xpos + dx;
        ypos = ypos + dy;
        if(xpos > 1000-width){
            dx = -dx;
        }if(xpos < 0){
            dx = -dx;
        }if(ypos < 0){
            dy = -dy;
        }if(ypos > 700-height){
            dy = -dy;
        }
        rec = new Rectangle(xpos,ypos, width, height);
        leftRec = new Rectangle(xpos, ypos, 1, height-1);
        rightRec = new Rectangle(xpos + 59, ypos + 1, 1, height-1);
        topRec = new Rectangle(xpos + 1, ypos, width-1, 1);
        bottomRec = new Rectangle(xpos + 1, ypos + 59, width-1, 1);

    }
}
