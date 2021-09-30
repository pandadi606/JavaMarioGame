/*
* Project: ics3u
* Package: graphics
* Class: Mario   
* Programmer: Aditya Pandya
* Date Created: 11/06/2020
* Description:  Begins the Mario game
*/	
package FinalProject;

//some import statements 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Timer;
import java.util.TimerTask;


public class Mario extends JFrame implements KeyListener
{
JPanel myPanel;//setting the variable for my panel
LayoutManager myLayout; //setting the variable for my layout 
int random = (int)((Math.random()*3000)+ 300);//setting the variable for creating a random integer for my random distance 
int cordX = 10;//setting the variable for the coordinates of the background
int cordY = 10;//setting the variable for the y 
Timer myTimer;//setting the variable for creating a timer for all the timers I am going to use
Timer marioTimer;//setting the variable for creating a timer for all the timers I am going to use
int marioX = 100;//setting the variable for  mario x coord
int marioY = 617;//setting the variable for mario y coord
int goombaX = random + 100;//setting the variable for  goomba x coord
int goombaY = 650;//setting the variable for  goomba y coord

int goombaMove = 10;//setting the variable for how much the goomba moves 
String goombaImage = "goomba.png";//setting the variable for the goomba image
int pipeX = random;//setting the variable for the pipe x coord
int pipeY = 617;//setting the variable for the pipe y coord
int counterFlag = 0;//setting the variable for the flag coord
boolean gameOver = false;//setting the variable for the end of the game

int counterPipe = 0;//setting the variable for if in the pipe (on)
int counterInPipe = 0;//setting the variable for if in the pipe 

char c;//setting the variable for the character
String marioImage = "mario.png";//setting the variable for mario image
boolean hitBoxCheck = false;//setting the variable for the hitboxes
boolean brickJump = false;//setting the variable for the hit boxes
boolean hitPipe = false;//setting the variable for hitboxes
boolean brickHit = false;//setting the variable for hitboxes

int distancePipe = (int)((Math.random()*700) + 400);//setting the variable for the distance between pipes
int brickDistance =(int)((Math.random()*700) + 400);//setting the variable for the distance between bricks  
 
int brickX = random + brickDistance-100;//setting the variable for brick x coord
int brickY = 517;//setting the variable for  brick = y coord
int coinX =  brickX + 45;//setting the variable for coin x coord
int coinY = 517;//setting the variable for coin y coord

boolean onObstacle = false;//on obstacle 

String coinImage = "coin.png";//setting the variable for the coin image
String[] numbers = new String[10];//setting the variable for the string of number for the counter
String numOfCoins = "0" ;//setting the variable for number of coins
int i;//setting the variable for a for loop that i need access to 
int flagX = 413;//setting the variable for good flag coord
int flagY = 558;//setting the variable for good flag coord
int eFlagX = 400;//setting the variable for bad flag coord
int eFlagY = 245;//setting the variable for bad flag coord

private Image doubleBufferImage;//setting the variable for the double buffered image
private Graphics doubleBufferGraphics;//setting the variable for the graphics of the double buffered image

boolean inPipe = false;//setting the variable for in pipe boolean
boolean inPipeEnd = false;//setting the variable for in the end of pipe boolean

int counter = 0;//setting the variable for the amount of times the program goes through the method

String backgroundImage = "background.png";//setting the variable for the background image

    public Mario()   //to the name of your class
    {

		    super("Super Mario");  
		   
		    //end the program if the close button is hit, otherwise program goes forever.
			    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   
			    this.setSize(1450, 917);   //set the size of the window (frame) in pixels
			 
			    myPanel = (JPanel) this.getContentPane();
			
			    myLayout = new FlowLayout();
			    myPanel.setLayout(myLayout);   //layout to your panel
			   
			    numbers[0] = "0";//0 counter coin
			    numbers[1] = "1";//1 counter coin
			    numbers[2] = "2";//2 counter coin
			    numbers[3] = "3";//3 counter coin
			    numbers[4] = "4";//4 counter coin
			    numbers[5] = "5";//5 counter coin
			    numbers[6] = "6";//6 counter coin
			    numbers[7] = "7";//7 counter coin
			    numbers[8] = "8";//8 counter coin
			    numbers[9] = "9";//9 counter coin
			 
			    myPanel.setBackground(Color.WHITE);//setting the background
			   
			    myTimer = new Timer();//creating the new timer
			    myTimer.schedule(new UpdateWorld(),1, 50);//running the goomba movement
			    
			    marioTimer = new Timer();//creating a timer for mario movements
			    
			    addKeyListener(this);//adding keylistener
			    
			    this.setResizable(false);
			    this.setVisible(true);//setting the window as visible
    }
   



