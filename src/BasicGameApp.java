//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable {

   //Variable Definition Section
   //Declare the variables used in the program 
   //You can set their initial values too
   
   //Sets the width and height of the program window
	final int WIDTH = 1000;
	final int HEIGHT = 700;

   //Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
    public JPanel panel;
   
	public BufferStrategy bufferStrategy;
	public Image oceanPic;
	public Image myminionPic;
	public Image patrickPic;
	public Image minionPic;
	public Image junglePic;
	public Image icePic;
	public Image bananaclusterPic;
	public Image bananaPic;
	public Image jetpackPic;
   //Declare the objects used in the program
   //These are things that are made up of more than one variable type
	private enemy myminion;

	public Astronaut patrick;
	public enemy minion;
	public food banana;
	public enemy jetpack;
	public food bananacluster;
	public food[] bananaArray = new food[3];


   // Main method definition
   // This is the code that runs first and automatically
	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
		new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method  
	}


   // Constructor Method
   // This has the same name as the class
   // This section is the setup portion of the program
   // Initialize your variables and construct your program objects here.
	public BasicGameApp() {
      
      setUpGraphics();
       
      //variable and objects
      //create (construct) the objects needed for the game and load up 
		myminionPic = Toolkit.getDefaultToolkit().getImage("Minion 2.png"); //load the picture
		myminion = new enemy(300,500, 10, 6);

		patrickPic = Toolkit.getDefaultToolkit().getImage("gru.png");
		patrick = new Astronaut (0, 0,7, 4);
		minionPic = Toolkit.getDefaultToolkit().getImage("minionwithteddybear.png");
		minion = new enemy (75,75, 3, 3);
		banana = new food (1,1,5,5);
		bananacluster = new food (500,500 , 10, 10);
		jetpack = new enemy (700, 500, 4, 5);
		oceanPic = Toolkit.getDefaultToolkit().getImage("cartoon_ocean.jpeg");
		junglePic = Toolkit.getDefaultToolkit().getImage("jungle.jpeg");
		icePic = Toolkit.getDefaultToolkit().getImage("icecave.jpeg");
		bananaPic = Toolkit.getDefaultToolkit().getImage("banana.png");
		bananaclusterPic = Toolkit.getDefaultToolkit().getImage("bananacluster.png");
		jetpackPic = Toolkit.getDefaultToolkit().getImage("jetpack.png");

	}// BasicGameApp()

   