			public void paint(Graphics g) {

				doubleBufferImage = createImage(getWidth(),getHeight());//getting the width and height of the program and setting it to another paint method so that the double buffering can take effect
				doubleBufferGraphics = doubleBufferImage.getGraphics();//get the graphics
				paintComponent(doubleBufferGraphics);//paint the graphics that are on screen 
				g.drawImage(doubleBufferImage,0,0, this);//draw the graphics

			}

			public void paintComponent(Graphics g){
				super.paint(g);

					if(pipeX + distancePipe+100 <= 0 && (cordX >= -2500 || marioX >= 400))//to create new obstacles when the old ones have left the screen 
					{
						distancePipe = (int)((Math.random()*700) + 300);//randomly placing the new objects
						random = 1500;//the random image is set
						
						pipeX = random;//the first pipe is set to the random integer
						
						goombaX = random + 100;//the goomba starts moving infront of the image
						goombaY = 650;//the height remains the same
						
						goombaImage = "goomba.png";//the image is set
						
						repaint();//repaint
					}
						
					if(brickX <= 0 && (cordX >= -2500))
					{
						brickDistance = (int)((Math.random()*700)+ 300);//sets the bricks again
						brickX = random + brickDistance;//edits value for the bricks
						coinX = random + brickDistance + 45;//coins is redone as well
						coinY = 517;//coin y remains the same
						coinImage = "coin.png";//coin image is set
						gameOver = true;//gameover becomes true
					}
							Image background = Toolkit.getDefaultToolkit().getImage(backgroundImage);
							g.drawImage(background, cordX, 10, this);//painting the background
							
							Image mario = Toolkit.getDefaultToolkit().getImage(marioImage);
							g.drawImage(mario , marioX , marioY , this);//painting the mario
	
							Image goomba = Toolkit.getDefaultToolkit().getImage(goombaImage);
							g.drawImage(goomba , goombaX , goombaY , this);//painting the goomba
							
							Image pipe = Toolkit.getDefaultToolkit().getImage("mario pipe.png");
							
							g.drawImage(pipe,pipeX, pipeY,this);//painting the pipes
							g.drawImage( pipe , pipeX + distancePipe , pipeY , this);//painting the pipes
							
							Image coin = Toolkit.getDefaultToolkit().getImage(coinImage);
							g.drawImage( coin , coinX , coinY , this);//painting the coins
							
							Image coinCounter = Toolkit.getDefaultToolkit().getImage("coin.png");
							g.drawImage( coinCounter , 1300 , 100 , this);//painting the coins counter
							
							Image bricks = Toolkit.getDefaultToolkit().getImage("brick.jpg");
							g.drawImage( bricks , brickX , brickY , this);//painting the bricks
						
							g.setColor(Color.ORANGE);
							g.setFont(new Font("Broadway", Font.BOLD, 75));
							g.drawString(numOfCoins, 1350, 145);//drawing the string
						
							Image flagpole = Toolkit.getDefaultToolkit().getImage("flagpole.png");//flag pole is painted 
							Image enemyFlag = Toolkit.getDefaultToolkit().getImage("enemy flag.png"); //paint the flags
							Image marioFlag = Toolkit.getDefaultToolkit().getImage("mario flag.png");//paint the flags
							
							myTimer.schedule(new pipeClimber(), 500);//run the timers that do the actions 
							marioTimer.schedule(new marioJump(),500);//run the timers that do the actions 
							
						if((cordX == -4010 || marioX >= 400) && !inPipeEnd && cordX < -3800)
						{
							g.drawImage( flagpole, 400, 325, this);//the flag pole is drawn
							g.drawImage( enemyFlag, eFlagX, eFlagY, this);//the flag is drawn
							g.drawImage( marioFlag, flagX, flagY, this);//the flag is drawn
						}
						if(cordX <= -3810 || marioX >= 400)
						{
								if(marioX < 400)
								{	
									myTimer.schedule(new winnerWinner(), 1, 500);//Initiate the winner sequence
									
								}	
						}
					
						checkDeath();//if dead open the you lose page
}


			public void keyPressed(KeyEvent e) {

				c = e.getKeyChar();
				switch(c) {
				
				case 'w'://if they move up
				
				if(marioY > 500 || brickJump)
				{
					cordX -= 40;//map moves forward
					marioY -= 100;//mario jumps
					goombaX -= 40; //goomba comes closer
					pipeX -= 40;//pipe comes closer
					brickX -= 40;//brick comes closer
					coinX -= 40;//coin comes closer
				}
				
				break;
				
				case 's':
				
					marioImage ="mario crouch.png";//crouch image
				
				break;
				
				case 'a':
				if(cordX >= -4800 && cordX < 30) //if it is in the map
				{
					if((marioX >= (pipeX + 50)||marioX <=(pipeX - 50)) || marioY <= 600)//if infront or behind pipe
					{
						if((marioX >= (pipeX + distancePipe + 100 )|| marioX <=(pipeX + distancePipe - 100 )) || marioY <= 600)//if infront or behind pipe
						{
							cordX += 20;
							goombaX += 20;
							pipeX += 20;
							brickX += 20;
							coinX += 20;
							marioImage ="mario runBack.png";
							//map moves forward
							//mario jumps
							//goomba comes closer
							//pipe comes closer
							//brick comes closer
							//coin comes closer
						}
					}
				}
				break;
			
				case 'd':
				if(cordX >= -4000)//if it is in the map
				{
					if(((marioX >= (pipeX + 50)|| marioX <=(pipeX + -150)))|| marioY <= 600)//if infront or behind pipe
					{
						
						if((marioX + 100 < (pipeX + distancePipe)|| marioX >= (pipeX + distancePipe + 75))|| marioY <= 600)//if infront or behind pipe
						{
							marioImage = "mario run left.png";
							cordX -= 20;
							goombaX -= 20;
							pipeX -= 20;
							brickX -= 20;
							coinX -= 20;
							marioImage = "mario run.png";
							//map moves forward
							//mario jumps
							//goomba comes closer
							//pipe comes closer
							//brick comes closer
							//coin comes closer
						}
					}
				}
					break;
					
				case 'm':
					Mario marioGUI= new Mario(); //open mario gui
					gameOver = true;//gameover is true
					this.dispose();//disposes the screen
					
					break;
					
				case 'l':
					
					Luigi luigiGUI = new Luigi(); //luigi is opened
					gameOver = true;//gameover becomes true
					this.dispose();//ends screen
					break;
					}
				
			if((marioY <= (goombaY-50) &&  marioY >= (goombaY - 250)) && (marioX <= (goombaX + 100) && marioX >= (goombaX-50)))
			{
				goombaImage = "goomba.jpg.png";//goomba image is squished
				marioTimer.schedule(new goomBye(), 50);//goomba dies
			}
			
			repaint();//repaint()			
			}
			public void keyReleased(KeyEvent e) {
				
				marioImage = "mario.png";//mario returns to standing form
				repaint();
			
			}
			public void keyTyped(KeyEvent e) {
			
			}

			class UpdateWorld extends TimerTask {

				public void run() {

						goombaX += goombaMove;//allows the goomba to constantly move


						if((goombaX <= (pipeX + 50) || goombaX >= (pipeX + distancePipe - 50)))//if goomba is between the pipes
						{
							goombaMove = goombaMove*-1;//goomba moves the opposite way
						}

						repaint();//repaint;
				}
			}
			class pipeClimber extends TimerTask {