//*******************************************************************************
//User Method Section
//
// put your code to do things here.

   // main thread
   // this is the code that plays the game after you set things up
	public void run() {


		for (int i = 0; i < bananaArray.length; i ++){
			food mybanana = new food((int)(Math.random() * 1000), (int)(Math.random() * 700), 5, 5);
			bananaArray[i] = mybanana;
		}

      //for the moment we will loop things forever.
		while (true) {
		for (int i = 0; i < 250; i++) {
			moveThings();  //move all the game objects
			collisions();
			render();  // paint the graphics
			pause(20); // sleep for 10 ms
		}


		}
	}
	public void moveThings()
	{
      //calls the move( ) code in the objects
		myminion.move();
		patrick.move();
		minion.move();
		banana.move();
		jetpack.move();
		bananacluster.move();
		for (int i = 0; i < bananaArray.length; i ++){
			bananaArray[i].move();
		}
	}

	public void collisions() {
		if (myminion.rec.intersects(minion.rec) && myminion.isIntersecting == false) {
			myminion.isIntersecting = true;
			myminion.dx = myminion.dx + 7;
			myminion.dy = myminion.dy + 5;
			minion.dx = minion.dx + 7;
			minion.dy = minion.dy + 5;
			myminion.isAlive = false;
			System.out.println("astro has died");
		}
		for (int i = 0; i < bananaArray.length; i++) {
			if (minion.rec.intersects(bananaArray[i].rec) && minion.isIntersecting== false) {
				minion.height = minion.height + 1;
				minion.width = minion.width + 1	;
				minion.isIntersecting = true;
			} else if (!minion.rec.intersects(bananaArray[i].rec)) ;
				minion.isIntersecting = false;
				}
				if (minion.rec.intersects(banana.rec) && minion.isEating == false) {
					minion.height = minion.height + 5;
					minion.width = minion.width + 5;
					minion.isEating = true;
				}
				if (minion.rec.intersects(bananacluster.rec) && minion.isEating == false) {
					minion.height = minion.height + 15;
					minion.width = minion.width + 15;
					minion.isEating = true;
				}
				if (jetpack.rec.intersects(minion.rec)) {
					jetpack.xpos = minion.xpos;
					jetpack.ypos = minion.ypos;
				}
				if (minion.leftRec.intersects(patrick.rec) && minion.isIntersecting == false) {
					minion.dx = -minion.dx;
					minion.isIntersecting = true;
				}
				if (minion.rightRec.intersects(patrick.rec) && minion.isIntersecting == false) {
					minion.dx = -minion.dx;
					minion.isIntersecting = true;
				}

				if (minion.topRec.intersects(patrick.rec) && minion.isIntersecting == false) {
					minion.dy = -minion.dy;
					minion.isIntersecting = true;

				}
				if (minion.bottomRec.intersects(patrick.rec) && minion.isIntersecting == false) {
					minion.dy = -minion.dy;
					minion.isIntersecting = true;
				}
				if (minion.xpos == 1000 || minion.ypos == 700 || minion.xpos == 0 || minion.ypos == 0) {
					minion.isEating = false;
					minion.isIntersecting = false;

				}
				if (jetpack.rec.intersects(myminion.rec)) {
					jetpack.xpos = myminion.xpos;
					jetpack.ypos = myminion.ypos;
				}
				if (myminion.bottomRec.intersects(patrick.rec) && myminion.isIntersecting == false) {
					myminion.dy = -myminion.dy;
					myminion.isIntersecting = true;
				}
				if (myminion.topRec.intersects(patrick.rec) && myminion.isIntersecting == false) {
					myminion.dy = -myminion.dy;
					myminion.isIntersecting = true;
				}
				if (myminion.leftRec.intersects(patrick.rec) && myminion.isIntersecting == false) {
					myminion.dx = -myminion.dx;
					myminion.isIntersecting = true;
				}
				if (myminion.rightRec.intersects(patrick.rec) && myminion.isIntersecting == false) {
					myminion.dx = -myminion.dx;
					myminion.isIntersecting = true;
				}
				if (patrick.rec.intersects(myminion.rec) && patrick.isIntersecting == false) {
					patrick.xpos = 500;
					patrick.ypos = 350;
					patrick.isIntersecting = true;
				}

			}

	//Pauses or sleeps the computer for the amount specified in milliseconds
   public void pause(int time ){
   		//sleep
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

			}
   }

   //Graphics setup method
   private void setUpGraphics() {
      frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.
   
      panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
      panel.setLayout(null);   //set the layout
   
      // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
      // and trap input events (Mouse and Keyboard events)
      canvas = new Canvas();  
      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);
   
      panel.add(canvas);  // adds the canvas to the panel.
   
      // frame operations
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
      frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
      frame.setResizable(false);   //makes it so the frame cannot be resized
      frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!
      
      // sets up things so the screen displays images nicely.
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();
      System.out.println("DONE graphic setup");
   
   }


	//paints things on the screen using bufferStrategy
	private void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(icePic,0,0,null );
		g.drawImage(myminionPic, myminion.xpos, myminion.ypos, myminion.width, myminion.height, null);
		g.drawImage(patrickPic, patrick.xpos, patrick.ypos, patrick.width, patrick.height, null);
		g.drawImage(minionPic, minion.xpos, minion.ypos, minion.width, minion.height, null);
		g.drawImage(bananaPic, banana.xpos, banana.ypos, banana.width, banana.height, null);
		g.drawImage(jetpackPic, jetpack.xpos, jetpack.ypos, jetpack.width, jetpack.height,null );
		g.drawImage(bananaclusterPic, bananacluster.xpos, bananacluster.ypos, bananacluster.width, bananacluster.height, null);
		for (int i = 0; i < bananaArray.length; i ++){
			g.drawImage(bananaPic, bananaArray[i].xpos, bananaArray[i].ypos, bananaArray[i].width, bananaArray[i].height, null);

		}

		g.dispose();

		bufferStrategy.show();
	}
}