				public void run() {
					int pipe2X = pipeX + distancePipe;//pipe 2 equal to the distance between 
					
					hitBoxCheck = hitBox(marioX , marioY, pipeX, pipeY-10, 50);//hitbox method is called and used for the pipes
					hitPipe = hitBox(marioX , marioY, pipe2X, pipeY-10, 50);//hitbox method is called and used for the pipes
					
					if((marioX > coinX && marioX < coinX + 50)&&(marioY <= coinY + 50))//if brick is hit return true
					{
						brickHit = true;//if brick is hit return true
					}
					else
					{
						brickHit = false;//else false
					}
					if((marioX > brickX && marioX < coinX + 150) && (marioY <= brickY - 75))//if its ontop of the brick
					{
						brickJump = true;//return true
					}
					else
					{
						brickJump = false;//else return false
					}
					if(hitBoxCheck||hitPipe)
					{
						marioY = pipeY - 100;//mario stands on pipe
						onObstacle = true;//return on obstacle
						if(hitPipe && counterInPipe < 1)
						{
							backgroundImage = "under the pipe.png";//if on the second pipe then enter underground
							inPipe = true;//in pipe is true
							counterInPipe++;//counter pipe is called and added
						}
					}
					else if(brickJump)//if on brick
					{
						onObstacle = true;//on brick then on obstacle
						marioY = brickY - 100;//put mario on brick
					}
					else if(brickHit)
					{
						coinY -= 50;//coin moves up
						i++;//adds to the number in the corner
						numOfCoins = numbers[i];//sets it to the variable drawn
					}
					else
					{
						onObstacle = false;//if not on an obstacle then false
					}
					if(cordX <= -3800 && inPipe)
					{
						counterFlag ++;//counterflag is added
						inPipe = false;//in pipe is false
						inPipeEnd = true;// in the end its true
						
					}
					repaint();//repaint
				}
			}
		class goomBye extends TimerTask {

			public void run() {
				goombaImage = "";//goomba dies
				goombaY = 0;//goomba dies
				goombaX = 0;//goomba dies
				repaint();//goomba dies
			}
		}

		public void checkDeath() {
		if((marioY >= goombaY-100 && marioY <= goombaY )  && (marioX <= (goombaX + 50) && marioX >= (goombaX-50)))
			{
				gameOver = true;//gameover becomes true
				repaint();
				if(counter < 1)
				{
					YouLose myGUI = new YouLose();//open the ending
					counter++;//only open once
					this.dispose();//dispose screen
				}
			}

		}

		class coinBye extends TimerTask {

			public void run() {

				coinImage = "";
			}
		}
		public boolean hitBox(int marioX, int marioY, int pipeX, int pipeY, int hitBox)
		{
			if((marioY < (pipeY) &&  marioY >= (pipeY - 400)) && (marioX <= (pipeX + hitBox) && marioX >= (pipeX - 50)))
			{
				return true;//return true if the hit box is hit
			}
			else
			{
				return false;//return false if not hit
			}
		}
		class winnerWinner extends TimerTask {
			public void run() {
		
				if(marioX < 400 && backgroundImage.equals("background.png") && cordX < -3800)
				{				
					marioX +=  10;//mario moves forward
					repaint();
				}
				
				if(counter < 1 && !inPipeEnd && marioX >= 400 && cordX < -3800)
				{
					counter++;//open the ending
					YouLose myGUI = new YouLose();
				}
				
				else if(inPipeEnd && cordX < -3800)
				{
					cordX -= 10;//map moves forward
					if(cordX < -4400)
					{
						cordX = 10;//the cords are at 10
						backgroundImage = "background.png";//reset the background
						counterPipe = 1;//only occurs once
					}
				}
				else if(cordX >= -3800)
				{
					if(eFlagY < 515)
					{
						eFlagY += 5;//moves enemy flag down
						flagY -= 3;//moves good flag up
						repaint();
					}

				}
				if(cordX >= 0)
				{
					inPipeEnd = false;//in pipe end is now false
				}
				
			}
		}
		class marioJump extends TimerTask {

			public void run() {
				if(marioY < 617 && !onObstacle)
				{
					marioY += 10;//mario moves down slowly
				}
			}
		}
}


